package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This class contains the fields to filter the patients
 * @author Jeyaharini T A
 *
 */
@Data
public class PatientFilterDTO {

	private String medicalReviewDate;

	private String assessmentDate;

	private Boolean isRedRiskPatient;

	private String cvdRiskLevel;

	private Boolean screeningReferral;
	
	private String patientStatus;
}
