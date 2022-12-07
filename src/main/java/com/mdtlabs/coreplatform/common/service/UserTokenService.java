package com.mdtlabs.coreplatform.common.service;

import java.util.List;
import java.util.Optional;

import com.mdtlabs.coreplatform.common.model.entity.ApiRolePermission;
import com.mdtlabs.coreplatform.common.model.entity.UserToken;

/**
 * This an interface class for UserToken entity
 *
 * @author Jeyaharini T A
 */
public interface UserTokenService {

	/**
	 * To save the UserToken
	 * 
	 * @param userToken
	 * @return UserToken
	 */
	public UserToken saveUserToken(UserToken userToken);

	/**
	 * This method used to get UserToken by given auth token.
	 *
	 * @param jwtToken
	 * @return UserToken
	 */
	UserToken getUserToken(String jwtToken);

	/**
	 * This method used to get all UserTokens by given userId.
	 *
	 * @param userId user Id
	 * @return List<UserToken>
	 */
	Optional<List<UserToken>> getUserTokenByUserID(Long userId);

	/**
	 * This method used to get the UserToken by user id and refresh token
	 * 
	 * @param userId
	 * @param refreshToken
	 * @return UserToken
	 */
	public UserToken validateRefreshToken(long userId, String refreshToken);

	/**
	 * <p>
	 * This method used to delete all UserTokens by given authToken.
	 * </p>
	 *
	 * @param authToken
	 * @param userId    userId
	 * @return int
	 */
	int deleteUserTokenByToken(String authToken, Long userId);

	/**
	 * <p>
	 * This method used to delete all UserTokens by given userId.
	 * </p>
	 *
	 * @param userId user Auth token
	 * @return int
	 */
	int deleteUserTokenByUserID(Long userId);

	/**
	 * <p>
	 * This method used to delete all UserTokens by given authToken.
	 * </p>
	 *
	 * @param authTokenList list of auth token
	 * @param userId        userId
	 * @return int
	 */
	int deleteUserTokenByToken(List<String> authTokenList, Long userId);

	/**
	 * This method used to get the api's with role which has permissions to access
	 * 
	 * @return
	 */
	List<ApiRolePermission> getApiRolePermissions();

}