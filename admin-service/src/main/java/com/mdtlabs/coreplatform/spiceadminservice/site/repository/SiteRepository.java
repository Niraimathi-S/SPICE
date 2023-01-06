package com.mdtlabs.coreplatform.spiceadminservice.site.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	public static String COUNT_BY_COUNTRY_ACCOUNT_OU_ID = "select count(site.id) from Site as "
		+ "site where (:countryId is null or site.countryId=:countryId) AND (:accountId "
		+ "is null or site.accountId=:accountId) AND (:operatingUnitId is null or site.operatingUnit.id="
		+ ":operatingUnitId) AND site.isDeleted=false AND site.isActive=:isActive";
	
	public static String GET_SITE = "select site from Site as site where (:countryId is null or site.countryId=:countryId) "
		+ "AND (:accountId is null or site.accountId=:accountId) AND (:operatingUnitId is null or site.operatingUnit.id =:operatingUnitId) "
		+ "AND site.isDeleted=false AND site.isActive=:isActive";
	
	public static String GET_SITE_LIST = "select site from Site as site where (:searchTerm is null "
			+ "or lower(site.name) LIKE CONCAT('%',lower(:searchTerm),'%')) and (:countryId is null or "
			+ "site.countryId=:countryId) and (:opreatingUnitId is null or site.operatingUnit.id=:opreatingUnitId) " 
			+ "and (:accountId is null or site.accountId=:accountId)";
	
	public static String GET_SITE_LIST_COUNT = "select count(site.id) from Site as site where (:searchTerm is null "
			+ "or lower(site.name) LIKE CONCAT('%',lower(:searchTerm),'%')) and (:countryId is null or "
			+ "site.countryId=:countryId) and (:opreatingUnitId is null or site.operatingUnit.id=:opreatingUnitId) " 
			+ "and (:accountId is null or site.accountId=:accountId)";
	
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

	/**
	 * To get list of sites based on list of tenantIds
	 * 
	 * @param isActive - isActive
	 * @param siteIds - List of site tenantIds
	 * @return List(Site) - List of Site entity
	 * @author Niraimathi S
	 */
	public List<Site> findByIsDeletedFalseAndIsActiveAndTenantIdIn(boolean isActive, List<Long> siteIds);

	/**
	 * Return the count of sites using countryId, isDeleted and isActive fields.
	 * 
	 * @param countryId - country Id
	 * @param isActive - isActive
	 * @return integer - count of operting units
	 * @author Niraimathi S
	 */
	@Query(value = COUNT_BY_COUNTRY_ACCOUNT_OU_ID)
	Integer getCount(@Param("countryId") Long countryId, @Param("accountId") Long accountId, 
			@Param("operatingUnitId") Long operaitngUnitId, @Param("isActive") boolean isActive);

	public Site findByIdAndIsDeletedFalseAndTenantId(Long id, Long tenantId);

	@Query(value = GET_SITE)
	public List<Site> findSite(@Param("countryId") Long countryId, @Param("accountId") Long accountId, 
		@Param("operatingUnitId") Long operaitngUnitId,
		@Param("isActive") boolean isActive);	
	
	@Query(value = GET_SITE_LIST)
	List<Site> getAllSite(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		@Param("accountId") Long accountId, @Param("opreatingUnitId") Long opreatingUnitId,	Pageable pageable);

	@Query(value = GET_SITE_LIST_COUNT)
	int getAllSiteCount(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		@Param("accountId") Long accountId, @Param("opreatingUnitId") Long opreatingUnitId);
}
