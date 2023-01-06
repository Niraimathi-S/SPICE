package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OperatingUnitDetailsDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
import com.mdtlabs.coreplatform.common.model.entity.User;

/**
 * This is an interface for operatingUnit entity. This service interface
 * maintains the CRUD operations for the OperatingUnits.
 *
 * @author Niraimathi S
 *
 */
public interface OperatingUnitService {

	/**
	 * To get Operating unit list with its child organization counts.
	 *
	 * @param requestDto - request data containing search term, skip, limit, etc.
	 * @return List(OperatingUnitListDTO) - List of operating units.
	 * @author Niraimathi S
	 */
	Map<String, Object> getOperatingUnitList(RequestDTO requestDto);

	/**
	 * To add operating unit admin user.
	 * 
	 * @param user - account admin user details
	 * @return User - User entity
	 * @author Niraimathi S
	 */
	User addOUAdmin(User user);

	/**
	 * To update operating unit admin user.
	 * 
	 * @param user - updated user details
	 * @return User - user entity
	 * @author Niraimathi S
	 */
	User updateOUAdmin(@Valid User user);

	/**
	 * To delete operating unit admin user.
	 * 
	 * @param requestDTO - request data containing user id and tenantId.
	 * @return Boolean
	 * @author Niraimathi S
	 */
	Boolean deleteOUAdmin(CommonRequestDTO requestDTO);

	/**
	 * To get operating unit list based on a search term and tenant Id.
	 * 
	 * @param requestDto - request details
	 * @return Map(String, Object) - List of OperatingUnit entities and its count
	 * @author Niraimathi S
	 */
	Map<String, Object> getAllOperatingUnits(SearchRequestDTO requestDto);

	/**
	 * Gets operating unit details using Id and tenantId.
	 * 
	 * @param requestDTO - request data containing Id and tenantId
	 * @return Operating unit entity
	 * @author Niraimathi S
	 */
	OperatingUnitDetailsDTO getOUDetails(CommonRequestDTO requestDTO);
	
	/**
	 * Activates or deactivates an operating unit based on list of tenant IDs.
	 * 
	 * @param tenantIdList - list of tenantId
	 * @param doActivate - isActive status
	 * @author Niraimathi S
	 */
    List<Long> activateDeactivateOUList(Long countryId, Long accountId, boolean doActivate);

    /**
     * To get count of operating units by country Id and accountId.
     * 
     * @param countryId - country Id
     * @param isActive - isActive status
     * @return Integer - count of Operating units
     * @author Niraimathi S
     */
	public Integer getCount(Long countryId, Long accountId, boolean isActive);
    
	/**
	 * Gets operating unit list based on operating unit tenant Id.
	 * 
	 * @param requestDto - request data containing tenantId, search term etc.,
	 * @return List(UserDTO) - List of User entity
	 * @author Niraimathi S
	 */
	public Map<String, Object> getOUUsersList(SearchRequestDTO requestDto);

	/**
	 * TO activate or deactive an operating unit by its Id.
	 * 
	 * @param id - operating unit id
	 * @param isActive - isActive status
	 * @author Niraimathi S
	 */
	void activateDeactivateOU(long id, boolean isActive);

	/**
	 * Creates a new OperatingUnit.
	 * 
	 * @param operatingUnit - operating unit details
	 * @return OperatingUnit - OperatingUnit entity
	 * @author Niraimathi S
	 */
	Operatingunit createOperatingUnit(Operatingunit operatingUnit);

}
