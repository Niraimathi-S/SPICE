package com.mdtlabs.coreplatform.spiceadminservice.account.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.entity.Account;

/**
 * This repository contains the needed customized functions for account.
 *
 * @author Jeyaharini T A
 *
 */
@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

	public static final String GET_DEACTIVATED_ACCOUNTS = "SELECT account FROM Account AS account WHERE "
		+ " (:searchTerm IS null OR lower(account.name) LIKE CONCAT('%',lower(:searchTerm),'%')) "
		+ " AND account.isActive=false AND account.isDeleted = false order by account.updatedBy";

	public static final String UPDATE_ACCOUNT = "UPDATE Account AS account "
		+ "SET account.clinicalWorkflows = :clinicalWorkflows WHERE account.id = :id";

	public static final String GET_ACCOUNTS_BY_NAME = "select account from Account as account"
		+ " where lower(account.name) LIKE CONCAT('%',lower(:searchTerm),'%')"
		+ " AND account.isDeleted=false AND account.isActive=true AND account.country.id=:countryId";

	public static final String GET_ACCOUNT_LIST = "select account from Account as account"
		+ " where account.country.id=:countryId and "
		+ "account.isDeleted=false and account.isActive=true and "
		+ "(:searchTerm is null or lower(account.name) LIKE CONCAT('%',lower(:searchTerm),'%'))";

	public static final String COUNT_BY_COUNTRY_ID = "select count(account) from Account as account "
		+ "where account.country.id = :countryId And account.isDeleted=false And account.isActive=true";
	
	public static final String COUNT_BY_NAME = "select count(account.id) from Account as account"
		+ " where lower(account.name) LIKE CONCAT('%',lower(:searchTerm),'%')"
		+ " AND account.isDeleted=false AND account.isActive=true AND account.country.id=:countryId";
	
	public static final String GET_BY_COUNTRY_ID = "select account from Account as account where account.country.id "
		+ "in (:countryIdList) AND account.isActive=:isActive AND account.isDeleted = false";
	
	/**
	 * To get the account by id.
	 *
	 * @param id - account id
	 * @param isDeleted - true or false
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account findByIdAndIsDeleted(long id, boolean isDeleted);

	/**
	 * To get the account by id.
	 *
	 * @param id - account id
	 * @param isActive - true or false
	 * @param isDeleted - true or false
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account findByIdAndIsActiveAndIsDeleted(long id, boolean isActive, boolean isDeleted);

	/**
	 * To get the deactivted accounts with pagination.
	 *
	 * @param searchTerm - search term
	 * @param pageable - pagebale
	 * @return Page of account entities
	 * @author Jeyaharini T A
	 */
	@Query(value = GET_DEACTIVATED_ACCOUNTS)
	public Page<Account> getDeactivatedAccountsWithPagination(@Param("searchTerm") String searchTerm,
		Pageable pageable);

	/**
	 * To get the deactivated accounts.
	 *
	 * @param searchTerm - search term
	 * @return List of account entities
	 * @author Jeyaharini T A
	 */
	@Query(value = GET_DEACTIVATED_ACCOUNTS)
	public List<Account> getDeactivatedAccounts(@Param("searchTerm") String searchTerm);

	/**
	 * To update Account's clinical workflows.
	 *
	 * @param clinicalWorkflows - list of clinical work flow
	 * @param id - account id
	 */
	@Modifying
	@Query(value = UPDATE_ACCOUNT)
	public void updateAccount(@Param("clinicalWorkflows") List<String> clinicalWorkflows,
		@Param("id") long id);

	/**
	 * Gets count of total accounts present.
	 *
	 * @return int - total count of Accounts.
	 * @author Niraimathi S
	 */
	public int countByIsDeletedFalse();

	/**
	 * This method is used to get account list.
	 *
	 * @param searchTerm - search term
	 * @param pageable - pageable
	 * @return List - list of account
	 */
	@Query(value = GET_ACCOUNTS_BY_NAME)
	public List<Account> findAccountList(@Param(value = "searchTerm") String searchTerm, @Param("countryId") Long countryId,Pageable pageable);

	/**
	 * This method is used to get all accounts.
	 *
	 * @param searchTerm - search term
	 * @param tenantId - tenant id
	 * @param pageable - pageable
	 * @return List - list of account
	 * @author Niraimathi S
	 */
	@Query(value = GET_ACCOUNT_LIST)
	List<Account> getAllAccounts(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		Pageable pageable);

	/**
	 * Gets account by tenantId,isDeleted and isActive fields.
	 * 
	 * @param id - account Id
	 * @param tenantId - tenant Id
	 * @param isActive - isActive field
	 * @param isDeleted - isDeleted field
	 * @return Account entity 
	 * @author Niraimathi S
	 */
	public Account findByIdAndTenantIdAndIsActiveAndIsDeleted(Long id, Long tenantId, boolean isActive, 
		boolean isDeleted);

	/**
	 * Gets List of accounts by list of tenant IDs, isActive and isDeleted fields.
	 * 
	 * @param isActive - isActive 
	 * @param tenantList - list of tenant IDs
	 * @return List(Account) - List of account entities
	 */
	public List<Account> findByIsDeletedFalseAndIsActiveAndTenantIdIn(boolean isActive, List<Long> tenantList);

	/**
	 * To get count of accounts using country Id.
	 * 
	 * @param countryId
	 * @return
	 */
	@Query(value = COUNT_BY_COUNTRY_ID)
	public int countByCountryId(@Param(Constants.COUNTRY_ID) Long countryId);

	/**
	 * To get account count using name.
	 * 
	 * @param searchTerm - account name to search
	 * @param countryId - countryId
	 * @return int - Account count
	 */
	@Query(value = COUNT_BY_NAME)
	public int getAccountsCount(@Param(value = "searchTerm") String searchTerm, 
		@Param("countryId") Long countryId);

	@Query(value = GET_BY_COUNTRY_ID)
	public List<Account> findAccountByCountryIdAndIsActive(@Param("countryIdList") List<Long> countryIdList,
		@Param("isActive") boolean isActive);

	public Account findByTenantIdAndIsDeletedFalseAndIsActive(long tenantId, boolean isActive);

}
