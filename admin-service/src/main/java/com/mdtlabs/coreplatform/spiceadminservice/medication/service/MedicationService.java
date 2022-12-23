package com.mdtlabs.coreplatform.spiceadminservice.medication.service;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.dto.spice.RequestDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.Medication;


/**
 * This is an interface to perform any actions in medication entities.
 *
 * @author Niraimathi
 *
 */
public interface MedicationService {

	/**
	 * This method is used to add a new medication.
	 *
	 * @param medication entity
	 * @return Medication Entity
	 */
	public List<Medication> addMedication(List<Medication> medication);

	/**
	 * This method is used to update a medication details like name.
	 *
	 * @param medication - entity
	 * @return Medication Entity
	 */
	public Medication updateMedication(Medication medication);

	/**
	 * This method retrieves a single medication's details.
	 *
	 * @param requestDto - request dto
	 * @return Medication Entity
	 */
	public Medication getMedicationById(RequestDTO requestDto);

	/**
	 * Retrieves all medication's details.
	 *
	 * @param requestObject - request dto
	 * @return List of Medication Entity
	 */
	public  Map<String, Object> getAllMedications(RequestDTO requestObject);

	/**  
	 * This method is used to update the status of a medication which is soft
	 * deleted.
	 *
	 * @param requestDto - request dto
	 * @return Boolean - true or false
	 */
	public Boolean deleteMedicationById(RequestDTO requestDto);

	/**
	 * This method used to get medication based on country.
	 *
	 * @param requestObject - request dto
	 * @return List of medication entities.
	 */
	public List<Medication> searchMedications(RequestDTO requestObject);

	/**
	 * Used to validate medication details.
	 *
	 * @param medication - entity
	 * @return boolean - true of false
	 */
	public Boolean validateMedication(Medication medication);

	/**
	 * Used to get other medication details.
	 *
	 * @param countryId - country id
	 * @return Medication entity
	 */
	public Medication getOtherMedication(long countryId);
}
