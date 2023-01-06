package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.exception.DataConflictException;
import com.mdtlabs.coreplatform.common.exception.DataNotAcceptableException;
import com.mdtlabs.coreplatform.common.exception.DataNotFoundException;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.ParentOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.UserOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.User;
import com.mdtlabs.coreplatform.common.repository.DataRepository;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.repository.OperatingUnitRepository;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.OperatingUnitService;
import com.mdtlabs.coreplatform.spiceadminservice.site.service.SiteService;

/**
 * This Class contains the business logic for operating unit entity.
 *
 * @author N
 *
 */
@Service
public class OperatingUnitServiceImpl implements OperatingUnitService {

	@Autowired
	private OperatingUnitRepository operatingUnitRepository;

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private UserApiInterface userApiInterface;

	@Autowired
	private DataRepository dataRepository;

	private ModelMapper modelMapper = new ModelMapper();

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getOperatingUnitList(RequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		int totalCount = 0;
//		if (0 == requestDto.getSkip()) {
//			totalCount = operatingUnitRepository.countByIsDeletedFalse();
//		}
		Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit());

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		List<OperatingUnitListDTO> operatingUnitListDtos = new ArrayList<>();
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		Organization organization = userApiInterface
			.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		Long countryId = null;
		Long accountId = null;
		if (organization.getFormName().equals("country")) {
			countryId = organization.getFormDataId();
		} else {
			accountId = organization.getFormDataId();
		}
		if (!Objects.isNull(organization)) {
			List<Operatingunit> operatingunits = operatingUnitRepository.findOperatingUnitList(searchTerm, countryId, accountId, pageable)
					.stream().collect(Collectors.toList());
			if (!operatingunits.isEmpty()) {
				for (Operatingunit operatingunit : operatingunits) {
					OperatingUnitListDTO operatingUnitListDto = new OperatingUnitListDTO(operatingunit.getId(),
							operatingunit.getName(),operatingunit.getTenantId());
//					operatingUnitListDto.setId(operatingunit.getId());
//					operatingUnitListDto.setName(operatingunit.getName());
//					operatingUnitListDto.setTenantId(operatingunit.getTenantId());
//					Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
//							UserSelectedTenantContextHolder.get(), UserSelectedTenantContextHolder.get(), "account");
					operatingUnitListDto.setSiteCount(siteService.getCount(null, null,operatingunit.getId(), Constants.BOOLEAN_TRUE));
					operatingUnitListDtos.add(operatingUnitListDto);
				}
			}
		}
		
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = operatingUnitRepository.getCount(null, organization.getFormDataId(), Constants.BOOLEAN_TRUE);
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, countryId, accountId);
		}
		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitListDtos);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public User addOUAdmin(User user) {
		System.out.println("user in data impl" + user);
		Role role = new Role();
		role.setName(Constants.ROLE_OPERATING_UNIT_ADMIN);
		user.setRoles(Set.of(role));
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<User> response = userApiInterface.addAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public User updateOUAdmin(@Valid User user) {
		UserDTO userDTO = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDTO.getAuthorization();
		ResponseEntity<User> response = userApiInterface.updateAdminUser(token, UserSelectedTenantContextHolder.get(),
				user);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean deleteOUAdmin(CommonRequestDTO requestDTO) {
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		ResponseEntity<Boolean> response = userApiInterface.deleteAdminUser(token,
				UserSelectedTenantContextHolder.get(), requestDTO);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getAllOperatingUnits(SearchRequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		int totalCount = 0;
		Pageable pageable = Pagination.setPagination(requestDto.getSkip(), requestDto.getLimit(),
				Constants.UPDATED_AT, Constants.BOOLEAN_FALSE);

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<Operatingunit> operatingunits = new ArrayList<>();
		Map<String, List<Long>> childOrgList = new HashMap<>();
		ParentOrganizationDTO accountDto = new ParentOrganizationDTO();

		Long countryId = null;
		Long accountId = null;
		
//		List<Long> tenantIdList = new ArrayList<>();
//		Organization organizationResponse = userApiInterface
//				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		Organization organization = userApiInterface
			.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		List<OperatingUnitDTO> operatingUnitDTOs = new ArrayList<>();
		if (!Objects.isNull(organization)) {
			if (organization.getFormName().equals("country")) {
				countryId = organization.getFormDataId();
			} else {
				accountId = organization.getFormDataId();
			}
			System.out.println("countryId ----"+ countryId +"\t accountId---"+ accountId);
			operatingunits = operatingUnitRepository.getOperatingUnits(searchTerm, countryId, accountId, pageable);
//
//			if (!Objects.isNull(operatingunits)) {
//				for (Operatingunit operatingUnit : operatingunits) {
//					OperatingUnitDTO operatingUnitDTO = new OperatingUnitDTO();
//					operatingUnitDTO.setId(operatingUnit.getId());
//					operatingUnitDTO.setName(operatingUnit.getName());
//					operatingUnitDTO.setTenantId(operatingUnit.getTenantId());
//					if (!Objects.isNull(operatingUnit.getAccount())) {
//						modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//						accountDto = modelMapper.map(operatingUnit.getAccount(),
//								new TypeToken<ParentOrganizationDTO>() {}.getType());
//					}
//					operatingUnitDTO.setAccount(accountDto);
//					operatingUnitDTOs.add(operatingUnitDTO);
//				}
//			}/
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			operatingUnitDTOs = modelMapper.map(operatingunits, new TypeToken<List<OperatingUnitDTO>>() {
			}.getType());	
			System.out.println("operatingUnitDTOs-----"+operatingUnitDTOs);
		}
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = operatingUnitRepository.countByIsDeletedFalse();
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, countryId, accountId);
		}

		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitDTOs);
		return response;
	}

