package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class PatientGetRequestDTO {
    private Long id;
    private boolean assessmentRequired;
    private boolean isAssessmentDataRequired;
//    private boolean isConfirmDiagnosis;
    private boolean isGad7;
    private boolean isLifeStyleRequired;
    private boolean isPhq9;
    private boolean isPregnant;
    private boolean isPrescriberRequired;
    private boolean isRedRiskPatient;
}
