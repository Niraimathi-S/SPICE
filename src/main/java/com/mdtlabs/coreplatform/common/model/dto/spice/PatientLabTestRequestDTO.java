package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;

import lombok.Data;

@Data
public class PatientLabTestRequestDTO {
	private Long tenantId;

	private Long patientVisitId;

	@NotNull(message = ErrorConstants.PATIENT_TRACK_ID_NOT_NULL)
	private Long patientTrackId;

	@Valid
	private List<PatientLabTestDTO> labTest;

}