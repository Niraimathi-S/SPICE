package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service;

import java.util.Map;

import javax.validation.Valid;

import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.User;

/**
 * This is an interface for operatingUnit entity. This service interface
 * maintains the CRUD operations for the OperatingUnits
 * 
 * @author Niraimathi S
 *
 */
public interface OperatingUnitService {

	/**
	 * To get Operating unit list with its child organization counts.
	 * 
	 * @param requestDTO - request data containing search term, skip, limit, etc.,
	 * @return List<OperatingUnitListDTO> - List of operating units.
	 * @author Niraimathi S
	 */
	Map<String, Object> getOperatingUnitList(RequestDTO requestDTO);

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

}
