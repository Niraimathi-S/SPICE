package com.mdtlabs.coreplatform.spiceadminservice.account.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.reflect.TypeToken;
import com.mdtlabs.coreplatform.AuthenticationFilter;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountWorkflowDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.UserOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.model.entity.spice.AccountWorkflow;
import com.mdtlabs.coreplatform.common.repository.DataRepository;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.account.repository.AccountRepository;
import com.mdtlabs.coreplatform.spiceadminservice.account.service.AccountService;
import com.mdtlabs.coreplatform.spiceadminservice.accountworkflow.service.AccountWorkflowService;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.OperatingUnitService;
import com.mdtlabs.coreplatform.spiceadminservice.site.service.SiteService;

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
	DataRepository dataRepository;

	@Autowired
	OperatingUnitService operatingUnitService;

	@Autowired
	SiteService siteService;
	
	@Autowired
	AccountWorkflowService accountWorkflowService;

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private AuthenticationFilter authenticationFilter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account addAccount(AccountWorkflowDTO accountDTO) {
		if (Objects.isNull(accountDTO)) {
			throw new BadRequestException(12006);
		}
		Account account = new Account();
		
		if (!Objects.isNull(accountDTO.getClinicalWorkflows())) {
			if (accountDTO.getClinicalWorkflows().isEmpty()) {
				throw new BadRequestException(26009);
			}			
//			boolean containsNullOrEmpty = accountDTO.getClinicalWorkflows().stream()
//					.anyMatch(workflow -> (Objects.isNull(workflow)));
//			if (containsNullOrEmpty) {
//				throw new BadRequestException(26009);
//			}
		}
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		account = modelMapper.map(accountDTO, Account.class);
		account.setCountry(new Country(accountDTO.getCountryId()));
		
//		List<AccountWorkflow> workflows = new ArrayList<>();
//		if (!accountDTO.getClinicalWorkflows().isEmpty()) {
//			account.setClinicalWorkflows(accountDTO.getClinicalWorkflows().stream().map(id -> new AccountWorkflow(id)).collect(Collectors.toList()));
//		}
//		if (!accountDTO.getCustomizedWorkflows().isEmpty()) {
//			account.setCustomizedWorkflows(accountDTO.getCustomizedWorkflows().stream().map(id -> new AccountWorkflow(id)).collect(Collectors.toList()));
//		}
		
        account.setClinicalWorkflows(getaccountWorkflows(accountDTO.getClinicalWorkflows()));
        if (!Objects.isNull(accountDTO.getCustomizedWorkflows())) {
            account.setCustomizedWorkflows(getaccountWorkflows(new ArrayList<>(accountDTO.getCustomizedWorkflows())));
        }

		System.out.println("account ---"+account);
		Account savedAccount = accountRepository.save(account);
		return savedAccount;
	}
	
    private List<AccountWorkflow> getaccountWorkflows(List<Long> workflowIds) {
        List<AccountWorkflow> workflows = accountWorkflowService.getAccountWorkflowsById(workflowIds);
        System.out.println("workflows from account workflow " + workflows);
        if (workflowIds.size() != workflows.size()) {
            throw new DataNotFoundException(26011);
        }
        return workflows;
    }

	/**
	 * {@inheritDoc}
	 */
	public Account updateAccount(AccountWorkflowDTO account) {
		if (Objects.isNull(account)) {
			throw new BadRequestException(12006);
		}
		Account existingAccount = accountRepository.findByIdAndIsDeleted(account.getId(), false);
		System.out.println("existingAccount---"+existingAccount);
		
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
		existingAccount.setCountry(new Country(account.getCountryId()));
		existingAccount.setClinicalWorkflows(getaccountWorkflows(account.getClinicalWorkflows()));
        existingAccount.setCustomizedWorkflows(getaccountWorkflows(new ArrayList<>(account.getCustomizedWorkflows())));
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		Organization organization = new Organization();
		organization.setId(account.getTenantId());
		organization.setName(account.getName());
		userApiInterface.updateOrganization(token, UserSelectedTenantContextHolder.get(), organization);
		System.out.println("existingAccount---"+existingAccount);
		return accountRepository.save(existingAccount);
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
	public AccountDetailsDTO getAccountDetails(CommonRequestDTO requestDTO) {
		if (Objects.isNull(requestDTO.getId()) || Objects.isNull(requestDTO.getTenantId())) {
			throw new DataNotAcceptableException(12012);
		}
		Account account = accountRepository.findByIdAndTenantIdAndIsActiveAndIsDeleted(requestDTO.getId(),
				requestDTO.getTenantId(), true, false);
		if (Objects.isNull(account)) {
			throw new DataNotFoundException(26008);
		}
		AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		accountDetailsDTO = modelMapper.map(account, AccountDetailsDTO.class);
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<User> users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(),
				List.of(account.getTenantId()));

		accountDetailsDTO.setUsers(modelMapper.map(users, new TypeToken<List<UserOrganizationDTO>>() {
		}.getType()));

		CountryDTO countryDTO = modelMapper.map(account.getCountry(), CountryDTO.class);
		accountDetailsDTO.setCountry(countryDTO);
		accountDetailsDTO.setCountryCode(countryDTO.getCountryCode());
		accountDetailsDTO.setClinicalWorkflow(account.getClinicalWorkflows());
		accountDetailsDTO.setCustomizedWorkflow(account.getCustomizedWorkflows());
		return accountDetailsDTO;
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	public Account activateDeactivateAccount(long id, boolean isActiveStatus) {
//
//		Account accountToUpdate = accountRepository.findById(id).orElseThrow(() -> new DataNotFoundException(26008));
//		accountToUpdate.setActive(isActiveStatus);
//		return accountRepository.save(accountToUpdate);
//	}

	/**
	 * {@inheritDoc}
	 */
	public List<Account> getDeactivatedAccounts(SearchRequestDTO searchRequestDto) {
		String formattedSearchTerm = null;
		if (!Objects.isNull(searchRequestDto.getSearchTerm()) && 0 < searchRequestDto.getSearchTerm().length()) {
			formattedSearchTerm = searchRequestDto.getSearchTerm().replaceAll("[^a-zA-Z0-9]*", "");
		}

		if (!Objects.isNull(searchRequestDto.getIsPaginated()) && searchRequestDto.getIsPaginated()) {
			Pageable pageable = Pagination.setPagination(searchRequestDto.getSkip(), searchRequestDto.getLimit(),
					Constants.UPDATED_AT, false);
			Page<Account> accounts = accountRepository.getDeactivatedAccountsWithPagination(formattedSearchTerm,
					pageable);
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
		Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit());

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		Organization organization = userApiInterface
				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		List<AccountListDTO> accountListDtos = new ArrayList<>();
		if (!Objects.isNull(organization)) {
			List<Account> accounts = accountRepository.findAccountList(searchTerm, organization.getFormDataId(), pageable).stream()
					.collect(Collectors.toList());
			if (!accounts.isEmpty()) {
				for (Account account : accounts) {
					AccountListDTO accountListDto = new AccountListDTO();
					accountListDto.setId(account.getId());
					accountListDto.setName(account.getName());
					accountListDto.setTenantId(account.getTenantId());
	//				Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
	//						UserSelectedTenantContextHolder.get(), account.getTenantId(), "account");
					accountListDto.setOUCount(operatingUnitService.getCount(null, account.getId(), Constants.BOOLEAN_TRUE));
					accountListDto.setSiteCount(siteService.getCount(null, account.getId(), null, Constants.BOOLEAN_TRUE));
					accountListDtos.add(accountListDto);
				}
			}
			
			if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
				totalCount = accountRepository.countByIsDeletedFalse();
			} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
				totalCount = accountRepository.getAccountsCount(searchTerm, organization.getFormDataId());
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
		ResponseEntity<User> response = userApiInterface.addAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public User updateAccountAdmin(User user) {
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();
		ResponseEntity<User> response = userApiInterface.updateAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
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
	public Map<String, Object> getAllAccounts(SearchRequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		int totalCount = 0;
		Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit(), Constants.UPDATED_AT,
				Constants.BOOLEAN_FALSE);

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<Account> accounts = new ArrayList<>();

		Organization organization = userApiInterface
				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		List<AccountDTO> accountDTOs = new ArrayList<>();
		if (!Objects.isNull(organization)) {
			accounts = accountRepository.getAllAccounts(searchTerm, organization.getFormDataId(), pageable);

//			CountryDTO countryDTO = new CountryDTO();
//			Country country = dataRepository.getCountryByTenantId(requestDto.getTenantId());

			accountDTOs = modelMapper.map(accounts, new TypeToken<List<AccountDTO>>() {
			}.getType());

			System.out.println("account DTO" + accountDTOs);
//			for (AccountDTO accountDTO : accountDTOs) {
//				countryDTO = modelMapper.map(country, new TypeToken<CountryDTO>() {
//				}.getType());
//				accountDTO.setCountry(countryDTO);
//			}
		}
		
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = accountRepository.countByCountryId(organization.getFormDataId());
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
			totalCount = accountRepository.getAccountsCount(searchTerm, organization.getFormDataId());
		}

		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, accountDTOs);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public Account activateDeactivateAccount(RequestDTO requestDTO) {

		Boolean isActiveStatus = requestDTO.getIsActive();
		Account account = accountRepository.findByTenantIdAndIsDeletedFalseAndIsActive(requestDTO.getTenantId(),
			!isActiveStatus);
		if (Objects.isNull(account)) {
			throw new DataNotFoundException(26008);
		}
		if (!Objects.isNull(requestDTO.getReason())) {
			account.setReason(requestDTO.getStatus());
			account.setStatus(requestDTO.getReason());
		}
		account.setActive(isActiveStatus);
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();

		
		accountRepository.save(account);
		List<Long> tenantIdList = new ArrayList<>();
		tenantIdList.addAll(operatingUnitService.activateDeactivateOUList(null, account.getId(), isActiveStatus));
			tenantIdList.addAll(siteService.activateDeactivateSiteList(null, account.getId(), null, isActiveStatus));
		
		tenantIdList.add(requestDTO.getTenantId());

		userApiInterface.activateDeactivateOrg(token,
				UserSelectedTenantContextHolder.get(), tenantIdList, isActiveStatus);
		
		userApiInterface.activateDeactivateUser(token, UserSelectedTenantContextHolder.get(), tenantIdList, isActiveStatus);

		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	public List<Long> activateDeactivateAccountsList(List<Long> tenantList, boolean isActive) {
		List<Account> accounts = accountRepository.findAccountByCountryIdAndIsActive(tenantList, !isActive);
		List<Long> tenantIds = new	ArrayList<>();
		System.out.println("accounts-----" + accounts);
		if (!accounts.isEmpty()) {
			accounts.stream().forEach(account -> {
				account.setActive(isActive);
				tenantIds.add(account.getTenantId());
			}
			);
			accountRepository.saveAll(accounts);
			System.out.println("account tenantIds----"+tenantIds);
		}
		return tenantIds;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer getCountByCountryId(Long countryId) {
		return accountRepository.countByCountryId(countryId);
	}
	
	/**
	 * ({@inheritDoc}
	 */
	public Map<String, Object> getAccountUsersList(SearchRequestDTO requestDto) {
		if (Objects.isNull(requestDto.getTenantId())) {
			throw new DataNotAcceptableException(26013);
		}
		
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
//		List<UserDTO> usersDtos = new ArrayList<>();
//		Map<String, List<Long>> childIds = userApiInterface.getChildOrganizations(token,
//		UserSelectedTenantContextHolder.get(), requestDto.getTenantId(), "country");
//		
//		List<Long> tenantIdList = childIds.values().stream().flatMap(List::stream).collect(Collectors.toList());
//		tenantIdList.add(requestDto.getTenantId());
//		
//		System.out.println("tenantId ---------"+ tenantIdList);
//		List<User> users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(),
//				tenantIdList);
//		if (!Objects.isNull(users)) {
//			usersDtos = modelMapper.map(users, new TypeToken<List<UserDTO>>() {
//			}.getType());
//		}
		Map<String, Object> usersResponse = userApiInterface.searchUser(token,
				UserSelectedTenantContextHolder.get(), requestDto).getBody();
			
		return usersResponse;
	}
}