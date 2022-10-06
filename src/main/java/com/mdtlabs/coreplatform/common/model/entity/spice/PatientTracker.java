package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Type;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

import org.hibernate.annotations.Type;


import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_TRACKER)
@TypeDef(
	name = "list-array",
	typeClass = ListArrayType.class
)
public class PatientTracker extends BaseEntity {

    @Column(name = FieldConstants.NATIONAL_ID)
    private String nationalId;

    @Column(name = FieldConstants.FIRST_NAME)
    private String firstName;

    @Column(name = FieldConstants.LAST_NAME)
    private String lastName;

    @Column(name = FieldConstants.DATE_OF_BIRTH)
    private Date dateOfBirth;

    @Column(name = FieldConstants.AGE)
    private Integer age;

    @Column(name = FieldConstants.GENDER)
    private String gender;

    @Column(name = FieldConstants.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = FieldConstants.HEIGHT)
    private Float height;

    @Column(name = FieldConstants.WEIGHT)
    private Float weight;

    @Column(name = FieldConstants.BMI)
    private Float bmi;

    @Column(name = FieldConstants.IS_REGULAR_SMOKER)
    private boolean isRegularSmoker;

    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.SITE_ID)
    private Long siteId;

    @Column(name = FieldConstants.PROGRAM_ID)
    private Long programId;

    @Column(name = FieldConstants.AVG_SYSTOLIC)
    private Integer avgSystolic;

    @Column(name = FieldConstants.AVG_DIASTOLIC)
    private Integer avgDiastolic;

    @Column(name = FieldConstants.AVG_PULSE)
    private Integer avgPulse;

    @Column(name = FieldConstants.GLUCOSE_UNIT)
    private String glucoseUnit;

    @Column(name = FieldConstants.GLUCOSE_TYPE)
    private String glucoseType;

    @Column(name = FieldConstants.GLUCOSE_VALUE)
    private Float glucoseValue;

    @Column(name = FieldConstants.CVD_RISK_LEVEL)
    private String cvdRiskLevel;

    @Column(name = FieldConstants.CVD_RISK_SCORE)
    private Integer cvdRiskScore;

    @Column(name = FieldConstants.SCREENING_ID)
    private Long screeningLogId;

    @Column(name = FieldConstants.NEXT_MEDICAL_REVIEW_DATE)
    private Date nextMedicalReviewDate;

    @Column(name = FieldConstants.NEXT_BP_ASSESSMENT_DATE)
    private Date nextBpAssessmentDate;

    @Column(name = FieldConstants.NEXT_BG_ASSESSMENT_DATE)
    private Date nextBgAssessmentDate;

    @Column(name = FieldConstants.PATIENT_ID)
    private Long patientId;

    @Column(name = FieldConstants.PATIENT_STATUS)
    private String patientStatus;

    @Column(name = FieldConstants.IS_OBSERVATION)
    private Boolean isObservation;

    @Column(name = FieldConstants.IS_SCREENING)
    private Boolean isScreening;

    @Column(name = FieldConstants.SCREENING_REFERRAL)
    private Boolean screeningReferral;

    @Column(name = FieldConstants.ENROLLMENT_AT)
    private Date enrollmentAt;

    @Column(name = FieldConstants.LAST_REVIEW_DATE)
    private Date lastReviewDate;

	@Column(name = FieldConstants.LAST_ASSESSMENT_DATE)
	private Date lastAssessmentDate;

    @Column(name = FieldConstants.IS_CONFIRM_DIAGNOSIS)
    private Boolean isConfirmDiagnosis;

	@Column(name = FieldConstants.DIAGNOSIS_COMMENTS)
	private String diagnosisComments;

	@Column(name = FieldConstants.CONFIRM_DIAGNOSIS, columnDefinition = "varchar[]")
	@Type(type = "list-array")
	private List<String> confirmDiagnosis;

	@Column(name = FieldConstants.PROVISIONAL_DIAGNOSIS, columnDefinition = "varchar[]")
	@Type(type = "list-array")
	private List<String> provisionalDiagnosis;

	@Column(name = FieldConstants.PHQ4_SCORE)
	private Integer phq4Score;

	@Column(name = FieldConstants.IS_INITIAL_REVIEW)
	private boolean isInitialReview;

    @Column(name = FieldConstants.PHQ4_RISK_LEVEL)
    private String phq4RiskLevel;

    @Column(name = FieldConstants.PHQ4_FIRST_SCORE)
    private Integer phq4FirstScore;

    @Column(name = FieldConstants.PHQ4_SECOND_SCORE)
    private Integer phq4SecondScore;

    @Column(name = FieldConstants.PHQ9_SCORE)
    private Integer phq9Score;

    @Column(name = FieldConstants.PHQ9_RISK_LEVEL)
    private String phq9RiskLevel;

    @Column(name = FieldConstants.GAD7_SCORE)
    private Integer gad7Score;

    @Column(name = FieldConstants.GAD7_RISK_LEVEL)
    private String gad7RiskLevel;

    @Column(name = FieldConstants.RISK_LEVEL)
    private String riskLevel;

    @Column(name = FieldConstants.LAST_MENSTRUAL_PERIOD_DATE)
    private Date lastMenstrualPeriodDate;

    @Column(name = FieldConstants.IS_PREGNANT)
    private Boolean isPregnant;

    @Column(name = FieldConstants.ESTIMATED_DELIVERY_DATE)
    private Date estimatedDeliveryDate;

	@Column(name = FieldConstants.IS_RED_RISK_PATIENT)
	private boolean isRedRiskPatient;

	@Column(name = FieldConstants.IS_LABTEST_REFERRED)
	private boolean isLabtestReferred;

    @Column(name = FieldConstants.IS_MEDICATION_PRESCRIBED)
    private boolean isMedicationPrescribed;
	
}
