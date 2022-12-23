package com.mdtlabs.coreplatform.spiceadminservice.account.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdtlabs.coreplatform.AuthenticationFilter;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.account.repository.AccountRepository;
import com.mdtlabs.coreplatform.spiceadminservice.account.service.AccountService;
import com.mdtlabs.coreplatform.spiceadminservice.data.service.DataService;

/**
 * This service class maintains the CRUD operations for the account.
 *
 * @author Jeyaharini T A
 *
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	UserApiInterface userApiInterface;

	@Autowired
	DataService dataService;

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private AuthenticationFilter authenticationFilter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account addAccount(Account account) {
		if (Objects.isNull(account)) {
			throw new BadRequestException(12006);
		}

		if (!Objects.isNull(account.getClinicalWorkflows())) {
			if (account.getClinicalWorkflows().isEmpty()) {
				throw new BadRequestException(26009);
			}
			boolean containsNullOrEmpty = account.getClinicalWorkflows().stream()
				.anyMatch(workflow -> (Objects.isNull(workflow)));
			if (containsNullOrEmpty) {
				throw new BadRequestException(26009);
			}
		}

		Account savedAccount = accountRepository.save(account);

		return savedAccount;
	}

	/**
	 * {@inheritDoc}
	 */
	public Account updateAccount(Account account) {
		if (Objects.isNull(account)) {
			throw new BadRequestException(12006);
		}

		Account existingAccount = accountRepository.findByIdAndIsDeleted(account.getId(), false);

		if (Objects.isNull(existingAccount)) {
			throw new DataNotFoundException(26008);
		}

		if (!Objects.isNull(account.getClinicalWorkflows())) {
			if (account.getClinicalWorkflows().isEmpty()) {
				throw new BadRequestException(26009);
			}
			boolean containsNullOrEmpty = account.getClinicalWorkflows().stream()
				.anyMatch(workflow -> (Objects.isNull(workflow)));
			if (containsNullOrEmpty) {
				throw new BadRequestException(26009);
			}
		}

		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(account, existingAccount);
		return accountRepository.save(existingAccount);
		//accountRepository.updateAccount(account.getClinicalWorkflows(), account.getId());
		//return accountRepository.findById(account.getId()).orElseThrow();
	}

	/**
	 * {@inheritDoc}
	 */
	public Account getAccountById(long id) {

		Account account = accountRepository.findByIdAndIsActiveAndIsDeleted(id, true, false);
		if (Objects.isNull(account)) {
			throw new DataNotFoundException(26008);
		}
		return account;
	}

	/**
	 * {@inheritDoc}
	 */
	public Account activateDeactivateAccount(long id, boolean isActiveStatus) {

		Account accountToUpdate = accountRepository.findById(id)
			.orElseThrow(() -> new DataNotFoundException(26008));
		accountToUpdate.setActive(isActiveStatus);
		return accountRepository.save(accountToUpdate);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Account> getDeactivatedAccounts(SearchRequestDTO searchRequestDto) {

		String formattedSearchTerm = null;
		if (!Objects.isNull(searchRequestDto.getSearchTerm()) 
			&& 0 < searchRequestDto.getSearchTerm().length()) {
			formattedSearchTerm = searchRequestDto.getSearchTerm().replaceAll("[^a-zA-Z0-9]*", "");
		}

		if (!Objects.isNull(searchRequestDto.getIsPaginated()) && searchRequestDto.getIsPaginated()) {
			Pageable pageable = Pagination.setPagination(
				searchRequestDto.getPageNumber(), searchRequestDto.getLimit(),
				FieldConstants.MODIFIED_AT, false);
			Page<Account> accounts = accountRepository
				.getDeactivatedAccountsWithPagination(formattedSearchTerm, pageable);
			return accounts.stream().collect(Collectors.toList());
		}

		List<Account> accounts = accountRepository.getDeactivatedAccounts(formattedSearchTerm);
		return accounts;
	}

	@Override
	public void clearApiPermissions() {
		authenticationFilter.apiPermissionMap.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getAccountList(RequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		int totalCount = 0;
		if (0 == requestDto.getSkip()) {
			totalCount = accountRepository.countByIsDeletedFalse();
		}
		Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit());

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		List<Account> accounts = accountRepository.findAccountList(searchTerm, pageable).stream()
			.collect(Collectors.toList());
		List<AccountListDTO> accountListDtos = new ArrayList<>();
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();

		if (!accounts.isEmpty()) {
			for (Account account : accounts) {
				AccountListDTO accountListDto = new AccountListDTO();
				accountListDto.setId(account.getId());
				accountListDto.setName(account.getName());
				accountListDto.setTenantId(account.getTenantId());
				Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
					UserSelectedTenantContextHolder.get(), 
					UserSelectedTenantContextHolder.get(), "account");
				accountListDto.setOUCount(childOrgList.get("operatingUnitIds").size());
				accountListDto.setSiteCount(childOrgList.get("siteIds").size());
				accountListDtos.add(accountListDto);
			}
		}
		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, accountListDtos);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public User addAccountAdmin(User user) {
		Role role = new Role();
		role.setName(Constants.ROLE_ACCOUNT_ADMIN);
		user.setRoles(Set.of(role));
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<User> response = userApiInterface.addAdminUser(
			token, UserSelectedTenantContextHolder.get(), user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public User updateAccountAdmin(User user) {
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();
		ResponseEntity<User> response = userApiInterface.updateAdminUser(
			token, UserSelectedTenantContextHolder.get(), user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean deleteAccountAdmin(CommonRequestDTO requestDto) {
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<Boolean> response = userApiInterface.deleteAdminUser(token,
			UserSelectedTenantContextHolder.get(), requestDto);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Account> getAllAccounts(SearchRequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		Pageable pageable = Pagination.setPagination(requestDto.getPageNumber(), requestDto.getLimit());

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		List<Account> accounts = accountRepository.getAllAccounts(searchTerm, 
			requestDto.getTenantId(), pageable);

		return accounts;
	}

}