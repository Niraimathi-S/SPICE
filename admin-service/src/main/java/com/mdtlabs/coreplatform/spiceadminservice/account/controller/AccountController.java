package com.mdtlabs.coreplatform.spiceadminservice.account.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.spiceadminservice.account.service.AccountService;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;

/**
 * This controller class maintains CRUD operation for account data.
 *
 * @author Jeyaharini T A
 */

@RestController
@RequestMapping(value = "/account")
@Validated
public class AccountController {

	@Autowired
	AccountService accountService;

	private static final List<String> noDataList = Arrays.asList(Constants.NO_DATA_FOUND);

	/**
	 * To add a new account.
	 *
	 * @param account Account data to save
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@PostMapping("/create")
	public SuccessResponse<Account> addAccount(@Valid @RequestBody Account account) {
		accountService.addAccount(account);
		return new SuccessResponse<>(SuccessCode.ACCOUNT_SAVE, HttpStatus.CREATED);
	}

	/**
	 * To update the existing account by id.
	 *
	 * @param account Account data to update.
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@PutMapping("/update")
	public SuccessResponse<Account> updateAccount(@Valid @RequestBody Account account) {
		accountService.updateAccount(account);
		return new SuccessResponse<Account>(SuccessCode.ACCOUNT_UPDATE, HttpStatus.OK);
	}

	/**
	 * To get the account by its id.
	 *
	 * @param id Accoutn id to get account details.
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@PostMapping("/details")
	public SuccessResponse<AccountOrganizationDTO> getAccountDetails(@RequestBody CommonRequestDTO requestDTO) {
		return new SuccessResponse<AccountOrganizationDTO>(SuccessCode.GET_ACCOUNT,
				accountService.getAccountDetails(requestDTO), HttpStatus.OK);
	}

	/**
	 * To activate the account by its id.
	 *
	 * @param id Account id to activate deactivated account.
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@GetMapping("/activate/{id}")
	public SuccessResponse<Account> activateAccountById(@PathVariable("id") long id) {
		accountService.activateDeactivateAccount(id, true);
		return new SuccessResponse<Account>(SuccessCode.ACCOUNT_ACTIVATE, HttpStatus.OK);
	}

	/**
	 * To de-activate the account by its id.
	 *
	 * @param id Account id to deactivate an active account
	 * @return Account entity
	 * @author Jeyaharini T A
	 */
	@GetMapping("/deactivate/{id}")
	public SuccessResponse<Account> deactivateAccountById(@PathVariable("id") long id) {
		accountService.activateDeactivateAccount(id, false);
		return new SuccessResponse<Account>(SuccessCode.ACCOUNT_DEACTIVATE, HttpStatus.OK);
	}

	/**
	 * Gets all deactivated accounts.
	 *
	 * @param searchRequestDto Request object containing search term and pagination
	 *                         information to get accounts.
	 * @return List of Account entities
	 * @author Jeyaharini T A
	 */
	@GetMapping("/deactivate-list")
	public SuccessResponse<List<Account>> getAllDeactivedAccounts(@RequestBody SearchRequestDTO searchRequestDto) {
		List<Account> deactivatedAccountsList = accountService.getDeactivatedAccounts(searchRequestDto);
		if (!deactivatedAccountsList.isEmpty()) {
			return new SuccessResponse<List<Account>>(SuccessCode.GET_DEACTIVATE_ACCOUNT, deactivatedAccountsList,
					deactivatedAccountsList.size(), HttpStatus.OK);
		}
		return new SuccessResponse<List<Account>>(SuccessCode.GET_DEACTIVATE_ACCOUNT, noDataList, 0, HttpStatus.OK);
	}

	/**
	 * To get an account by its Id.
	 *
	 * @param id - account Id
	 * @return Account - Account entity.
	 */
	@GetMapping("/get-account/{id}")
	public Account getAccount(@PathVariable("id") long id) {
		return accountService.getAccountById(id);
	}

	/**
	 * This method is used to clear the api permission role map.
	 * 
	 */
	@GetMapping(value = "/clear")
	public void clearApiPermissions() {
		accountService.clearApiPermissions();
	}

	/**
	 * To get List of account details with child organization counts.
	 *
	 * @param requestDto - request data containing search term, pagination details,
	 *                   etc.,
	 * @return List(Account) - List of account Entities
	 * @author Niraimathi S
	 */
	@PostMapping("/list")
	public SuccessResponse<List<Account>> getAccountList(@RequestBody RequestDTO requestDto) {
		Map<String, Object> response = accountService.getAccountList(requestDto);
		Integer totalCount = (Objects.isNull(response.get(Constants.COUNT))) ? 0
				: Integer.parseInt(response.get(Constants.COUNT).toString());
		if (0 == totalCount) {
			return new SuccessResponse<List<Account>>(SuccessCode.GET_ACCOUNT, response.get(Constants.DATA),
					HttpStatus.OK);
		}
		return new SuccessResponse<List<Account>>(SuccessCode.GET_ACCOUNT, response.get(Constants.DATA), totalCount,
				HttpStatus.OK);
	}

	/**
	 * To get list of accounts details.
	 *
	 * @param requestDto - request data
	 * @return List(Account) - List of Account Entities
	 * @author Niraimathi S
	 */
	@PostMapping("/account-list")
	public SuccessResponse<List<AccountDTO>> getAllAccounts(@RequestBody SearchRequestDTO requestDto) {
		Map<String, Object> response = accountService.getAllAccounts(requestDto);
		Integer totalCount = (Objects.isNull(response.get(Constants.COUNT))) ? 0
				: Integer.parseInt(response.get(Constants.COUNT).toString());
		if (0 == totalCount) {
			return new SuccessResponse<List<AccountDTO>>(SuccessCode.GET_ACCOUNT, response.get(Constants.DATA),
					HttpStatus.OK);
		}
		return new SuccessResponse<List<AccountDTO>>(SuccessCode.GET_ACCOUNT, response.get(Constants.DATA), totalCount,
				HttpStatus.OK);

	}

	/**
	 * To add account admin user.
	 *
	 * @param user - account admin user details
	 * @return User - User entity
	 * @author Niraimathi S
	 */
	@PostMapping(value = "/add-user")
	public SuccessResponse<User> addAccountAdmin(@RequestBody @Valid User user) {
		accountService.addAccountAdmin(user);
		return new SuccessResponse<>(SuccessCode.REGION_ADMIN_SAVE, HttpStatus.CREATED);
	}

	/**
	 * To update account admin user.
	 *
	 * @param user - updated user details
	 * @return User - user entity
	 * @author Niraimathi S
	 */
	@PutMapping(value = "/update-user")
	public SuccessResponse<User> updateAccountAdmin(@RequestBody @Valid User user) {
		accountService.updateAccountAdmin(user);
		return new SuccessResponse<>(SuccessCode.REGION_ADMIN_UPDATE, HttpStatus.OK);
	}

	/**
	 * To delete account admin user.
	 *
	 * @param requestDto - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	@DeleteMapping(value = "/remove-user")
	public SuccessResponse<User> deleteAccountAdmin(@RequestBody CommonRequestDTO requestDto) {
		accountService.deleteAccountAdmin(requestDto);
		return new SuccessResponse<>(SuccessCode.REGION_ADMIN_DELETE, HttpStatus.OK);
	}
}
