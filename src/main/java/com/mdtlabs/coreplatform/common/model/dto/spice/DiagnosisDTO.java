package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class DiagnosisDTO {

    private Integer htnYearOfDiagnosis;

    private Integer diabetesYearOfDiagnosis;

    private String htnPatientType;

    private String diabetesPatientType;

    private String diabetesDiagnosis;

    private String diabetesDiagControlledType;

    private Boolean isHtnDiagnosis;

    private Boolean isDiabetesDiagnosis;
    
}
