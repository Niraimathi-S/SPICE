package com.mdtlabs.coreplatform.spiceadminservice.regioncustomization.service;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.dto.spice.CustomizationRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.spice.RegionCustomization;

/**
 * This service class maintains the CRUD operations for region customization
 * 
 * @author Jeyaharini T A
 *
 */
public interface RegionCustomizationService {

	/**
	 * This method is used to add a country customization form data.
	 * 
	 * @param regionCustomization
	 * @return RegionCustomization entity.
	 * @author Niraimathi S
	 */
	public RegionCustomization addCustomization(RegionCustomization regionCustomization);

	/**
	 * Get the region customization data details such as screening, enrollment and
	 * consent forms based on region customization id, type and category.
	 * 
	 * @param regionCustomizationRequestDTO
	 * @return RegionCustomization entity.
	 * @author Niraimathi S
	 */
	public RegionCustomization getCustomization(CustomizationRequestDTO regionCustomizationRequestDTO);

	/**
	 * Update region customization data like screening, enrollment forms and consent
	 * data based on country id and region customization id
	 * 
	 * @param regionCustomization
	 * @return Count of rows updated.regionFormData
	 * @author Niraimathi S
	 */
	public RegionCustomization updateCustomization(RegionCustomization regionCustomization);

	/**
	 * To get list of region customized data.
	 * 
	 * @param requestData - request data containing country Id, tenantId, etc.,
	 * @return List of RegionCustomization Entity.
	 * @author Niraimathi S
	 */
	public List<RegionCustomization> getRegionCustomizations(Map<String, Object> requestData);
	
	/**
	 * Get default customized JSON and add to newly created region.
	 * 
	 * @param organization organization details
	 * @author Niraimathi S
	 */
	public void createRegionCustomizedJSON(Organization organization);
}
