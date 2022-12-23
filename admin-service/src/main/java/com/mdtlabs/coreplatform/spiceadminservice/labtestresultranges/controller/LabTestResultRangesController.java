package com.mdtlabs.coreplatform.spiceadminservice.labtestresultranges.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestResultRangeDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestResultRangeRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResultRange;
import com.mdtlabs.coreplatform.spiceadminservice.labtestresultranges.service.LabTestResultRangesService;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;

/**
 * This controller class maintains the CRUD operations for lab test result
 * ranges.
 *
 * @author Jeyaharini T A
 *
 */
@RestController
@RequestMapping(value = "/labTestResultRanges")
@Validated
public class LabTestResultRangesController {

	@Autowired
	LabTestResultRangesService labTestResultRangesService;

	ModelMapper modelMapper = new ModelMapper();

	private static final List<String> noDataList = Arrays.asList(Constants.NO_DATA_FOUND);

	/**
	 * To add the lab test result ranges for the lab test result by its id.
	 *
	 * @param labTestResultRangeRequestDto entity
	 * @return List of added LabTestResultRange
	 * @author Jeyaharini T A
	 */
	@PostMapping
	public SuccessResponse<List<LabTestResultRange>> addLabTestResultRanges(
		@Valid @RequestBody LabTestResultRangeRequestDTO labTestResultRangeRequestDto) {
		labTestResultRangesService.addLabTestResultRanges(labTestResultRangeRequestDto);
		return new SuccessResponse<>(SuccessCode.LAB_TEST_RESULT_RANGE_SAVE, HttpStatus.CREATED);
	}

	/**
	 * To update the lab test result ranges.
	 *
	 * @param labTestResultRangeRequestDto entity
	 * @return List of updated LabTestResultRange
	 * @author Jeyaharini T A
	 */
	@PutMapping
	public SuccessResponse<List<LabTestResultRange>> updateLabTestResultRanges(
		@Valid @RequestBody LabTestResultRangeRequestDTO labTestResultRangeRequestDto) {
		labTestResultRangesService.updateLabTestResultRanges(labTestResultRangeRequestDto);
		return new SuccessResponse<List<LabTestResultRange>>(
			SuccessCode.LAB_TEST_RESULT_RANGE_UPDATE, HttpStatus.OK);
	}

	/**
	 * To remove the lab test result range by its id.
	 *
	 * @param id - lab test result id
	 * @return boolean - true or false
	 * @author Jeyaharini T A
	 */
	@PutMapping(value = "/{id}")
	public SuccessResponse<Boolean> removeLabTestResultRanges(@PathVariable long id) {
		labTestResultRangesService.removeLabTestResultRange(id);
		return new SuccessResponse<>(SuccessCode.LAB_TEST_RESULT_RANGE_DELETE, HttpStatus.OK);
	}

	/**
	 * To list the lab test result range's by lab test result id.
	 *
	 * @param labTestResultId - lab test result id
	 * @return List of LabTestResultRanges
	 * @author Jeyaharini T A
	 */
	@GetMapping(value = "/{labTestResultId}")
	public SuccessResponse<List<LabTestResultRangeDTO>> getLabTestResultRanges(
		@PathVariable long labTestResultId) {
		List<LabTestResultRange> retrievedLabTestResultRanges = labTestResultRangesService
			.getLabTestResultRange(labTestResultId);
		if (!retrievedLabTestResultRanges.isEmpty()) {
			List<LabTestResultRangeDTO> labTestResultRanges = modelMapper.map(retrievedLabTestResultRanges,
					new TypeToken<List<LabTestResultRangeDTO>>() {
					}.getType());

			return new SuccessResponse<List<LabTestResultRangeDTO>>(SuccessCode.GET_LAB_TEST_RESULT_RANGE,
					labTestResultRanges, labTestResultRanges.size(), HttpStatus.OK);
		}
		return new SuccessResponse<List<LabTestResultRangeDTO>>(SuccessCode.GET_LAB_TEST_RESULT_RANGE,
			noDataList, 0, HttpStatus.OK);
	}

}
