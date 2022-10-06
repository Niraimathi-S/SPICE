package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * Fields needed to search a patient
 * 
 * @author Jeyaharini T A
 *
 */
@Data
public class PatientRequestDTO {

	private String searchId;

	private Boolean isSearchUserOrgPatient;

	private Long tenantId;

	private Long operatingUnitId;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private Boolean isGlobally;

	private Boolean isLabtestReferred;

	private PatientFilterDTO patientFilterDTO;

	private PatientSortDTO patientSortDTO;
}
