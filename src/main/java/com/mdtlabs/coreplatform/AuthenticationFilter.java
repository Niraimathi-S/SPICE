package com.mdtlabs.coreplatform;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserTenantsContextHolder;
import com.mdtlabs.coreplatform.common.exception.Validation;
import com.mdtlabs.coreplatform.common.logger.Logger;
import com.mdtlabs.coreplatform.common.model.dto.RoleDTO;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.entity.UserToken;
import com.mdtlabs.coreplatform.common.repository.CommonRepository;
import com.mdtlabs.coreplatform.common.repository.GenericRepository;
import com.mdtlabs.coreplatform.common.service.UserTokenService;
import com.mdtlabs.coreplatform.common.util.DateUtil;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * Used to do internal filter on token validation
 * 
 * @author Prabu created on Oct 06, 2022
 */
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	private RSAPrivateKey privateRsaKey = null;

	private String apiRequest = Constants.EMPTY;

	public RSAPublicKey publicRsaKey;

	public Map<String, Map<String, List<String>>> apiPermissionMap = new HashMap<>();

	private static final List<MediaType> VISIBLE_TYPES = Arrays.asList(MediaType.valueOf(Constants.TEXT),
			MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.valueOf(Constants.APPLICATIONJSON), MediaType.valueOf(Constants.APPLICATION_XML),
			MediaType.MULTIPART_FORM_DATA);

	org.apache.logging.log4j.Logger log = LogManager.getLogger(AuthenticationFilter.class);

	@Value("${app.private-key}")
	private String privateKey;

	@Autowired
	public CommonRepository commonRepository;

	@Autowired
	public GenericRepository<UserToken> genericRepository;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private UserTokenService userTokenService;

	private RestTemplate restService = new RestTemplate();

	private ModelMapper modelMapper = new ModelMapper();

	@Value("${app.public-key}")
	private String publicKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getRequestURI().contains("/forgot-password") || request.getRequestURI().contains("/update-password")
				|| request.getRequestURI().contains("/login-limit-exceed")
				|| request.getRequestURI().contains("/is-forget-password-limit-exceed")
				|| request.getRequestURI().contains("/is-reset-password-limit-exceed")
				|| request.getRequestURI().contains("/webjars/swagger-ui")
				|| request.getRequestURI().contains("/v3/api-docs")
				|| request.getRequestURI().contains("/generate-token")) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(null, null, null);
			SecurityContextHolder.getContext().setAuthentication(auth);
			filterChain.doFilter(request, response);
		} else {
			String token = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (!token.isBlank() && token.startsWith(Constants.BEARER)) {
				String tenantId = request.getHeader(Constants.HEADER_TENANT_ID);
				if (!tenantId.isBlank() && tenantId.matches("[0-9]+")) {
					UserSelectedTenantContextHolder.set(Long.parseLong(tenantId));
				}
				UserDTO userDto = null;
				try {
					userDto = validateAspect(token.substring(Constants.BEARER.length(), token.length()), response);
					if (null != userDto.getAuthorization()) {
						String username = userDto.getUsername();
						if (username != null) {
							UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,
									null, null);
							SecurityContextHolder.getContext().setAuthentication(auth);
						}
					}

//					if (apiPermissionMap.isEmpty()) {
						commonRepository.getApiRolePermission().stream().forEach(api -> {
							if (StringUtils.isNotBlank(api.getRoles())) {
								Map<String, List<String>> apiRoleMap = new HashMap<>();
								if (apiPermissionMap.get(api.getMethod()) == null) {
									apiRoleMap = new HashMap<>();
								} else {
									apiRoleMap = apiPermissionMap.get(api.getMethod());
								}
								apiRoleMap.put(api.getApi(), Arrays.asList(api.getRoles().split("\\s*,\\s*")));
								apiPermissionMap.put(api.getMethod(), apiRoleMap);
							}
						});
//					}
					Set<String> requestTypeSet = apiPermissionMap.get(request.getMethod()).keySet();
					requestTypeSet.stream().forEach(requestType -> {
						if (request.getRequestURI().contains(requestType)) {
							apiRequest = requestType;
						}
					});
					boolean isExist = false;
					for (RoleDTO role : userDto.getRoles()) {
						if (apiPermissionMap.get(request.getMethod()).get(apiRequest).contains(
								role.getName())) {
							isExist = true;
							break;
						}
					}
					if (isExist) {
						doLogApi(wrapRequest(request), wrapResponse(response), filterChain);
					} else {
						throw new Validation(20001);
					}
				} catch (JsonProcessingException | ParseException e) {
					Logger.logError(e);
					throw new Validation(20001);
				}
			} else {
				throw new Validation(20001);
			}
		}
	}

	/**
	 * used to validate the authentication token
	 * 
	 * @param jwtToken - jwt token of the logged in user
	 * @return UserDTO - user information
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */

	public UserDTO validateAspect(String jwtToken, HttpServletResponse response)
			throws ParseException, JsonProcessingException {

		if (StringUtils.isBlank(jwtToken)) {
			jwtToken = Constants.SPACE;
		}
		if (null == privateRsaKey) {
			tokenDecrypt();
		}

		EncryptedJWT jwt;
		try {
			jwt = EncryptedJWT.parse(jwtToken);
		} catch (ParseException e) {
			Logger.logError(e);
			throw new Validation(20002);
		}
		RSADecrypter decrypter = new RSADecrypter(privateRsaKey);
		try {
			jwt.decrypt(decrypter);
		} catch (JOSEException e) {
			Logger.logError(e);
			throw new Validation(20002);
		}
		Object tenants = jwt.getJWTClaimsSet().getClaim(Constants.TENANT_IDS_CLAIM);
		DateFormat pstFormat = new SimpleDateFormat(Constants.JSON_DATE_FORMAT);
		Date expDateJwt = pstFormat.parse(pstFormat.format(jwt.getJWTClaimsSet().getClaim(Constants.EXP)));
		Date currentDate = pstFormat.parse(pstFormat.format(DateUtil.formatDate(new Date())));
		UserDTO userDetail = null;
		String rawJson = String.valueOf(jwt.getJWTClaimsSet().getClaim(Constants.USER_DATA));

		ObjectMapper objectMapper = new ObjectMapper();
		userDetail = objectMapper.readValue(rawJson, UserDTO.class);
		userDetail.setAuthorization(jwtToken);
		if (null != tenants) {
			String data = tenants.toString();
			List<Integer> tenantIds = Arrays.asList(data.split(",")).stream().map(s -> Integer.parseInt(s.trim()))
					.collect(Collectors.toList());
			UserTenantsContextHolder.set(tenantIds);
		}
		if (null != userDetail.getTimezone()) {
			CustomDateSerializer.USER_ZONE_ID = userDetail.getTimezone().getOffset();
		}

		UserToken userToken = userTokenService.getUserToken(jwtToken);

		boolean isTokenActive = false;

		if (!Objects.isNull(userToken) && userToken.isActive()) {
			isTokenActive = true;
		}

		if (!isTokenActive) {
//			userTokenService.deleteUserTokenByToken(jwtToken, userToken.getUserId());
			throw new ExpiredJwtException(null, null, ErrorConstants.TOKEN_EXPIRED);
		}

		if ((expDateJwt.getTime() - currentDate.getTime()) / (60 * 1000) < Constants.ZERO) {
			throw new Validation(20002);
//			ResponseEntity<Map> userResponse = restService.exchange(
//					getUserInfo() + "/user-service/user/getRefreshToken/" + userDetail.getId(), HttpMethod.GET, null,
//					Map.class);
//			User loggedInUser = modelMapper.map(userResponse.getBody().get(Constants.ENTITY), User.class);
//			String refreshToken = loggedInUser.getRefreshToken();
//
//			EncryptedJWT jwtRefresh;
//			try {
//				jwtRefresh = EncryptedJWT
//						.parse(refreshToken.substring(Constants.BEARER.length(), refreshToken.length()));
//			} catch (ParseException e) {
//				Logger.logError(e);
//				throw new Validation(3013);
//			}
//			try {
//				jwtRefresh.decrypt(decrypter);
//			} catch (JOSEException e) {
//				Logger.logError(e);
//				throw new Validation(3013);
//			}
//			Date expDateRefresh = pstFormat
//					.parse(pstFormat.format(jwtRefresh.getJWTClaimsSet().getClaim(Constants.EXP)));
//
//			if ((expDateJwt.getTime() - currentDate.getTime()) / (Constants.SIXTY * Constants.THOUSAND) < Constants.ZERO
//					&& (expDateRefresh.getTime() - currentDate.getTime()) / Constants.THOUSAND < Constants.ZERO) {
////				userTokenService.deleteUserTokenByToken(jwtToken, userToken.getUserId());
//				throw new ExpiredJwtException(null, null, Constants.TOKEN_EXPIRED);
//			} else {
////				Map<String, Object> userInfo = new ObjectMapper().convertValue(userDetail, Map.class);
////				try {
////					generateKey();
////					newAuthToken = authTokenCreation(userDetail, userInfo);
////					newRefreshToken = refreshTokenCreation(userDetail);
////				updateUserToken(userDetail.getId(), newAuthToken, newRefreshToken);
//				updateUserToken(userDetail.getId(), jwtToken);
////				} catch (JOSEException e) {
////					Logger.logError(Constants.JOSE_EXCEPTION + e);
////				} catch (Exception e) {
////					Logger.logError(Constants.EXCEPTION_DURING_TOKEN_UTIL, e);
////				}
//			}
//			response.setHeader(org.springframework.http.HttpHeaders.AUTHORIZATION, newAuthToken);
//			response.setHeader(Constants.REFRESH_TOKEN, newRefreshToken);

		} else {
			UserContextHolder.setUserDto(userDetail);
			return userDetail;
		}
//		return userDetail;
	}

	/**
	 * This method is used to generate key
	 * 
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private void generateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		Resource resource = new ClassPathResource(publicKey);
		byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(bdata);
		KeyFactory kf = KeyFactory.getInstance(Constants.RSA);
		publicRsaKey = (RSAPublicKey) kf.generatePublic(spec);
	}

	/**
	 * <p>
	 * Decrypt given jwe token using private key.
	 * </p>
	 */
	private void tokenDecrypt() {
		try {
			Resource resource = new ClassPathResource(privateKey);
			byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bdata);
			KeyFactory kf = KeyFactory.getInstance(Constants.RSA);
			this.privateRsaKey = (RSAPrivateKey) kf.generatePrivate(privateKeySpec);
		} catch (Exception execption) {
			Logger.logError(ErrorConstants.EXCEPTION_DURING_TOKEN_UTIL, execption);
		}

	}

	/**
	 * This method is used to log request and response of api
	 * 
	 * @param request     - api request
	 * @param response    - api response
	 * @param filterChain - the chain proceeding of flow
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doLogApi(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response,
			FilterChain filterChain) throws ServletException, IOException {
		try {
			beforeRequest(request, response);
			filterChain.doFilter(request, response);
		} finally {
			afterRequest(request, response);
			response.copyBodyToResponse();
		}
	}

	/**
	 * This method is used to log the request details of api
	 * 
	 * @param request  - api request
	 * @param response - api response
	 * @throws IOException
	 */
	protected void beforeRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response)
			throws IOException {
		logRequestHeader(request, request.getRemoteAddr() + Constants.LOG_PREFIX_REQUEST);
	}

	/**
	 * This method is used to log the response details of api
	 * 
	 * @param request  - api request
	 * @param response - api response
	 * @throws IOException
	 */
	protected void afterRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
		logRequestBody(request, request.getRemoteAddr() + Constants.LOG_PREFIX_REQUEST);
		logResponse(response, request.getRemoteAddr() + Constants.LOG_PREFIX_RESPONSE);
	}

	/**
	 * This method is used to log request header details of api
	 * 
	 * @param request - api request
	 * @param prefix  - prefix text in log
	 * @throws IOException
	 */
	private void logRequestHeader(ContentCachingRequestWrapper request, String prefix) throws IOException {
		log.info("{} {} {}", prefix, request.getMethod(), request.getRequestURI());
		byte[] content = request.getContentAsByteArray();
		String contentString = new String(content, request.getCharacterEncoding());
		Stream.of(contentString.split(Constants.SPLIT_CONTENT)).forEach(line -> log.info("{}", line));
	}

	/**
	 * This method is used to log request body details of api
	 * 
	 * @param request - api request
	 * @param prefix  - prefix text in log
	 */
	private void logRequestBody(ContentCachingRequestWrapper request, String prefix) {
		byte[] content = request.getContentAsByteArray();
		if (content.length > Constants.ZERO) {
			logContent(content, request.getContentType(), request.getCharacterEncoding(), prefix);
		}
	}

	/**
	 * This method is used to log response details of api
	 * 
	 * @param response - api response
	 * @param prefix   - prefix text in log
	 * @throws IOException
	 */
	private void logResponse(ContentCachingResponseWrapper response, String prefix) {
		int status = response.getStatus();
		log.info("{} {} {}", prefix, status, HttpStatus.valueOf(status).getReasonPhrase());
		byte[] content = response.getContentAsByteArray();
		if (content.length > Constants.ZERO) {
			logContent(content, response.getContentType(), response.getCharacterEncoding(), prefix);
		}
	}

	/**
	 * This method is used to print log on console
	 * 
	 * @param content         - log content
	 * @param contentType     - content type
	 * @param contentEncoding - content encoding type
	 * @param prefix          - prefix text in log
	 */
	private void logContent(byte[] content, String contentType, String contentEncoding, String prefix) {
		MediaType mediaType = MediaType.valueOf(contentType);
		boolean visible = VISIBLE_TYPES.stream().anyMatch(visibleType -> visibleType.includes(mediaType));
		if (visible) {
			try {
				String contentString = new String(content, contentEncoding);
				boolean logInfo = true;
				if (contentString.startsWith("{") && contentString.endsWith("}")) {
					JSONObject json = new JSONObject(contentString);
					if (json.has("entityList") && json.get("entityList") instanceof JSONArray) {
						JSONArray entityList = (JSONArray) json.get("entityList");
						if (entityList.length() > 1) {
							logInfo = false;
						}
					}
				}
				if (logInfo) {
					Stream.of(contentString.split(Constants.SPLIT_CONTENT)).forEach(line -> log.info("{}", line));
				}
			} catch (UnsupportedEncodingException e) {
				log.info("{} [{} bytes content]", prefix, content.length);
			}
		} else {
			log.info("{} [{} bytes content]", prefix, content.length);
		}
	}

	/**
	 * This method is used to collect the request details of api
	 * 
	 * @param request - api request
	 * @return ContentCachingRequestWrapper - request wrapper
	 */
	private static ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
		if (request instanceof ContentCachingRequestWrapper) {
			return (ContentCachingRequestWrapper) request;
		} else {
			return new ContentCachingRequestWrapper(request);
		}
	}

	/**
	 * This method is used to collect the response details of api
	 * 
	 * @param response - api response
	 * @return ContentCachingResponseWrapper - response wrapper
	 */
	private static ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
		if (response instanceof ContentCachingResponseWrapper) {
			return (ContentCachingResponseWrapper) response;
		} else {
			return new ContentCachingResponseWrapper(response);
		}
	}

	/**
	 * This method is used to create authorization token
	 * 
	 * @param user     - user information is passed through DTO
	 * @param userInfo - user data is passed in map format
	 * @return - String - jwt encrypted authorization token
	 * @throws JOSEException
	 */
	private String authTokenCreation(UserDTO user, Map<String, Object> userInfo) throws JOSEException {
		JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
		claimsSet.issuer(Constants.TOKEN_ISSUER);
		claimsSet.subject(Constants.AUTH_TOKEN_SUBJECT);

		claimsSet.claim(Constants.USER_ID_PARAM, user.getId());
		claimsSet.claim(Constants.USER_DATA, userInfo);
		claimsSet.claim(Constants.APPLICATION_TYPE, Constants.WEB);

		claimsSet.expirationTime(
				Date.from(ZonedDateTime.now().plusMinutes(Constants.AUTH_TOKEN_EXPIRY_MINUTES).toInstant()));
		claimsSet.notBeforeTime(new Date());
		claimsSet.jwtID(UUID.randomUUID().toString());

		JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
		EncryptedJWT jwt = new EncryptedJWT(header, claimsSet.build());
		RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);
		jwt.encrypt(encrypter);
		return Constants.BEARER.concat(jwt.serialize());
	}

	/**
	 * This method is used to create refresh token
	 * 
	 * @param user - user information is passed through DTO
	 * @return - String - jwt encrypted refresh token
	 * @throws JOSEException
	 */
	private String refreshTokenCreation(UserDTO user) throws JOSEException {
		JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
		claimsSet.issuer(Constants.TOKEN_ISSUER);
		claimsSet.subject(Constants.REFRESH_TOKEN_SUBJECT);
		claimsSet.claim(Constants.USER_ID_PARAM, user.getId());
		claimsSet.claim(Constants.APPLICATION_TYPE, Constants.WEB);
		claimsSet.expirationTime(
				Date.from(ZonedDateTime.now().plusMinutes(Constants.REFRESH_TOKEN_EXPIRY_HOURS).toInstant()));
		claimsSet.notBeforeTime(new Date());
		claimsSet.jwtID(UUID.randomUUID().toString());
		JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
		EncryptedJWT jwt = new EncryptedJWT(header, claimsSet.build());
		RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);
		jwt.encrypt(encrypter);
		return Constants.BEARER.concat(jwt.serialize());
	}

	/**
	 * To create user token
	 * 
	 * @param userId          - id of the user
	 * @param jwtToken        - jwt token of the logged in user
	 * @param jwtRefreshToken - refresh token of the logged in user
	 */
//	private void createUserToken(long userId, String jwtToken, String jwtRefreshToken) {
//		UserToken usertoken = new UserToken();
//		usertoken.setUserId(userId);
//		usertoken.setAuthToken(jwtToken);
//		usertoken.setRefreshToken(jwtRefreshToken);
//		genericRepository.save(usertoken);
//	}

	/**
	 * <p>
	 * This method is used to get the user.
	 * </p>
	 * service URL from service discovery.
	 * 
	 * @return String
	 */
	private String getUserInfo() {
		String ipInfo = Constants.EMPTY;
		ServiceInstance instance = null;
		try {
			List<ServiceInstance> instanceList = discoveryClient.getInstances(Constants.TOKEN_ISSUER.toUpperCase());
			if (!instanceList.isEmpty()) {
				instance = instanceList.get(Constants.ZERO);
			}
			if (null != instance) {
				ipInfo = instance.getUri().toString();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return ipInfo;
	}

}