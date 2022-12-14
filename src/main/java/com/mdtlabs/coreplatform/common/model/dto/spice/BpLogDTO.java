package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.model.entity.spice.BpLogDetails;
import com.mdtlabs.coreplatform.common.util.EnrollmentInfo;
import com.mdtlabs.coreplatform.common.util.ScreeningInfo;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BpLogDTO {

    private Long tenantId; 

    @NotNull(message = ErrorConstants.AVG_SYSTOLIC_NOT_NULL, groups = {Default.class, ScreeningInfo.class, EnrollmentInfo.class})
    private Integer avgSystolic;

    @NotNull(message = ErrorConstants.AVG_DIASTOLIC_NOT_NULL, groups = {Default.class, ScreeningInfo.class, EnrollmentInfo.class})
    private Integer avgDiastolic;

    private Integer avgPulse;

    private Float height;

    private Float weight;

    private Float bmi;

    private Integer temperature;

    private String cvdRiskLevel;

    private Integer cvdRiskScore;

    private Boolean isRegularSmoker;

    private String type;

    private Long patientTrackId;

    private Long screeningId;

    @NotNull(message = ErrorConstants.BPLOG_DETAILS_NOT_EMPTY, groups = {EnrollmentInfo.class, ScreeningInfo.class})
    @Size(min = 2, message = ErrorConstants.BPLOG_EDTAILS_MIN_SIZE, groups = {EnrollmentInfo.class, ScreeningInfo.class})
    private List<BpLogDetails> bpLogDetails;

    private String riskLevel;

    private String bpArm;

    private String bpPosition;

    private String covidVaccStatus;

    private String assessmentCategory;

    private String assessmentLandmark;

    private String notes;

    private String insuranceStatus;

    private String insuranceType;

    private String insuranceId;

    private String otherInsurance;
    
    public BpLogDTO(
            Integer avgSystolic,
             Integer avgDiastolic,
             Float bmi, String cvdRiskLevel, Integer cvdRiskScore) {
         this.avgSystolic = avgSystolic;
         this.avgDiastolic = avgDiastolic;
         this.bmi = bmi;
         this.cvdRiskLevel = cvdRiskLevel;
         this.cvdRiskScore = cvdRiskScore;
     }

     public BpLogDTO() {
     }

     public BpLogDTO(
              Integer avgSystolic,
             Integer avgDiastolic,
             Float bmi) {
         this.avgSystolic = avgSystolic;
         this.avgDiastolic = avgDiastolic;
         this.bmi = bmi;
     }


}