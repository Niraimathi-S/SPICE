package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This class contains the fields to sort the patients
 * 
 * @author Jeyaharini T A
 *
 */
@Data
public class PatientSortDTO extends PaginateDTO {

	private Boolean isRedRiskPatientAsc;

	private Boolean nextMedicalReviewDateAsc;
	
	private Boolean cvdRiskScoreAsc;
	private Boolean nextBpAssessmentDateAsc;

}
