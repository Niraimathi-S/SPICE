package com.mdtlabs.coreplatform.spiceadminservice.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.Country;

/**
 * This Repository interface maintains connection between Country entity and
 * database.
 *
 * @author Karthick M
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public static final String GET_ALL_COUNTRIES = "select country from Country as country "
		+ "where country.isDeleted=false";
	public static final String GET_COUNTRIES_BY_NAME = "select country from Country as "
		+ "country where lower(country.name) LIKE CONCAT('%',lower(:searchTerm),'%')"
		+ " AND country.isDeleted=false order by country.updatedBy";
	public static final String GET_COUNTRIES_COUNT_BY_NAME = "select count(id) from Country "
		+ "as country where lower(country.name)"
		+ " LIKE CONCAT('%',lower(:searchTerm),'%') AND country.isDeleted=false";

	/**
	* Finds a country based on countryCode and name.
	*
	* @param countryCode - country code
	* @param name - country name
	* @return List(Country) - list of countries
	*/
	List<Country> findByCountryCodeOrNameOrIdIsNot(String countryCode, String name, long id);

	/**
	* Finds a country based on countryCode and name.
	*
	* @param countryCode - country code
	* @param name - country name
	* @return List(Country) - list of countries
	*/
	List<Country> findByCountryCodeOrName(String countryCode, String name);

	/**
	* Finds the country based on countrycode and name.
	*
	* @param countryCode - country code
	* @param name  -country name
	* @return Country - country entity
	* @author Karthick M
	*/
	Country findByCountryCodeAndName(String countryCode, String name);

	/**
	* Finds the country based on countrycode.
	*
	* @param countryCode - country code
	* @return Country - entity
	* @author Karthick M
	*/
	Country findByCountryCode(String countryCode);

	/**
	* Finds the country based on name.
	*
	* @param name - country name
	* @returN Country - entity
	*/
	Country findByName(String name);

	/**
	* Finds the country based on countryId.
	*
	* @param countryId - country id
	* @return Country - country entity
	* @author Karthick M
	*/
	Country findById(long countryId);

	/**
	* Retrives the all countries.
	*
	* @param pageable - pageable
	* @return Pageable - pageable
	* @author Karthick M
	*/
	@Query(value = GET_ALL_COUNTRIES)
	Page<Country> getAllCountries(Pageable pageable);

	/**
	* Retrives the all countries based on the search term.
	*
	* @param searchTerm - search term
	* @param pageable - pageable
	* @return Page(Country) - country entity
	* @author Karthick M
	*/
	@Query(value = GET_COUNTRIES_BY_NAME)
	Page<Country> searchCountries(@Param("searchTerm") String searchTerm, Pageable pageable);

	/**
	 * Retrives the all countries count based on the search term.
	 *
	 * @param searchTerm
	 * @author Nandhakumar karthikeyan
	 */
	@Query(value = GET_COUNTRIES_COUNT_BY_NAME)
	int getCountryCountByName(@Param("searchTerm") String searchTerm);

	/** Finds the country based on countryId and isActive.
	*
	* @param countryId - country id
	* @param isActive - true  or false
	* @return Country - entity
	* @author Karthick M
	*/
	Country findByIdAndIsActive(long countryId, boolean isActive);

	/**
	* Finds the country based on countryId and isDeleted.
	*
	* @param countryId - country id
	* @param isDeleted - true or false
	* @return Country - entity
	* @author Karthick M
	*/
	Country findByIdAndIsDeleted(long countryId, boolean isDeleted);

	/**
	* To find a country by its Id, isDeleted and isActive fields.
	*
	* @param id country Id
	* @return List of country entity
	*/
	List<Country> findByIdAndIsDeletedFalseAndIsActiveTrue(long id);

	/**
	* To find the number of countries present. 
	*
	* @return Number of countries.
	*/
	int countByIsDeletedFalse();

}
