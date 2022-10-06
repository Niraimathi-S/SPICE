package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class BioMetricsDTO {

    private String gender;

    private Integer age;

    private Float height;

    private Float weight;

    private Float bmi;

    private boolean isRegularSmoker;

    private Boolean isPregnant;

    private Boolean isphysicallyActive;

    private boolean isFamilyDiabetesHistory;

    private boolean isBeforeGestationalDiabetes;
     
}