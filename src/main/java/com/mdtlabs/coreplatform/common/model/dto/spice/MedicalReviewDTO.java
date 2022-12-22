package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class MedicalReviewDTO extends CommonRequestDTO {

	private InitialMedicalReviewDTO initialMedicalReview;

	private ContinuousMedicalReviewDTO continuousMedicalReview;

	private Boolean isPregent;



}
