package com.mdtlabs.coreplatform.spiceadminservice.account.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.BadRequestException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.AccountOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.UserOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.repository.DataRepository;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.account.repository.AccountRepository;
import com.mdtlabs.coreplatform.spiceadminservice.account.service.AccountService;
import com.mdtlabs.coreplatform.spiceadminservice.data.service.DataService;
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

//	@Autowired
//	DataService dataService;

	@Autowired
	DataRepository dataRepository;

//	@Autowired
//	AccountService accountService;

	@Autowired
	OperatingUnitService operatingUnitService;

	@Autowired
	SiteService siteService;

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
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		Organization organization = new Organization();
		organization.setId(account.getTenantId());
		organization.setName(account.getName());
		userApiInterface.updateOrganization(token, UserSelectedTenantContextHolder.get(), organization);
		return accountRepository.save(existingAccount);
		// accountRepository.updateAccount(account.getClinicalWorkflows(),
		// account.getId());
		// return accountRepository.findById(account.getId()).orElseThrow();
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
	public AccountOrganizationDTO getAccountDetails(CommonRequestDTO requestDTO) {
		if (Objects.isNull(requestDTO.getId()) || Objects.isNull(requestDTO.getTenantId())) {
			throw new DataNotAcceptableException(12012);
		}
		Account account = accountRepository.findByIdAndTenantIdAndIsActiveAndIsDeleted(requestDTO.getId(),
				requestDTO.getTenantId(), true, false);
		if (Objects.isNull(account)) {
			throw new DataNotFoundException(26008);
		}
		AccountOrganizationDTO accountOrganizationDTO = new AccountOrganizationDTO();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		accountOrganizationDTO = modelMapper.map(account, new TypeToken<AccountOrganizationDTO>() {
		}.getType());
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<User> users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(),
				List.of(account.getTenantId()));

		accountOrganizationDTO.setUsers(modelMapper.map(users, new TypeToken<List<UserOrganizationDTO>>() {
		}.getType()));

		CountryDTO countryDTO = modelMapper.map(account.getCountry(), new TypeToken<CountryDTO>() {
		}.getType());
		accountOrganizationDTO.setCountry(countryDTO);
		accountOrganizationDTO.setCountryCode(countryDTO.getCountryCode());
		accountOrganizationDTO.setClinicalWorkflow(account.getClinicalWorkflows());
		accountOrganizationDTO.setCustomizedWorkflow(account.getCustomizedWorkflows());
		return accountOrganizationDTO;
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
			Pageable pageable = Pagination.setPagination(searchRequestDto.getPageNumber(), searchRequestDto.getLimit(),
					FieldConstants.MODIFIED_AT, false);
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
					accountListDto.setOUCount(operatingUnitService.getCount(null, organization.getFormDataId(), Constants.BOOLEAN_TRUE));
					accountListDto.setSiteCount(siteService.getCount(null, organization.getFormDataId(), null, Constants.BOOLEAN_TRUE));
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
//		Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
//				UserSelectedTenantContextHolder.get(), requestDto.getTenantId(), "country");
//		
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
	public Account activateDeactivateAccount(long id, boolean isActiveStatus) {

//        Map<String, List<Long>> childOrgIds = userApiInterface.activateInactivateOrg(id,
//                "account", isActiveStatus);
//
//        System.out.println("---------------------child organization    \n\n" + childOrgIds);
//
//        if (!childOrgIds.get("operatingUnitIds").isEmpty()) {
//            operatingUnitService.activateDeactivateOUList(childOrgIds.get("accountIds"), isActiveStatus);
//        }
//        if (!childOrgIds.get("siteIds").isEmpty()) {
//            siteService.activateDeactivateSiteList(childOrgIds.get("accountIds"), isActiveStatus);
//        }
//        accountToUpdate.setIsActive(isActiveStatus);
//        return accountRepository.save(accountToUpdate);
		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	public void activateDeactivateAccountsList(List<Long> tenantList, boolean isActive) {
		List<Account> accounts = accountRepository.findByIsDeletedFalseAndIsActiveAndTenantIdIn(!isActive, tenantList);

		System.out.println("accounts-----" + accounts);
		if (!accounts.isEmpty()) {
			accounts.stream().forEach(site -> site.setActive(isActive));
			accountRepository.saveAll(accounts);
		}
	}
	
	public Integer getCountByCountryId(Long countryId) {
		return accountRepository.countByCountryId(countryId);
	}
}