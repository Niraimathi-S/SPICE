package com.mdtlabs.coreplatform.common.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdtlabs.coreplatform.common.model.entity.UserToken;

/**
 * <p>
 * This is the repository class for communicate link between server side and
 * database. This class used to perform all the user module action in database.
 * In query annotation (nativeQuery = true) the below query perform like SQL.
 * Otherwise its perform like HQL default value for nativeQuery FALSE
 * </p>
 *
 */
@Repository("CommonUserTokenRepository")
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

//	String DELETE_BY_TOKEN_AND_USER_ID = "delete from UserToken as userToken where userToken.authToken IN (:authTokenList) AND userToken.userId = :userId and userToken.isActive = true";
//	
	String DELETE_BY_TOKEN_AND_USER_ID = "Update UserToken as userToken SET isActive = false where userToken.authToken = :authToken AND userToken.userId = :userId and userToken.isActive = true";

	String DELETE_BY_USERID = "update UserToken as userToken SET isActive=false where userToken.userId = :userId and userToken.isActive = true";

	String GET_TOKENS_BY_USERID = "select userToken from UserToken as userToken where userToken.userId =:userId and userToken.isActive = true";

	String DELETE_BY_TOKENS_AND_USER_ID = "Update UserToken as userToken SET isActive = false where userToken.authToken IN (:authTokenList) AND userToken.userId = :userId and userToken.isActive = true";

	/**
	 * Used to get the UserToken by authToken
	 * 
	 * @param jwtToken
	 * @return UserToken
	 */
	UserToken findByAuthToken(String jwtToken);

	/**
	 * Used to get the list of active UserToken(s) by user id
	 * 
	 * @param userId
	 * @return list of UserToken
	 */
	@Query(value = GET_TOKENS_BY_USERID)
	Optional<List<UserToken>> findAllByUserId(Long userId);

	/**
	 * Used to get the UserToken by user id and refresh token
	 * 
	 * @param userId
	 * @param refreshToken
	 * @return UserToken
	 */
	UserToken findByUserIdAndRefreshToken(long userId, String refreshToken);

	/**
	 * <p>
	 * Used to delete the UserToken by authToken.
	 * </p>
	 *
	 * @return int
	 */
	@Query(value = DELETE_BY_TOKEN_AND_USER_ID)
	@Modifying
	@Transactional
	int deleteByAuthToken(String authToken, Long userId);

	/**
	 * <p>
	 * Used to delete the UserToken(s) by userId.
	 * </p>
	 *
	 * @return Optional<List < UserToken>>
	 */
	@Query(value = DELETE_BY_USERID)
	@Modifying
	@Transactional
	int deleteByUserId(Long userId);

	/**
	 * 
	 * 
	 * /** Used to delete the UserToken(s) by list of tokens and user id
	 * 
	 * @param authTokenList
	 * @param userId
	 * @return int
	 */
	@Query(value = DELETE_BY_TOKENS_AND_USER_ID)
	@Modifying
	@Transactional
	int deleteByAuthTokens(List<String> authTokenList, Long userId);
}
