package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import lombok.Data;

@Data
public class PatientDetailsDTO {

    private Boolean isConfirmDiagnosis;

    private List<String> provisionalDiagnosis;

    private List<String> confirmDiagnosis;

    public PatientDetailsDTO(Boolean isConfirmDiagnosis, List<String> provisionalDiagnosis,
    List<String> confirmDiagnosis) {
        this.isConfirmDiagnosis = isConfirmDiagnosis;
        this.provisionalDiagnosis = provisionalDiagnosis;
        this.confirmDiagnosis = confirmDiagnosis;
    }

    public PatientDetailsDTO() {
    }

    

    

}
