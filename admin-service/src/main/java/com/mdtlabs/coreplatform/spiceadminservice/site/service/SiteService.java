package com.mdtlabs.coreplatform.spiceadminservice.site.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.Site;

/**
 * <p>
 * This an interface class for site module you can implemented this class in any
 * class.
 * </p>
 *
 * @author VigneshKumar created on Jun 30, 2022
 */
public interface SiteService {

	/**
	 * To add a site.
	 *
	 * @param site - entity
	 * @return Site entity
	 * @author Jeyaharini T A
	 */
	public Site addSite(Site site);

	/**
	 * To update a site.
	 *
	 * @param site entity
	 * @return Site entity
	 * @author Jeyaharini T A
	 */
	public Site updateSite(Site site);

	/**
	 * To activate or deactive a site.
	 *
	 * @param id - site id
	 * @param isActiveStatus - true or false
	 * @return Site entity
	 * @author Jeyaharini T A
	 */
	public Site activateDeactivateSite(long id, boolean isActiveStatus);

	/**
	 * Gets list of sites using tenantIds.
	 *
	 * @param tenants List of tenantIds
	 * @return List of Site Entities.
	 * @author Niraimathi S
	 */
	public List<Site> getSitesByTenantIds(List<Long> tenants);

	/**
	 * Gets list if sites based onperating unit Id.
	 *
	 * @param operatingUnitId operating unit Id.
	 * @return List of Site Entities.
	 * @author Niraimathi S
	 */
	public List<Site> getSitesByOperatingUnitId(Long operatingUnitId);

	/**
	 * Gets a site using id and isDeleted fields.
	 *
	 * @param siteId site id
	 * @return Site entity
	 * @author Niraimathi S
	 */
	public Site getSiteById(Long siteId);

	/**
	 * To activate or deactivate list of sites based on its tenantIds
	 * 
	 * @param tenantIds - list of tenant Ids
	 * @param isActive - isActive
	 * @return Boolean - Activation Status
	 * @author Niraimathi S
	 */
    public boolean activateDeactivateSiteList(List<Long> tenantIds, boolean isActive);

    /**
     * To get Count of Sites using countryId
     * 
     * @param countryId - country Id
     * @param isActive - isActive
     * @return Integer - count of sites
	 * @author Niraimathi S
     */
	public Integer getCount(Long countryId, Long accountId, Long operatingUnitId, boolean isActive);
    
}
