package com.mdtlabs.coreplatform.spiceadminservice.account.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.User;


/**
 * This service interface maintains the CRUD operations for the account
 * 
 * @author Jeyaharini T A
 *
 */
public interface AccountService {

	/**
	 * To add a new account
	 * 
	 * @param account
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account addAccount(Account account);

	/**
	 * To update the existing account details by it's id
	 * 
	 * @param account
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account updateAccount(Account account);

	/**
	 * To get account by it's id
	 * 
	 * @param id
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account getAccountById(long id);

	/**
	 * To activate or deactivate account by updating isActive column
	 * 
	 * @param id
	 * @param isActive
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	public Account activateDeactivateAccount(long id, boolean isActive);

	/**
	 * To get deactivated accounts
	 * 
	 * @param searchRequestDTO
	 * @return list of account entities
	 * @author Jeyaharini T A
	 */
	public List<Account> getDeactivatedAccounts(SearchRequestDTO searchRequestDTO);
	
	/**
	 * This method is used to clear the api role permission map
	 * 
	 */
	void clearApiPermissions();

	/**
	 * To get account list with child organization counts.
	 * 
	 * @param requestDTO - request data containing searchTerm, etc.,
	 * @return Map<String, Object> - List of account entities and account count.
	 * @author Niraimathi S
	 */
	public Map<String, Object> getAccountList(RequestDTO requestDTO);

	/**
	 * To add account admin user.
	 * 
	 * @param user - account admin user details
	 * @return User - User entity
	 * @author Niraimathi S
	 */
	public User addAccountAdmin(@Valid User user);

	/**
	 * To update account admin user.
	 * 
	 * @param user - updated user details
	 * @return User - user entity
	 * @author Niraimathi S
	 */
	public User updateAccountAdmin(@Valid User user);

	/**
	 * To delete account admin user.
	 * 
	 * @param requestDTO - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	public Boolean deleteAccountAdmin(CommonRequestDTO requestDTO);

	/**
	 * To get list of accounts details.
	 * 
	 * @param requestDTO - request data 
	 * @return List<Account> - List of Account Entities
	 * @author Niraimathi S
	 */
	public List<Account> getAllAccounts(SearchRequestDTO requestDTO);
}