//	public Map<String, Object> getAllOperatingUnit(SearchRequestDTO requestDto) {
//		String searchTerm = requestDto.getSearchTerm();
//		int totalCount = 0;
//		Pageable pageable = Pagination.setPagination(requestDto.getPageNumber(), requestDto.getLimit(),
//				Constants.UPDATED_AT, Constants.BOOLEAN_FALSE);
//
//		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
//			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
//		}
//		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
//		List<Operatingunit> operatingunits = new ArrayList<>();
//		ParentOrganizationDTO accountDto = new ParentOrganizationDTO();
//		Long organizationId = 0L;
//
//		List<Long> tenantIdList = new ArrayList<>();
//		Organization organizationResponse = userApiInterface
//				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
//		if (!Objects.isNull(organizationResponse)) {
//			organizationId = organizationResponse.getFormDataId();
//			if (organizationResponse.getFormName().equals("country")) {
//				operatingunits = operatingUnitRepository
//						.findByIsDeletedFalseAndIsActiveAndCountryId(Constants.BOOLEAN_TRUE, organizationId);
//			} else {
//				operatingunits = operatingUnitRepository
//						.findByIsDeletedFalseAndIsActiveAndAccountId(Constants.BOOLEAN_TRUE, organizationId);
//				Account account = dataRepository.getAccountById(requestDto.getTenantId());
//				if (!Objects.isNull(account)) {
//					modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//					accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
//					}.getType());
//				}
//			}
//		}
//
//		List<OperatingUnitDTO> operatingUnitDTOs = new ArrayList<>();
//		if (!Objects.isNull(operatingunits)) {
//			for (Operatingunit operatingUnit : operatingunits) {
//				OperatingUnitDTO operatingUnitDTO = new OperatingUnitDTO();
//				operatingUnitDTO.setId(operatingUnit.getId());
//				operatingUnitDTO.setName(operatingUnit.getName());
//				operatingUnitDTO.setTenantId(operatingUnit.getTenantId());
//				if (organizationResponse.getFormName().equals("country")) {
//					Account account = dataRepository.getAccountById(operatingUnit.getAccount().getId());
//					if (!Objects.isNull(account)) {
//						modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//						accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
//						}.getType());
//					}
//				}
//				operatingUnitDTO.setAccount(accountDto);
//				operatingUnitDTOs.add(operatingUnitDTO);
//			}
//		}
//		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
//			totalCount = operatingUnitRepository.countByIsDeletedFalse();
//		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
//			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, tenantIdList);
//		}
//
//		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitDTOs);
//		return response;
//	}

	/**
	 * {@inheritDoc}
	 */
	public OperatingUnitDetailsDTO getOUDetails(CommonRequestDTO requestDTO) {
		if (Objects.isNull(requestDTO.getId()) || Objects.isNull(requestDTO.getTenantId())) {
			throw new DataNotAcceptableException(12012);
		}

		Operatingunit operatingunit = operatingUnitRepository.findByIdAndIsActiveAndIsDeletedAndTenantId(
				requestDTO.getId(), Constants.BOOLEAN_TRUE, Constants.BOOLEAN_FALSE, requestDTO.getTenantId());
		if (Objects.isNull(operatingunit)) {
			throw new DataNotFoundException(26008);
		}
		OperatingUnitDetailsDTO ouDTO = new OperatingUnitDetailsDTO();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ouDTO = modelMapper.map(operatingunit, new TypeToken<OperatingUnitDetailsDTO>() {
		}.getType());
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<User> users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(),
				List.of(operatingunit.getTenantId()));
		if (!Objects.isNull(users) && !users.isEmpty()) {
			ouDTO.setUsers(modelMapper.map(users, new TypeToken<List<UserOrganizationDTO>>() {
			}.getType()));
		}

