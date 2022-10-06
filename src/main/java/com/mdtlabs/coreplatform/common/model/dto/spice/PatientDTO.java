package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDTO {
    private Long id;
    private String nationalId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Date enrolledAt;
    private Boolean isPregnant;
    private String phoneNumber;
    private Boolean isRegularSmoker;
    private Long programId;
    //    private String[] provisionalDiagnosis;
    private Date lastAssesmentDate;
    private String cvdRiskLevel;
    private int cvdRiskScore;
    private int avgSystolic;
    private int avgDiastolic;
    private float bmi;
    private boolean isInitialReview;
    private boolean isConfirmDiagnosis;
    //    private String[] confirmDiagnosis;
    private float height;
    private float weight;
    private boolean isPhq9;
    private boolean isGad7;
    private boolean isRedRiskPatient;
    //    private String pregnancyDetails;
    private Long screeningId;
}
