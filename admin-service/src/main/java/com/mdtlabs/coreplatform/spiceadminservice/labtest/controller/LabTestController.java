package com.mdtlabs.coreplatform.spiceadminservice.labtest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.reflect.TypeToken;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.LabTestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.SearchRequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTest;
import com.mdtlabs.coreplatform.common.model.entity.spice.LabTestResult;
import com.mdtlabs.coreplatform.spiceadminservice.labtest.service.LabTestService;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;

/**
 * This class is a controller class to perform operation on Labtest entities.
 *
 * @author Niraimathi S
 */
@RestController
@RequestMapping(value = "/labtest")
@Validated
public class LabTestController {

	private static final List<String> noDataList = Arrays.asList(Constants.NO_DATA_FOUND);

	@Autowired
	private LabTestService labTestService;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * This method is used to add a new Labtest.
	 *
	 * @param labTest - entity
	 * @return LabTest Entity.
	 * @author Niraimathi S
	 */
	@RequestMapping(method = RequestMethod.POST)
	public SuccessResponse<LabTest> addLabTest(@Valid @RequestBody LabTest labTest) {
		labTestService.addLabTest(labTest);
		return new SuccessResponse<>(SuccessCode.LABTEST_SAVE, HttpStatus.CREATED);
	}

	/**
	 * This method is used to get list of Labtests under a country.
	 *
	 * @param requestObject - request dto
	 * @return List of LabTest Entities.
	 * @author Niraimathi S
	 */
	@RequestMapping(method = RequestMethod.GET)
	public SuccessResponse<List<LabTestDTO>> getAllLabTests(@RequestBody RequestDTO requestObject) {
		List<LabTest> labTests = labTestService.getAllLabTests(requestObject);
		if (!labTests.isEmpty()) {
			List<LabTestDTO> labTestDtos = modelMapper.map(labTests, new TypeToken<List<LabTestDTO>>() {
			}.getType());
			return new SuccessResponse<List<LabTestDTO>>(SuccessCode.GET_LABTESTS, 
				labTestDtos, labTestDtos.size(), HttpStatus.OK);
		}
		return new SuccessResponse<List<LabTestDTO>>(SuccessCode.GET_LABTESTS,
			noDataList, 0, HttpStatus.OK);
	}

	/**
	 * This method is used to search a labtest using labtest name.
	 *
	 * @param requestDto - request dto
	 * @return List of LabTest entities.
	 * @author Niraimathi S
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public SuccessResponse<List<Map>> searchLabtests(@RequestBody RequestDTO requestDto) {
		List<Map> labTests = labTestService.searchLabTests(requestDto);
		if (!labTests.isEmpty()) {
			// List<Map> labTestDTOs = modelMapper.map(labTests, new TypeToken<List<Map>>()
			// {
			// }.getType());
			return new SuccessResponse<List<Map>>(SuccessCode.GET_LABTESTS, 
				labTests, labTests.size(), HttpStatus.OK);
		}
		return new SuccessResponse<List<Map>>(SuccessCode.GET_LABTESTS, noDataList, 0, HttpStatus.OK);
	}

	/**
	 * Used to soft delete a labtest.
	 *
	 * @param requestDto Request data containing labtest id.
	 * @return Boolean True if labtest removed else false.
	 * @author Karthick M
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public SuccessResponse<Boolean> removeLabTest(@RequestBody RequestDTO requestDto) {
		labTestService.removeLabTest(requestDto, true);
		return new SuccessResponse<>(SuccessCode.LABTEST_DELETE, HttpStatus.OK);
	}

	/**
	 * Used to update a labTest detail like name, etc.
	 *
	 * @param labTest - entity
	 * @return labTest Entity
	 * @author Karthick M
	 */
	@RequestMapping(method = RequestMethod.PATCH)
	public SuccessResponse<LabTest> updateLabTest(@Valid @RequestBody LabTest labTest) {
		labTestService.updateLabTest(labTest);
		return new SuccessResponse<>(SuccessCode.LABTEST_UPDATE, HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve single labtest's details using labTestId.
	 *
	 * @param requestDto Request data containing labtest id.
	 * @return LabTest Entity
	 * @author Karthick M
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public SuccessResponse<LabTest> getLabTestById(@RequestBody RequestDTO requestDto) {
		return new SuccessResponse<>(SuccessCode.GET_LABTEST, 
			labTestService.getLabTestById(requestDto), HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve single labtest results details using
	 * labTestId.
	 *
	 * @param labTestId - lab test id
	 * @return LabTest Entity
	 * @author Niraimathi S
	 */
	@RequestMapping(value = "/labtest-result/{id}", method = RequestMethod.GET)
	public SuccessResponse<List<LabTestResult>> getLabTestResultsById(
		@PathVariable(value = "id") long labTestId) {
		List<LabTestResult> results = labTestService.getLabTestResultsById(labTestId);
		return new SuccessResponse<List<LabTestResult>>(SuccessCode.GET_LABTEST, results, results.size(),
				HttpStatus.OK);
	}

	/**
	 * Validates the labTest.
	 *
	 * @param labTest - entity
	 * @return Boolean - true or false
	 * @author Karthick M
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public SuccessResponse<Boolean> validateLabTest(@Valid @RequestBody LabTest labTest) {
		///return ResponseEntity.ok().body(labTestService.validateLabTest(labTest));
		labTestService.validateLabTest((labTest));
		return new SuccessResponse<Boolean>(SuccessCode.LABTEST_VALIDATE, HttpStatus.OK);
	}

	/**
	 * Gets single LabTest Entity based on the labTest name and countryId.
	 *
	 * @param searchRequestDto - search request dto
	 * @return LabTest Entity
	 */
	@RequestMapping(value = "/patient-labtest/get-by-name", method = RequestMethod.POST)
	public ResponseEntity<LabTest> getLabTestbyName(@RequestBody SearchRequestDTO searchRequestDto) {
		return ResponseEntity.ok().body(
				labTestService.getLabTestbyName(searchRequestDto.getSearchTerm(), 
				searchRequestDto.getCountryId()));

	}

	/**
	 * Get a List of LabTest based on list of labtest Ids.
	 *
	 * @param labTestIds - set of lab test ids
	 * @return List of LabTest Entity.
	 */
	@RequestMapping(value = "/patient-labtest/get-list-by-ids", method = RequestMethod.POST)
	public ResponseEntity<List<LabTest>> getLabTestsById(@RequestBody Set<Long> labTestIds) {
		return ResponseEntity.ok().body(labTestService.getLabTestsById(labTestIds));
	}
}
