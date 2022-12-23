package com.mdtlabs.coreplatform.spiceadminservice.medication.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.dto.spice.MedicationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.OtherMedicationDTO;
import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.Medication;
import com.mdtlabs.coreplatform.spiceadminservice.medication.service.MedicationService;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessCode;
import com.mdtlabs.coreplatform.spiceadminservice.message.SuccessResponse;

/**
 * This class is a controller class to perform operation on medication entities.
 *
 * @author Niraimathi
 */
@RestController
@RequestMapping(value = "/medication")
@Validated
public class MedicationController {
	
	private static final List<String> noDataList = Arrays.asList(Constants.NO_DATA_FOUND);

	@Autowired
	private MedicationService medicationService;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * This method is used to add a new medication.
	 *
	 * @param medications List of medication
	 * @return List of medication entities
	 */
	@RequestMapping(method = RequestMethod.POST)
	public SuccessResponse<List<MedicationDTO>> addMedication(@Valid @RequestBody 
		List<Medication> medications) {
		medicationService.addMedication(medications);
		return new SuccessResponse<>(SuccessCode.MEDICATION_SAVE, HttpStatus.CREATED);
	}

	/**
	 * Used to update a medication detail like name, etc.,
	 *
	 * @param medication entity
	 * @return Medication Entity
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public SuccessResponse<Medication> updateMedication(@Valid @RequestBody Medication medication) {
		medicationService.updateMedication(medication);
		return new SuccessResponse<Medication>(SuccessCode.MEDICATION_UPDATE, HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve single medication's details using
	 * medicationId.
	 *
	 * @param requestDto - request dto
	 * @return Medication Entity
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public SuccessResponse<Medication> getMedicationById(@RequestBody RequestDTO requestDto) {
		return new SuccessResponse<Medication>(SuccessCode.GET_MEDICATION,
			medicationService.getMedicationById(requestDto), HttpStatus.OK);
	}

	/**
	 * This method is used to retreive all medication details.
	 *
	 * @param requestObject - request dto
	 * @return List of Medication Entity
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public SuccessResponse<List<MedicationDTO>> getAllMedications(@RequestBody RequestDTO requestObject) {
        Map<String, Object> medications = medicationService.getAllMedications(requestObject);
        List<Medication> medicationList = medications.containsKey("medicationList")
            ? (List<Medication>) medications.get("medicationList")
            : new ArrayList<>();
        Integer totalMedicationCount = medications.containsKey("totalCount") 
            ? Integer.parseInt(medications.get("totalCount").toString())
            : 0;
        int totalCount = 0;
        List<MedicationDTO>  medicationDtos = new ArrayList<>();
        if (!medicationList.isEmpty()) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            medicationDtos = modelMapper.map(medicationList, 
            	new TypeToken<List<MedicationDTO>>() {}.getType());
            totalCount = totalMedicationCount;
        }
        return new SuccessResponse<List<MedicationDTO>>(SuccessCode.GET_MEDICATIONS, 
        	medicationDtos, totalCount, HttpStatus.OK);
     }


	/**
	 * Used to soft delete a medication.
	 *
	 * @param requestDto - request dto
	 * @return Boolean - true or false
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public SuccessResponse<Boolean> deleteMedicationById(@RequestBody RequestDTO requestDto) {
		medicationService.deleteMedicationById(requestDto);
		return new SuccessResponse<Boolean>(SuccessCode.MEDICATION_STATUS_UPDATE, HttpStatus.OK);
	}

	/**
	 * Search and get medications list based on country.
	 *
	 * @param requestObject - request dto
	 * @return List of Medication entity
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public SuccessResponse<List<MedicationDTO>> searchMedications(@RequestBody RequestDTO requestObject) {
		List<Medication> medications = medicationService.searchMedications(requestObject);
		if (!medications.isEmpty()) {
			List<MedicationDTO> medicationDtos = modelMapper.map(medications, 
			new TypeToken<List<MedicationDTO>>() {
			}.getType());
			return new SuccessResponse<List<MedicationDTO>>(SuccessCode.GET_MEDICATIONS, medicationDtos,
					medicationDtos.size(), HttpStatus.OK);
		}
		return new SuccessResponse<List<MedicationDTO>>(SuccessCode.GET_MEDICATIONS, 
			noDataList, 0, HttpStatus.OK);
	}

	/**
	 * Used to validate a medication.
	 *
	 * @param medication - entity
	 * @return boolean based on validation
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public SuccessResponse<Boolean> validateMedication(@RequestBody Medication medication) {
		medicationService.validateMedication(medication);
		return new SuccessResponse<>(SuccessCode.VALIDATE_MEDICATION, HttpStatus.OK);
	}

	/**
	 * To get the other medication details.
	 *
	 * @param countryId - country id
	 * @return OtherMedicationDTO - entity
	 */
	@GetMapping("/other-medication/{countryId}")
	public ResponseEntity<OtherMedicationDTO> getOtherMedications(@PathVariable("countryId") long countryId) {

		Medication medication = medicationService.getOtherMedication(countryId);

		OtherMedicationDTO otherMedicationDto = modelMapper.map(medication, 
			new TypeToken<OtherMedicationDTO>() {
			}.getType());
		return new ResponseEntity<OtherMedicationDTO>(otherMedicationDto, HttpStatus.OK);
	}

}
