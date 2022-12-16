package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;
import org.hibernate.annotations.Type;

import com.mdtlabs.coreplatform.common.model.entity.spice.BpLogDetails;

import java.util.Date;
import java.util.List;

@Data
public class PatientTrackerDTO {
	private String nationalId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int age;
	private String gender;
	private String phoneNumber;
	private String phoneNumberCategory;
	private Float height;
	private Float weight;
	private Float bmi;
	private boolean isRegularSmoker;
	private Long tenantId;
	private Long programId;
	private int avgSystolic;
	private int avgDiastolic;
	private String glucoseUnit;
	private String glucoseType;
	private int glucoseValue;
	private String cvdRiskLevel;
	private int cvdRiskScore;
	private Long screeningLogId;
	private boolean isObservation;
	private boolean isScreening;
	private Date enrollmentAt;
	private Date lastAssessmentDate;
	private Boolean isConfirmDiagnosis;
	private String diagnosisComments;
	@Type(type = "com.mdtlabs.spice.common.util.CustomStringArrayType")
	private String[] confirmDiagnosis;
	@Type(type = "com.mdtlabs.spice.common.util.CustomStringArrayType")
	private String[] provisionalDiagnosis;
	private int phq4Score;
	private boolean isInitialReview;
	private String phq4RiskLevel;
	private int phq4FirstScore;
	private int phq4SecondScore;
	private int phq9Score;
	private String phq9RiskLevel;
	private String riskLevel;
	private Date lastMenstrualPeriodDate;
	private boolean isPregnant;
	private Date estimatedDeliveryDate;
	private boolean isRedRiskPatient;
	private boolean isPhq9;
	private boolean isGad7;
	private List<BpLogDetails> bpLogDetails;
	private GlucoseLogDTO glucoseLogDetails;
	private PrescriberDTO prescriberDTO;
	private PatientLifestyleDTO patientLifestyleDTO;

	// private Date nextMedicalReviewDate;
//    private Date nextBpAssessmentDate;
//    private Date nextBgAssessmentDate;
//    private Long patientId;
//    private String patientStatus;
	// private Long provisionalDiagnosis;
	// private Date lastReviewDate;
	// private Long confirmDiagnosis;
//    private boolean screeningReferral;
//    private int avgPulse;
//    private Long countryId;
//    private Long site;
//    private int gad7Score;
//    private String gad7RiskLevel;

}
