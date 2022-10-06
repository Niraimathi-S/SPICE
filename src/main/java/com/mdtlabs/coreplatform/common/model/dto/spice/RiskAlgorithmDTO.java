package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Set;

import lombok.Data;

@Data
public class RiskAlgorithmDTO {

    private Long patientTrackId;
    
    private String glucoseType;

    private Float glucoseValue;

    private Integer avgDiastolic;

    private Integer avgSystolic;

    private Boolean isPregnant;

    private String riskLevel;

    private Set<Long> symptoms;

}