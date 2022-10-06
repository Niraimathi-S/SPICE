package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Set;

import lombok.Data;

@Data
public class CurrentMedicationDetailsDTO {
    
    private Set<CurrentMedicationDTO> medications;

    private boolean isDrugAllergies;

    private boolean isAdheringCurrentMed;
    
    private String adheringMedComment;

    private String allergiesComment;
}
