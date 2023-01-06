package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;

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
public interface OperatingUnitRepository extends JpaRepository<Operatingunit, Long> {

	public static String GET_ALL_OPERATING_UNITS = "select operatingUnit from Operatingunit "
		+ "as operatingUnit where lower(operatingUnit.name) "
		+ " LIKE CONCAT('%',lower(:searchTerm),'%') AND operatingUnit.isDeleted=false AND"
		+ "(:countryId is null or operatingUnit.countryId=:countryId) AND (:accountId is null or "
		+ "operatingUnit.account.id=:accountId)";
	
	public static String GET_ALL_OPERATING_UNITS_BY_TENANTS = "select operatingUnit from Operatingunit "
		+ "as operatingUnit where lower(operatingUnit.name) "
		+ " LIKE CONCAT('%',lower(:searchTerm),'%') AND operatingUnit.isDeleted=false AND "
		+ "(:countryId is null or operatingUnit.countryId=:countryId) AND (:accountId is null or "
		+ "operatingUnit.account.id=:accountId)";
	
	public static String GET_ALL_OPERATING_UNITS_COUNT = "select count(operatingUnit.id) from Operatingunit "
		+ "as operatingUnit where lower(operatingUnit.name) "
		+ " LIKE CONCAT('%',lower(:searchTerm),'%') AND operatingUnit.isDeleted=false AND "
		+ "(:countryId is null or operatingUnit.countryId=:countryId) AND (:accountId is null "
		+ "or operatingUnit.account.id=:accountId)";

	public static String COUNT_BY_COUNTRY_AND_ACCOUNT_ID = "select count(operatingUnit.id) from Operatingunit as "
		+ "operatingUnit where (:countryId is null or operatingUnit.countryId=:countryId) AND (:accountId "
		+ "is null or operatingUnit.account.id=:accountId) AND operatingUnit.isDeleted=false AND "
		+ "operatingUnit.isActive=:isActive";
	
	public static String GET_BY_ACCOUNT_ID_AND_COUNTRY_ID = "select operatingUnit from Operatingunit as "
			+ "operatingUnit where operatingUnit.isDeleted=false AND "
			+ " (:countryId is null or operatingUnit.countryId=:countryId) AND (:accountId "
			+ "is null or operatingUnit.account.id=:accountId) AND "
			+ "operatingUnit.isActive=:isActive";
	
	/**
	 * To get count of all operating units.
	 *
	 * @return int - count of operating units
	 */
	int countByIsDeletedFalse();

	/**
	 * Gets  alist of operating units based on its name.
	 *
	 * @param searchTerm - search string to search operating units.
	 * @param pageable - Pageable object.
	 * @return List(Operatingunit) - List of operating units.
	 */
	@Query(value = GET_ALL_OPERATING_UNITS)
	List<Operatingunit> findOperatingUnitList(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		@Param("accountId") Long accountId, Pageable pageable);

	/**
	 * Gets list of operatingunits based on country or account id and operating unit name
	 * 
	 * @param searchTerm - searchTerm 
	 * @param countryId - country Id
	 * @param accountId
	 * @param pageable
	 * @return
	 */
	@Query(value = GET_ALL_OPERATING_UNITS_BY_TENANTS)
	List<Operatingunit> getOperatingUnits(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		@Param("accountId") Long accountId, Pageable pageable);

	/**
	 * 
	 * @param searchTerm
	 * @param tenants
	 * @return
	 */
	@Query(value = GET_ALL_OPERATING_UNITS_COUNT)
	int getOperatingUnitsCount(@Param("searchTerm") String searchTerm, @Param("countryId") Long countryId,
		@Param("accountId") Long accountId);

	/**
	 * 
	 * @param id
	 * @param booleanTrue
	 * @param booleanFalse
	 * @param tenantId 
	 * @return
	 */
	Operatingunit findByIdAndIsActiveAndIsDeletedAndTenantId(long id, Boolean booleanTrue, Boolean booleanFalse, Long tenantId);

	/**
	 * To get list of operating unit based on isactive and list of tenantIds
	 * 
	 * @param isActive - isActive
	 * @param tenantIdList - List of tenantIds
	 * @return List<Operatingunit> - List of Operatingunit Entities
	 */
	List<Operatingunit> findByIsDeletedFalseAndIsActiveAndTenantIdIn(boolean isActive, List<Long> tenantIdList);

	/**
	 * To get list of operating unit based on isactive and countryId
	 * 
	 * @param isActive - isActive
	 * @param tenantIdList - List of tenantIds
	 * @return List<Operatingunit> - List of Operatingunit Entities
	 */
	List<Operatingunit> findByIsDeletedFalseAndIsActiveAndCountryId(Boolean booleanTrue, Long organizationId);

	/**
	 * To get list of operating unit based on isactive and Account Id
	 * 
	 * @param isActive - isActive
	 * @param tenantIdList - List of tenantIds
	 * @return List<Operatingunit> - List of Operatingunit Entities
	 */
	List<Operatingunit> findByIsDeletedFalseAndIsActiveAndAccountId(Boolean booleanTrue, Long organizationId);

	/**
	 * Gets count of operating units by countryId
	 * 
	 * @param countryId - countryId
	 * @param isActive - isActive
	 * @return Integer - count of Operating unit entity
	 * 
	 */
	@Query(value = COUNT_BY_COUNTRY_AND_ACCOUNT_ID)
	Integer getCount(@Param("countryId") Long countryId, @Param("accountId") Long accountId,
		@Param("isActive") boolean isActive);

	@Query(value = GET_BY_ACCOUNT_ID_AND_COUNTRY_ID)
	List<Operatingunit> findByCountryIdAndAccountIdAndIsActive(@Param("countryId") Long countryId, @Param("accountId") Long accountId, @Param("isActive") boolean isActive);

	Operatingunit findByIdAndIsDeletedFalseAndIsActive(long id, boolean isActive);

	Operatingunit findByNameIgnoreCaseAndIsDeletedFalse(String name);	
}
