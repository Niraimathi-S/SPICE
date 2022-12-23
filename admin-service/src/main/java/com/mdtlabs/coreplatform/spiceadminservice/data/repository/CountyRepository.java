package com.mdtlabs.coreplatform.spiceadminservice.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdtlabs.coreplatform.common.model.entity.County;

/**
 * This is the repository interface helps maintain the DB connection to perform operations on County entity.
 *
 * @author Niraimathi S
 */
public interface CountyRepository extends JpaRepository<County, Long> {

	/**
	 * Finds a single County based on its name and country.
	 *
	 * @param countryId - county id
	 * @param name      - county name
	 * @return County Entity
	 * @author Niraimathi S
	 */
	public County findByCountryIdAndName(Long countryId, String name);

	/**
	 * Retrieves an County based on its Id and IsDeleted fields.
	 *
	 * @param id - county id
	 * @param b  - true or false
	 * @return County Entity.
	 * @author Niraimathi S
	 */
	public County findByIdAndIsDeleted(long id, boolean b);

	/**
	 * Gets all counties under a country using country id.
	 *
	 * @param countryId - country id
	 * @return List of County entites.
	 * @author Niraimathi S
	 */
	public List<County> findByCountryId(long countryId);
}
