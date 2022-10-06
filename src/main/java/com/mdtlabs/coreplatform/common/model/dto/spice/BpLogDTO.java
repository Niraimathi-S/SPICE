package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.BpLogDetails;

import lombok.Data;

@Data
public class BpLogDTO {

    private Long id;

    private Integer avgSystolic;

    private Integer avgDiastolic;

    private Integer avgPulse;

    private Boolean isRegularSmoker;

    private String bpArm;

    private String bpPosition;

    private String covidVaccStatus;

    private Boolean isBeforeHtnDiagnosis;

    private String assessmentCategory;

    private String notes;

    private Float height;

    private Float weight;

    private Float bmi;

    private Integer temperature;

    private List<BpLogDetails> bpLogDetails;


}