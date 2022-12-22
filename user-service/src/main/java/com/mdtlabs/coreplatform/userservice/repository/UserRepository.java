package com.mdtlabs.coreplatform.userservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.model.entity.User;


/**
 * <p>
 * This is the repository class for communicate link between server side and
 * database. This class used to perform all the user module action in database.
 * In query annotation (nativeQuery = true) the below query perform like SQL.
 * Otherwise its perform like HQL default value for nativeQuery FALSE
 * </p>
 *
 * @author VigneshKumar created on Jun 20, 2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

	public static final String GET_ALL_USERS = "select user from User as user where user.isActive =:status";
	public static final String GET_USER_BY_ID = "select user from User as user where"
		+ " user.id =:userId and user.isActive =:status";
	public static final String GET_USER_BY_USERNAME = "select user from User as user "
		+ "where user.username =:username and user.isActive =:status";
	public static final String GET_USERS_BY_USERNAME_NOT_BY_ID = "select user from User "
		+ "as user where user.isActive =:status and user.username =:username and user.id !=:userId";
	public static final String GET_USERS_BY_TENANT_IDS = "select user from User user "
		+ "join user.organizations as org where org.id in (:tenantIds)";
	
	/**
	 * This method is used to get user with respect to id.
	 *
	 * @param userId - id of the user
	 * @param status - active status of user
	 * @return User - user entity
	 */
	@Query(value = GET_USER_BY_ID)
	public User getUserById(@Param(Constants.USER_ID_PARAM) long userId, 
		@Param(FieldConstants.STATUS) Boolean status);

	/**
	 * This method is used to get user with respect to user name.
	 *
	 * @param username - user name of user
	 * @param status   - active status of the user
	 * @return User - user entity
	 */
	@Query(value = GET_USER_BY_USERNAME)
	public User getUserByUsername(@Param(FieldConstants.USERNAME) String username, 
		@Param(FieldConstants.STATUS) Boolean status);

	/**
	 * This method is used to get users within an organization.
	 *
	 * @param status   - active status of the user
	 * @param pageable - pageable object
	 * @return Page(User) - pageable user entity
	 */
	@Query(value = GET_ALL_USERS)
	Page<User> getUsers(@Param(FieldConstants.STATUS) Boolean status, Pageable pageable);
	

	/**
	 * This method is used to get users within organization.
	 *
	 * @param status   - active status of the user
	 * @return List(User) - list of user entity
	 */
	@Query(value = GET_ALL_USERS)
	List<User> getUsers(@Param(FieldConstants.STATUS) Boolean status);

	/**
	 * This method is used to find active users.
	 *
	 * @param existingUsersIds - existing user id
	 * @return List(User) - list of user
	 */
	public List<User> findByIsActiveTrueAndIdIn(List<Long> existingUsersIds);

	/**
	 * This method is used to find user by user name.
	 *
	 * @param newUserEmails - list of new user emails
	 * @return List(User) - list of users
	 */
	public List<User> findByUsernameIn(List<String> newUserEmails);

	/**
	 * This method is used to find users by tenant ids.
	 *
	 * @param tenantIds - tenant ids
	 * @return List(User) - list of users
	 */
	@Query(value = GET_USERS_BY_TENANT_IDS)
	public List<User> findUsersByTenantIds(@Param("tenantIds") List<Long> tenantIds);

	/**
	 * Finds user by its Id and tenantId.
	 *
	 * @param id - user id
	 * @param tenantId - tenant Id
	 * @return user - User entity
	 */
	public User findByIdAndTenantIdAndIsActiveTrue(Long id, Long tenantId);

	/**
	 * Finds user by its Id and isActive fields.
	 *
	 * @param userId - user Id
	 * @return User - user Entity.
	 */
	public User findByIdAndIsActiveTrue(Long userId);

}
