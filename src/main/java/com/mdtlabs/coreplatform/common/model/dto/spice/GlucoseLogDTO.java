package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;

import lombok.Data;

@Data
public class GlucoseLogDTO {
    public GlucoseLogDTO(String glucoseType, Float glucoseValue, Date lastMealTime, Date glucoseDateTime,
                         String glucoseUnit) {
        this.glucoseType = glucoseType;
        this.glucoseValue = glucoseValue;
        this.lastMealTime = lastMealTime;
        this.glucoseDateTime = glucoseDateTime;
        this.glucoseUnit = glucoseUnit;
    }

    private Integer hb1ac;
    private String hb1acUnit;
    private String glucoseType;
    private Float glucoseValue;
    private Date lastMealTime;
    private Date glucoseDateTime;
    private String glucoseUnit;
    private String type;
    private Boolean isBeforeDiabetesDiagnosis;


    private Long glucoseId;

}