package com.mdtlabs.coreplatform.common.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.model.entity.ApiRolePermission;
import com.mdtlabs.coreplatform.common.model.entity.UserToken;
import com.mdtlabs.coreplatform.common.repository.CommonRepository;
import com.mdtlabs.coreplatform.common.repository.UserTokenRepository;
import com.mdtlabs.coreplatform.common.service.UserTokenService;

/**
 * 
 * This an Service class for UserToken
 * 
 * @author Jeyaharini T A
 */
@Service("commonUserTokenService")
//@Slf4j
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private CommonRepository commonRepository;

	/**
	 * {@inheritDoc}
	 */
	@Cacheable(value = "tokens", key = "#userToken.authToken")
	public UserToken saveUserToken(UserToken userToken) {
		return userTokenRepository.save(userToken);
	}

	/**
	 * {@inheritDoc}
	 */
	@Cacheable(value = "tokens", key = "#jwtToken")
	public UserToken getUserToken(String jwtToken) {
		return userTokenRepository.findByAuthToken(jwtToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<List<UserToken>> getUserTokenByUserID(Long userId) {

		Optional<List<UserToken>> getAllByUserId = userTokenRepository.findAllByUserId(userId);
		return getAllByUserId;
	}

	/**
	 * {@inheritDoc}
	 */
	public UserToken validateRefreshToken(long userId, String refreshToken) {
		return userTokenRepository.findByUserIdAndRefreshToken(userId, refreshToken);
	}

	/**
	 * {@inheritDoc}
	 */
	@CacheEvict(value = "tokens", key = "#authToken")
	public int deleteUserTokenByToken(String authToken, Long userId) {

		int deleted = userTokenRepository.deleteByAuthToken(authToken, userId);
		return deleted;
	}

	/**
	 * {@inheritDoc}
	 */
	public int deleteUserTokenByUserID(Long userId) {

		int deleted = userTokenRepository.deleteByUserId(userId);
		return deleted;
	}

	/**
	 * {@inheritDoc}
	 */
	public int deleteUserTokenByToken(List<String> authTokenList, Long userId) {

		int deleted = userTokenRepository.deleteByAuthTokens(authTokenList, userId);
		return deleted;
	}

	/**
	 * {@inheritDoc}
	 */
	@Cacheable("apiRolePermissions")
	public List<ApiRolePermission> getApiRolePermissions() {
		return commonRepository.getApiRolePermission();
	}
}