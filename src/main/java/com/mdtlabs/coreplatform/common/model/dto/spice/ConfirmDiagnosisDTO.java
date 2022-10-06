package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import lombok.Data;

@Data
public class ConfirmDiagnosisDTO extends CommonRequestDTO {

	private boolean isConfirmDiagnosis;

	private List<String> confirmDiagnosis;

	private String diagnosisComments;

}
