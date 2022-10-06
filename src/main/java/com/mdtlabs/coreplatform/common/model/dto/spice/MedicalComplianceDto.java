package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class MedicalComplianceDto {

    private Boolean isChildExists;

    private String name;

    private Long complianceId;
    
}
