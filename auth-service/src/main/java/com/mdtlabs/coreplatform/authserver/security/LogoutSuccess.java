package com.mdtlabs.coreplatform.authserver.security;

import java.util.Objects;

import javax.cache.CacheManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.mdtlabs.coreplatform.common.CacheManagerConfig;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.AuthUserDTO;
import com.mdtlabs.coreplatform.common.service.UserTokenService;

/**
 * <p>
 * <tt>LogoutSuccess</tt> to handle successful logout.
 * </p>
 *
 * @author Vigneshkumar Created on 16 Oct 2020
 *
 */
public class LogoutSuccess implements LogoutHandler {

	@Autowired
	UserTokenService userTokenService;

	@Autowired
	private CacheManagerConfig cacheManagerConfig;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		AuthUserDTO authUserDto = getLoggedInUser();
		if (!Objects.isNull(authUserDto)) {

			String token = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (Objects.isNull(token)) {
				throw new DataNotFoundException(20002);
			}

			token = token.substring(Constants.BEARER.length(), token.length());
			userTokenService.deleteUserTokenByToken(token, authUserDto.getId());
			for (String name : cacheManagerConfig.cacheManager().getCacheNames()) {
				cacheManagerConfig.cacheManager().getCache(name).clear(); // clear cache by name
			}

		} else {
			System.out.println(" Session expired for the user to logout... ");
		}

		// super.onLogoutSuccess(request, response, authentication);
	}

	/**
	 * To get logged in user details.
	 *
	 * @return UserDTO - user information
	 */
	private AuthUserDTO getLoggedInUser() {
		if (null == SecurityContextHolder.getContext() || null == SecurityContextHolder.getContext().getAuthentication()
				|| null == SecurityContextHolder.getContext().getAuthentication().getPrincipal()) {
			return null;
		}
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals(Constants.ANONYMOUS_USER)) {
			return null;
		}
		return new ModelMapper().map(SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
				AuthUserDTO.class);
	}

}
