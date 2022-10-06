package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class CurrentMedicationDTO {
    
    private Long CurrentMedicationId;

    private String name;

    private String type;

    private String otherMedication;
}
