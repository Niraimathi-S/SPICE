package com.mdtlabs.coreplatform.userservice.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import com.mdtlabs.coreplatform.common.model.dto.spice.CommonRequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.CountryOrganizationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OrganizationDTO;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.User;


/**
 * <p>
 * This an interface class for organization module you can implemented this class in any
 * class.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
public interface OrganizationService {

	/**
	 * <p>
	 * This method used to add a organization detail.
	 * </p>
	 *
	 * @param organization - organization to be added
	 * @return Organization - added organization information
	 */
	Organization addOrganization(Organization organization);

	/**
	 * <p>
	 * This method used to retrieve all the active organization.
	 * </p>
	 *
	 * @return List(Organization) - list of Organization Entity
	 */
	List<Organization> getAllOrganizations();

	/**
	 * <p>
	 * This method used to update a organization details.
	 * </p>
	 *
	 * @param organization - updating organization
	 * @return Organization - update organization entity
	 */
	Organization updateOrganization(Organization organization);

	/**
	 * <p>
	 * This method used to inactive a organization using id.
	 * </p>
	 *
	 * @param organizationId - organization id to be deleted
	 * @return int - value indicating the organization delete
	 */
	int deleteOrganizationById(long organizationId);

	/**
	 * <p>
	 * This method used to get a organization detail by id.
	 * </p>
	 *
	 * @param organizationId - organization id
	 * @return Organization - organization entity
	 */
	Organization getOrganizationById(long organizationId);

	/**
	 * <p>
	 * This method used to get a organization detail by name.
	 * </p>
	 *
	 * @param name - organization name
	 * @return Organization - organization entity
	 */
	Organization getOrganizationByName(String name);
	
	/**
	 * Gets user tenant Ids using user Id.
	 *
	 * @param userId - user ID
	 * @return List(Long) - List of user tenantIds.
	 */
	List<Long> getUserTenants(long userId);

	/**
	 * Creates an organization with users.
	 *
	 * @param organization - organization details with users
	 * @return Organization - organization entity.
	 */
//	Organization createOrganization(OrganizationDTO organization);

	/**
	 * Gets child organization IDs of an organization.
	 *
	 * @param tenantId organization tenantId
	 * @param formName organization form name
	 * @return Map(String, List(Long)) - collection of child organization IDs.
	 */
	Map<String, List<Long>> getChildOrganizations(long tenantId, String formName);
	
	/**
	 * To get list of organizations based on list of ids.
	 *
	 * @param organizationIds - list of organization ids
	 * @return Set(Role) - List of organization entity
	 */
	Set<Organization> getOrganizationsByIds(List<Long> organizationIds);

	/**
	 * Creates an admin user for an organization.
	 *
	 * @param user - user details
	 * @return user - User entity.
	 * @author Niraimathi S
	 */
	User addAdminUsers(User user);

	/**
	 * To update an admin user for an organization.
	 *
	 * @param user - user details
	 * @return user - user entity
	 * @author Niraimathi S
	 */
	User updateAdminUsers(User user);

	/**
	 * to remove an user from an organizations.
	 *
	 * @param requestDto - request data containing user id and tenantId
	 * @return Boolean 
	 * @author Niraimathi S
	 */
	Boolean deleteAdminUsers(CommonRequestDTO requestDTO);
	
	/**
	 * To activate or deactivate an organization.
	 * 
	 * @param tenantId - organization Id
	 * @param formName - Type of organization
	 * @param doActivate - activation status.
	 * @return Map<String, List<Long>> - Child organization Ids.
	 * @author Niraimathi S
	 */
	Map<String, List<Long>> activateDeactivateOrg(long tenantId, boolean doActivate);

	/**
	 * To validate parent organization .
	 * 
	 * @param parentOrganizationId - parent organization Id
	 * @param tenantIds - List of tenant ids
	 */
	void validateParentOrganization(Long parentOrganizationId, List<Long> tenantIds);

	void createCountry(@Valid CountryOrganizationDTO countryOrganizationDTO);
	
    void addOrganizationUsers(List<User> organizationUsers, List<String> roles, Organization organization);

}
