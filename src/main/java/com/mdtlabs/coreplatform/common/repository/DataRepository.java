package com.mdtlabs.coreplatform.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.model.entity.ApiRolePermission;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Timezone;
import com.mdtlabs.coreplatform.common.model.entity.User;

/**
 * <p>
 * This is the repository class for communicate link between server side and
 * database. This class used to perform all the user module action in database.
 * In query annotation (nativeQuery = true) the below query perform like SQL.
 * Otherwise its perform like HQL default value for nativeQuery FALSE
 * </p>
 * 
 * @author Prabu created on Oct 03, 2022
 */
@Repository
public interface DataRepository extends JpaRepository<User, Long> {

	public static final String GET_ALL_COUNTRY = "select country from Country as country where country.isActive = true";
	public static final String GET_ALL_TIMEZONE = "select timezone from Timezone as timezone where timezone.isActive = true";
	public static final String GET_COUNTRY_BY_ID = "select country from Country as country where country.id =:id and country.isActive = true";
	public static final String GET_TIMEZONE_BY_ID = "select timezone from Timezone as timezone where timezone.id =:id and timezone.isActive = true";
	public static final String GET_API_ROLE_PERMISSION = "select apiRolePermission from ApiRolePermission as apiRolePermission";

	/**
	 * <p>
	 * Get all the country list.
	 * </p>
	 * 
	 * @return List of country.
	 */
	@Query(value = GET_ALL_COUNTRY)
	List<Country> getCountryList();

	/**
	 * <p>
	 * Get all the timezone list.
	 * </p>
	 * 
	 * @return List of timezone.
	 */
	@Query(value = GET_ALL_TIMEZONE)
	List<Timezone> getTimezoneList();

	/**
	 * <p>
	 * Used to get the country object by id.
	 * </p>
	 * 
	 * @return Country - country object
	 */
	@Query(value = GET_COUNTRY_BY_ID)
	public Country getCountryById(@Param(FieldConstants.ID) String id);

	/**
	 * <p>
	 * Used to get the country object by id.
	 * </p>
	 * 
	 * @return Timezone - timezone object
	 */
	@Query(value = GET_TIMEZONE_BY_ID)
	public Timezone getTimezoneById(@Param(FieldConstants.ID) String id);

	/**
	 * This method is used to get api roles permission
	 * 
	 * @return List<ApiRolePermission> - list of ApiRolePermission entity
	 */
	@Query(value = GET_API_ROLE_PERMISSION)
	public List<ApiRolePermission> getApiRolePermission();

}