//		Account account = dataRepository.getAccountById(operatingunit.getAccountId());
		if (!Objects.isNull(operatingunit.getAccount().getId())) {
			ParentOrganizationDTO accountDTO = modelMapper.map(operatingunit.getAccount(), new TypeToken<ParentOrganizationDTO>() {
			}.getType());
			ouDTO.setAccount(accountDTO);
		}
		return ouDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Long> activateDeactivateOUList(Long countryId, Long accountId,  boolean isActive) {
		List<Operatingunit> operatingunits = operatingUnitRepository
				.findByCountryIdAndAccountIdAndIsActive(countryId, accountId, !isActive);
		List<Long> tenantIds = new ArrayList<>();
		System.out.println("operatingunits------" + operatingunits);
		if (!operatingunits.isEmpty()) {
			operatingunits.stream().forEach(ou -> 
			{
				ou.setActive(isActive);
				tenantIds.add(ou.getTenantId());
			});
			operatingUnitRepository.saveAll(operatingunits);
		System.out.println("ou tenantIds----"+tenantIds);
		}
		return tenantIds;
	}
	
	public void activateDeactivateOU(long id, boolean isActive) {
		Operatingunit operatingunit = operatingUnitRepository.findByIdAndIsDeletedFalseAndIsActive(id, isActive);
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		if (Objects.isNull(operatingunit)) {
			throw new DataNotFoundException(29010);
		}
		System.out.println("ou---------" + operatingunit);
		operatingunit.setActive(isActive);
		operatingUnitRepository.save(operatingunit);
		List<Long> tenantIds = new ArrayList<>();
		tenantIds.addAll(siteService.activateDeactivateSiteList(null, null, operatingunit.getId(), isActive));
		System.out.println("tenantIdList--------" + tenantIds);

		userApiInterface.activateDeactivateUser(token, UserSelectedTenantContextHolder.get(), tenantIds, isActive);
	}

	
	public Integer getCount(Long countryId, Long accountId, boolean isActive) {
		return operatingUnitRepository.getCount(countryId,
			accountId, isActive);
	}
	
	/**
	 * ({@inheritDoc}
	 */
	public Map<String, Object> getOUUsersList(SearchRequestDTO requestDto) {
		if (Objects.isNull(requestDto.getTenantId())) {
			throw new DataNotAcceptableException(26013);
		}

		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
//		Organization organization = userApiInterface
//				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
//
//		List<User> users = new ArrayList<>();
//		List<UserDTO> usersDtos = new ArrayList<>();
//
//		if (!Objects.isNull(organization)) {
//			Map<String, List<Long>> childIds = userApiInterface.getChildOrganizations(token,
//					UserSelectedTenantContextHolder.get(), requestDto.getTenantId(), organization.getFormName());
//			List<Long> tenantIdList = childIds.values().stream().flatMap(List::stream).collect(Collectors.toList());
//			tenantIdList.add(requestDto.getTenantId());
//			users = userApiInterface.getUsersByTenantIds(token, UserSelectedTenantContextHolder.get(), tenantIdList);
//		}
//		if (!Objects.isNull(users)) {
//			usersDtos = modelMapper.map(users, new TypeToken<List<UserDTO>>() {
//			}.getType());
//		}
		Map<String, Object> usersResponse = userApiInterface.searchUser(token,
				UserSelectedTenantContextHolder.get(), requestDto).getBody();
		return usersResponse;
	}
	
	public Operatingunit createOperatingUnit(Operatingunit operatingUnit) {
		Operatingunit existingOperatingUnit = operatingUnitRepository.findByNameIgnoreCaseAndIsDeletedFalse(operatingUnit.getName());
		
		if (!Objects.isNull(existingOperatingUnit)) {
			throw new DataConflictException(29011);
		}
		
		return operatingUnitRepository.save(operatingUnit);
	}
}
