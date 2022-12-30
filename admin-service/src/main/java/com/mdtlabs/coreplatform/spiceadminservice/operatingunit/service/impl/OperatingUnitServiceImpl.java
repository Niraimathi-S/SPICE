package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		if (!Objects.isNull(organization)) {
			List<Operatingunit> operatingunits = operatingUnitRepository.findOperatingUnitList(searchTerm, organization.getFormDataId(), pageable)
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
					operatingUnitListDto.setSiteCount(siteService.getCount(null, null, organization.getFormDataId(), Constants.BOOLEAN_TRUE));
					operatingUnitListDtos.add(operatingUnitListDto);
				}
			}
		}
		
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = operatingUnitRepository.getCount(null, organization.getFormDataId(), Constants.BOOLEAN_TRUE);
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
//			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, organization.getFormDataId());
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
		Pageable pageable = Pagination.setPagination(requestDto.getPageNumber(), requestDto.getLimit(),
				Constants.UPDATED_AT, Constants.BOOLEAN_FALSE);

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<Operatingunit> operatingunits = new ArrayList<>();
		Map<String, List<Long>> childOrgList = new HashMap<>();
		ParentOrganizationDTO accountDto = new ParentOrganizationDTO();

		List<Long> tenantIdList = new ArrayList<>();
		Organization organizationResponse = userApiInterface
				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		if (!Objects.isNull(organizationResponse)) {
			if (organizationResponse.getFormName().equals("country")) {
				childOrgList = userApiInterface.getChildOrganizations(token, UserSelectedTenantContextHolder.get(),
						requestDto.getTenantId(), "country");
			} else {
				childOrgList = userApiInterface.getChildOrganizations(token, UserSelectedTenantContextHolder.get(),
						requestDto.getTenantId(), "account");

				Account account = dataRepository.getAccountById(requestDto.getTenantId());
				if (!Objects.isNull(account)) {
					modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
					accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
					}.getType());
				}
			}
		}

		tenantIdList = childOrgList.get("operatingUnitIds");
		List<OperatingUnitDTO> operatingUnitDTOs = new ArrayList<>();
		if (!Objects.isNull(tenantIdList) && !tenantIdList.isEmpty()) {
			operatingunits = operatingUnitRepository.getOperatingUnitsByTenants(searchTerm, tenantIdList, pageable);

			if (!Objects.isNull(operatingunits)) {
				for (Operatingunit operatingUnit : operatingunits) {
					OperatingUnitDTO operatingUnitDTO = new OperatingUnitDTO();
					operatingUnitDTO.setId(operatingUnit.getId());
					operatingUnitDTO.setName(operatingUnit.getName());
					operatingUnitDTO.setTenantId(operatingUnit.getTenantId());
					if (organizationResponse.getFormName().equals("country")) {
						Account account = dataRepository.getAccountById(operatingUnit.getAccountId());
						if (!Objects.isNull(account)) {
							modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
							accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
							}.getType());
						}
					}
					operatingUnitDTO.setAccount(accountDto);
					operatingUnitDTOs.add(operatingUnitDTO);
				}
			}
		}
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = operatingUnitRepository.countByIsDeletedFalse();
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, tenantIdList);
		}

		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitDTOs);
		return response;
	}

	public Map<String, Object> getAllOperatingUnit(SearchRequestDTO requestDto) {
		String searchTerm = requestDto.getSearchTerm();
		int totalCount = 0;
		Pageable pageable = Pagination.setPagination(requestDto.getPageNumber(), requestDto.getLimit(),
				Constants.UPDATED_AT, Constants.BOOLEAN_FALSE);

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		String token = Constants.BEARER + UserContextHolder.getUserDto().getAuthorization();
		List<Operatingunit> operatingunits = new ArrayList<>();
		ParentOrganizationDTO accountDto = new ParentOrganizationDTO();
		Long organizationId = 0L;

		List<Long> tenantIdList = new ArrayList<>();
		Organization organizationResponse = userApiInterface
				.getOrganizationById(token, UserSelectedTenantContextHolder.get(), requestDto.getTenantId()).getBody();
		if (!Objects.isNull(organizationResponse)) {
			organizationId = organizationResponse.getFormDataId();
			if (organizationResponse.getFormName().equals("country")) {
				operatingunits = operatingUnitRepository
						.findByIsDeletedFalseAndIsActiveAndCountryId(Constants.BOOLEAN_TRUE, organizationId);
			} else {
				operatingunits = operatingUnitRepository
						.findByIsDeletedFalseAndIsActiveAndAccountId(Constants.BOOLEAN_TRUE, organizationId);
				Account account = dataRepository.getAccountById(requestDto.getTenantId());
				if (!Objects.isNull(account)) {
					modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
					accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
					}.getType());
				}
			}
		}

		List<OperatingUnitDTO> operatingUnitDTOs = new ArrayList<>();
		if (!Objects.isNull(operatingunits)) {
			for (Operatingunit operatingUnit : operatingunits) {
				OperatingUnitDTO operatingUnitDTO = new OperatingUnitDTO();
				operatingUnitDTO.setId(operatingUnit.getId());
				operatingUnitDTO.setName(operatingUnit.getName());
				operatingUnitDTO.setTenantId(operatingUnit.getTenantId());
				if (organizationResponse.getFormName().equals("country")) {
					Account account = dataRepository.getAccountById(operatingUnit.getAccountId());
					if (!Objects.isNull(account)) {
						modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
						accountDto = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
						}.getType());
					}
				}
				operatingUnitDTO.setAccount(accountDto);
				operatingUnitDTOs.add(operatingUnitDTO);
			}
		}
		if (0 == requestDto.getSkip() && requestDto.getSearchTerm().isBlank()) {
			totalCount = operatingUnitRepository.countByIsDeletedFalse();
		} else if ((0 == requestDto.getSkip() && !requestDto.getSearchTerm().isBlank())) {
			totalCount = operatingUnitRepository.getOperatingUnitsCount(searchTerm, tenantIdList);
		}

		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitDTOs);
		return response;
	}

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

		Account account = dataRepository.getAccountById(operatingunit.getAccountId());
		if (!Objects.isNull(account)) {
			ParentOrganizationDTO accountDTO = modelMapper.map(account, new TypeToken<ParentOrganizationDTO>() {
			}.getType());
			ouDTO.setAccount(accountDTO);
		}
		return ouDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public void activateDeactivateOUList(List<Long> tenantIdList, boolean isActive) {
		List<Operatingunit> operatingunits = operatingUnitRepository
				.findByIsDeletedFalseAndIsActiveAndTenantIdIn(!isActive, tenantIdList);
		System.out.println("operatingunits------" + operatingunits);
		if (!operatingunits.isEmpty()) {
			operatingunits.stream().forEach(site -> site.setActive(isActive));
			operatingUnitRepository.saveAll(operatingunits);
		}
	}
	
	public Integer getCount(Long countryId, Long accountId, boolean isActive) {
		return operatingUnitRepository.getCount(countryId,
			accountId, isActive);
	}
}
