package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.BpLogDetails;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealthDetails;

import lombok.Data;

@Data
public class ScreeningResponseDTO {

    private Long tenantId;

    private String latitude;

    private String longitude;

    private String firstName;

    private String middleName;

    private String lastName;

    private String nationalId;

    private String phoneNumber;

    private String phoneNumberCategory;

    private String landmark; 

    private String gender;

    private Date dateOfBirth;

    private Integer age;

    private Float height;

    private Float weight;

    private Float bmi;

    private Boolean isRegularSmoker;

    private Long countryId;

    private Long countyId;

    private Long subCountyId;

    private String category;

    private Integer avgSystolic;

    private Integer avgDiastolic;

    private Integer avgPulse;

    private String glucoseType;

    private Integer glucoseValue;

    private String glucoseUnit;

    private Date lastMealTime;

    private Date glucoseDateTime;

    private Boolean isBeforeDiabeticDiagnosis;

    private Integer phq4score;

    private String phq4RiskLevel;

    private String cvdRiskLevel;

    private Integer cvdRiskScore;

    private Boolean isReferAssessment;

    private Boolean isLatest;

    private Boolean isBeforeHtnDiagnosis;

    private Long site;

    private Long operatingUnitId;

    private Long accountId;

    private String bpArm;

    private String bpPosition;

    private Boolean physicallyActive;

    private String type;

    private Long deviceInfoId;

    private List<MentalHealthDetails> phq4MentalHealth;

    private boolean isBeforeGestationalDiabetes;

    private String idType;

    private boolean isFamilyDiabetesHistory;

    private String insuranceStatus;

    private boolean isUpdatedFromEnrollment;

    private String covidVaccStatus;   
    
    private String cvdRiskScoreDisplay;

    private String preferredName;

    private List<BpLogDetails> bpLogDetails;

    private GlucoseLogDTO glucoseLog;

}
