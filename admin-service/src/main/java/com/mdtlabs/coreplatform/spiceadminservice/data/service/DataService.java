package com.mdtlabs.coreplatform.spiceadminservice.data.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.County;
import com.mdtlabs.coreplatform.common.model.entity.Subcounty;
import com.mdtlabs.coreplatform.common.model.entity.User;

/**
 * This interface contains business logic for manipulating Country, County and
 * SubCounty entities.
 *
 * @author Karthick M
 */
public interface DataService {

	/**
	 * This method is used to add a new Country.
	 *
	 * @param countryDto - entity
	 * @return Country Entity
	 * @author Karthick M
	 */
	Country createCountry(Country country);

	/**
	 * This method is used to update a country details like name.
	 *
	 * @param country - entity
	 * @return country Entity
	 * @author Karthick M
	 */
	Country updateCountry(Country country);

	/**
	 * This method is used to add a new county under a country.
	 *
	 * @param county - entity
	 * @return County entity
	 * @author Niraimathi S
	 */
	County addCounty(County county);

	/**
	 * Used to get single county details using county id.
	 *
	 * @param id - county id
	 * @return County entity
	 * @author Niraimathi S
	 */
	County getCountyById(long id);

	/**
	 * Gets all counties under a country using country id.
	 *
	 * @param id - county id
	 * @return List of county entities.
	 * @author Niraimathi S
	 */
	List<County> getAllCountyByCountryId(long id);

	/**
	 * This method is used to update a county.
	 *
	 * @param county - county id
	 * @return Updated county entity.
	 * @author Niraimathi S
	 */
	County updateCounty(County county);

	/**
	 * Used to get all countries and search countries using country name.
	 *
	 * @param requestDto - request dto
	 * @return List of county entities
	 * @author Niraimathi S
	 */
	List<Country> getAllCountries(RequestDTO requestDto);

	/**
	 * This method is used to add a new SubCounty.
	 *
	 * @param subCounty - sub county entity
	 * @return SubCounty Entity
	 * @author Karthick M
	 */
	Subcounty createSubCounty(Subcounty subCounty);

	/**
	 * Used to get single country details using country id.
	 *
	 * @param countryId - country id
	 * @return Country entity
	 * @author Karthick M
	 */
	CountryOrganizationDTO getCountryById(long countryId, boolean isUsersRequired);

	/**
	 * Used to soft delete subcounty details using subcounty id.
	 *
	 * @param subCounty - sub county entity
	 * @return subcounty entity
	 * @author Karthick M
	 */
	Subcounty updateSubCounty(Subcounty subCounty);

	/**
	 * Gets all subcounties based on country and county id.
	 *
	 * @param countryId - country id
	 * @param countyId  - county id
	 * @return List of SubCounty entities.
	 * @author Niraimathi S
	 */
	List<Subcounty> getAllSubCounty(long countryId, long countyId);

	/**
	 * Used to get single country details using country id.
	 *
	 * @param id - sub county id
	 * @return Country entity
	 * @author Karthick M
	 */
	Subcounty getSubCountyById(long id);

	/**
	 * Gets country list with child organization counts.
	 *
	 * @param countryId - country id
	 * @return List of countryListDTO
	 */
	List<Subcounty> getAllSubCountyByCountryId(Long countryId);

	/**
	 * To get country list based on country id.
	 *
	 * @param requestDto - request dto
	 * @return Map of Country
	 */
	Map<String, Object> getCountryList(RequestDTO requestDto);

	/**
	 * Gets country by Id without users.
	 *
	 * @param countryId country Id
	 * @return Country entity
	 */
	Country findCountryById(Long countryId);

	/**
	 * To create a region admin.
	 *
	 * @param user user details
	 * @return User entity.
	 * @author Niraimathi S
	 */
	User addRegionAdmin(User user);

	/**
	 * To update an region admin user.
	 *
	 * @param user - User details
	 * @return user - user entity
	 */
	User updateRegionAdmin(@Valid User user);

	/**
	 * To remove an user from country.
	 *
	 * @param requestDto - request dto
	 * @return boolean - true or false
	 */
	Boolean deleteRegionAdmin(CommonRequestDTO requestDTO);

	/**
	 * To get all active countries.
	 * 
	 * @param isActive - isactive status
	 * @return List of country entities.
	 */
	List<Country> getAllCountries(Boolean isActive);

	/**
	 * To get country by its tenantId
	 * 
	 * @param tenantId
	 * @return
	 */
	Country getCountryByTenantId(Long tenantId);

	/**
	 * To activate or deactivate an region by its tenantId.
	 * 
	 * @param id - tenantId
	 * @return Boolean - Activation confirmation
	 */
	boolean activateOrDeactiveRegion(Long id, Boolean isActive);
}
