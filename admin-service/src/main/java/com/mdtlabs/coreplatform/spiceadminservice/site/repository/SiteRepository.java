package com.mdtlabs.coreplatform.spiceadminservice.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.Site;

/**
 * <p>
 * This is the repository class for communicate link between server side and
 * database. This class used to perform all the user module action in database.
 * In query annotation (nativeQuery = true) the below query perform like SQL.
 * Otherwise its perform like HQL default value for nativeQuery FALSE
 * </p>
 *
 * @author VigneshKumar created on Jun 20, 2022
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
	
	public boolean existsByName(String name);

	/**
	 * Gets list of sites based on list of tenant Ids.
	 *
	 * @param tenants list of tenant IDs
	 * @return List of site entities
	 */
	public List<Site> findByIsDeletedFalseAndTenantIdIn(List<Long> tenants);

	
	/**
	 * Gets list of sites based on oeprating unit Id.
	 *
	 * @param operatingUnitId Operating unit ID
	 * @return List of site entities
	 */
	public List<Site> findByOperatingUnitIdAndIsDeletedFalse(Long operatingUnitId);

	/**
	 * Gets a site using id and isDeleted fields.
	 *
	 * @param siteId site id
	 * @return Site entity
	 */
	public Site findByIdAndIsDeletedFalse(Long siteId);
}
