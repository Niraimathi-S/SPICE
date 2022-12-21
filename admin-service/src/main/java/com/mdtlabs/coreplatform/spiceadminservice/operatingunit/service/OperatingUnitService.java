package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.service;

import java.util.Map;

import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;

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

}
