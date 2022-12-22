package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Set;

import lombok.Data;

@Data
public class ContinuousMedicalReviewDTO extends CommonRequestDTO {

	private Set<Long> physicalExams;

	private Set<Long> complaints;

	private String complaintComments;

	private String physicalExamComments;

	private String clinicalNote;
}
