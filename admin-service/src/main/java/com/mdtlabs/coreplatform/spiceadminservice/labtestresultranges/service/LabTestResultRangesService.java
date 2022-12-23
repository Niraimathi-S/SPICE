package com.mdtlabs.coreplatform.spiceadminservice.labtestresultranges.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestResultRangeRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResultRange;

/**
 * This interface maintains the CRUD operation for lab test result range.
 *
 * @author Jeyaharini T A
 *
 */
public interface LabTestResultRangesService {

	/**
	 * To add the list of LabTestResultRanges.
	 *
	 * @param labTestResultRangeDto entity
	 * @return List of added LabTestResultRange
	 * @author Jeyaharini T A
	 */
	public List<LabTestResultRange> addLabTestResultRanges(LabTestResultRangeRequestDTO labTestResultRangeDto);

	/**
	 * To update the list of LabTestResultRanges by it's id.
	 *
	 * @param labTestResultRangeRequestDto entity
	 * @return List of updated LabTestResultRange
	 * @author Jeyaharini T A
	 */
	public List<LabTestResultRange> updateLabTestResultRanges(
		LabTestResultRangeRequestDTO labTestResultRangeRequestDto);

	/**
	 * To remove the list of LabTestResultRange by it's id.
	 *
	 * @param id - lab test result id
	 * @return boolean - removal status
	 * @author Jeyaharini T A
	 */
	public boolean removeLabTestResultRange(long id);

	/**
	 * To list the LabTestResultRange by lab test result id.
	 *
	 * @param labTestResultId - lab test result id
	 * @return List of LabTestResultRangeDTO
	 * @author Jeyaharini T A
	 */
	public List<LabTestResultRange> getLabTestResultRange(long labTestResultId);

}
