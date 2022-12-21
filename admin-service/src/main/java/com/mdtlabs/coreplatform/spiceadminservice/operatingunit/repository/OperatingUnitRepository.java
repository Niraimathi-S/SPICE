package com.mdtlabs.coreplatform.spiceadminservice.operatingunit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;

@Repository
public interface OperatingUnitRepository extends JpaRepository<Operatingunit, Long> {

	public static String GET_ALL_OPERATING_UNITS = "select operatingUnit from Operatingunit as operatingUnit where lower(operatingUnit.name)"
			+ " LIKE CONCAT('%',lower(:searchTerm),'%') AND operatingUnit.isDeleted=false order by operatingUnit.updatedBy";

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
	 * @return List<Operatingunit> - List of operating units.
	 */
	@Query(value = GET_ALL_OPERATING_UNITS)
	List<Operatingunit> findOperatingUnitList(@Param("searchTerm") String searchTerm, Pageable pageable);

}
