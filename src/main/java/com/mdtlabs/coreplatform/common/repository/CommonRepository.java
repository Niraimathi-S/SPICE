package com.mdtlabs.coreplatform.common.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.ApiRolePermission;
import com.mdtlabs.coreplatform.common.model.entity.Audit;

/**
 * <p>
 * This is the repository class for auditing all the values This class used to
 * perform auditing action in database. In query annotation (nativeQuery = true)
 * the below query perform like SQL. Otherwise its perform like HQL default
 * value for nativeQuery FALSE
 * </p>
 * 
 * @author Prabu created on July 11, 2022
 *
 */

@Repository
public interface CommonRepository extends JpaRepository<Audit, Long> {

	public static final String GET_API_ROLE_PERMISSION = "select apiRolePermission from ApiRolePermission as apiRolePermission";

	/**
	 * This method is used to get api roles permission
	 * 
	 * @return List<ApiRolePermission> - list of ApiRolePermission entity
	 */
	@Query(value = GET_API_ROLE_PERMISSION)
	public List<ApiRolePermission> getApiRolePermission();

}