package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitListDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
import com.mdtlabs.coreplatform.common.util.Pagination;
import com.mdtlabs.coreplatform.spiceadminservice.UserApiInterface;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.repository.OperatingUnitRepository;
import com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service.OperatingUnitService;

/**
 * This Class contains the business logic for operating unit entity.
 * 
 * @author N
 *
 */
@Service
public class OperatingUnitServiceImpl implements OperatingUnitService {

	@Autowired
	OperatingUnitRepository operatingUnitRepository;

	@Autowired
	UserApiInterface userApiInterface;

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getOperatingUnitList(RequestDTO requestDTO) {
		String searchTerm = requestDTO.getSearchTerm();
		int totalCount = 0;
		if (0 == requestDTO.getSkip()) {
			totalCount = operatingUnitRepository.countByIsDeletedFalse();
		}
		Pageable pageable = Pagination.setPagination(requestDTO.getSkip(), requestDTO.getLimit());

		if (!Objects.isNull(searchTerm) && 0 > searchTerm.length()) {
			searchTerm = searchTerm.replaceAll("[^a-zA-Z0-9]*", "");
		}
		List<Operatingunit> operatingunits = operatingUnitRepository.findOperatingUnitList(searchTerm, pageable)
				.stream().collect(Collectors.toList());
		List<OperatingUnitListDTO> operatingUnitListDTOs = new ArrayList<>();
		UserDTO userDto = UserContextHolder.getUserDto();
		String token = Constants.BEARER + userDto.getAuthorization();

		System.out.println("UserSelectedTenantContextHolder.get()" + UserSelectedTenantContextHolder.get());
		if (!operatingunits.isEmpty()) {
			for (Operatingunit operatingunit : operatingunits) {
				OperatingUnitListDTO operatingUnitListDTO = new OperatingUnitListDTO();
				operatingUnitListDTO.setId(operatingunit.getId());
				operatingUnitListDTO.setName(operatingunit.getName());
				operatingUnitListDTO.setTenantId(operatingunit.getTenantId());
				Map<String, List<Long>> childOrgList = userApiInterface.getChildOrganizations(token,
						UserSelectedTenantContextHolder.get(), UserSelectedTenantContextHolder.get(), "account");
				operatingUnitListDTO.setSiteCount(childOrgList.get("siteIds").size());
				operatingUnitListDTOs.add(operatingUnitListDTO);
			}
		}
		Map<String, Object> response = Map.of(Constants.COUNT, totalCount, Constants.DATA, operatingUnitListDTOs);
		return response;
	}

}
