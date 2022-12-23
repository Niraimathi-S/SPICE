package com.mdtlabs.coreplatform.spiceadminservice.labtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResult;

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
public interface LabTestResultRepository extends JpaRepository<LabTestResult, Long> {

	//public static final String GET_LABTESTID = "SELECT labtest_id FROM labtestresult WHERE id = :id";
	//
	//@Query(value = GET_LABTESTID)
	//public Long getLabTestIdByResultId(@Param("id") long labTestResultId);

	public LabTestResult findByIdAndIsDeleted(long id, boolean isDeleted);

	public List<LabTestResult> findByLabTestIdAndIsDeletedAndIsActive(long labTestId, boolean isDeleted,
		boolean isActive);

}
