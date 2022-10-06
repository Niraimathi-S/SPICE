package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.CurrentCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.LastCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;
import com.mdtlabs.coreplatform.common.telecounselor.TelecounselorConstants;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.Date;

/**
 * <p>
 * This class is an entity class for patient chaselist table.
 * </p>
 * 
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
@Entity
@Table(name = TelecounselorConstants.TABLE_PATIENT_CHASELIST)
public class PatientChaselist extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = TelecounselorConstants.PATIENT_ID)
	private String patientId;

	@Column(name = TelecounselorConstants.PATIENT_TRACKER_ID)
	private String patientTrackerId;

	@Column(name = TelecounselorConstants.NATIONAL_ID)
	private String nationalId;

	@Column(name = Constants.FIRST_NAME)
	private String firstName;

	@Column(name = Constants.LAST_NAME)
	private String lastName;

	@Column(name = TelecounselorConstants.DOB)
	private String dob;

	@Column(name = TelecounselorConstants.AGE)
	private int age;

	@Column(name = Constants.GENDER)
	private String gender;

	@Column(name = Constants.COUNTRY_CODE)
	private String countryCode;

	@Column(name = Constants.PHONE_NUMBER)
	private String phoneNumber;

	@Column(name = TelecounselorConstants.PHONE_NUMBER_CATEGORY)
	private String phoneNumberCategory;

	@Column(name = Constants.REGION)
	private String region;

	@Column(name = Constants.ACCOUNT)
	private String account;

	@Column(name = TelecounselorConstants.OPERATING_UNIT)
	private String operatingUnit;

	@Column(name = TelecounselorConstants.SITE)
	private String site;

	@Column(name = TelecounselorConstants.PROGRAM)
	private String program;

	@Column(name = TelecounselorConstants.REGION_ID)
	private String regionId;

	@Column(name = Constants.ACCOUNT_ID)
	private String accountId;

	@Column(name = Constants.OPERATING_UNIT_ID)
	private String operatingUnitId;

	@Column(name = Constants.SITE_ID)
	private String siteId;

	@Column(name = TelecounselorConstants.PROGRAM_ID)
	private String programId;

	@Enumerated(EnumType.STRING)
	@Column(name = TelecounselorConstants.PATIENT_CATEGORY, columnDefinition = TelecounselorConstants.PATIENT_CATEGORY)
	private PatientCategory patientCategory;

	@Enumerated(EnumType.STRING)
	@Column(name = TelecounselorConstants.LAST_CALL_STATUS, columnDefinition = TelecounselorConstants.CALL_STATUS)
	private LastCallStatus lastCallStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = TelecounselorConstants.CURRENT_CALL_STATUS, columnDefinition = TelecounselorConstants.CURRENT_CALL_STATUS)
	private CurrentCallStatus currentCallStatus;

	@Column(name = TelecounselorConstants.REMAINING_ATTEMPTS)
	private Integer remainingAttempts;

	@Column(name = TelecounselorConstants.ASSIGNED_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date assignedDate;

	@Column(name = TelecounselorConstants.ASSIGNED_BY)
	private String assignedBy;

	@Column(name = TelecounselorConstants.TELECOUNSELOR_NAME)
	private String telecounselorName;

	@Column(name = TelecounselorConstants.TELECOUNSELOR_ID)
	private String telecounselorId;

	@Column(name = TelecounselorConstants.SCREENED_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date screenedDate;

	@Column(name = TelecounselorConstants.ENROLLED_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date enrolledDate;

	@Column(name = Constants.TENANT_ID)
	private String tenantId;

	@Column(name = TelecounselorConstants.CVD_RISK_SCORE)
	private Integer cvdRiskScore;

	@Column(name = TelecounselorConstants.CVD_RISK)
	private String cvdRisk;

	@Column(name = TelecounselorConstants.IS_HTN)
	private boolean isHTN;

	@Column(name = TelecounselorConstants.IS_DM)
	private boolean isDM;

	@Column(name = TelecounselorConstants.REDRISK_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date redriskDate;

	@Column(name = TelecounselorConstants.RED_ALERT_REASON)
	private String redAlertReason;

	@Column(name = TelecounselorConstants.NUMBER_OF_RED_ALERTS)
	private Integer numberOfRedAlerts;

	@Column(name = TelecounselorConstants.REFERRED_REASON)
	private String referredReason;

	@Column(name = TelecounselorConstants.SCREENING_REFERAL_STATUS)
	private String screeningReferralStatus;

	@Column(name = TelecounselorConstants.NEXT_MEDICAL_REVIEW_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date nextMedicalReviewDate;

	@Column(name = TelecounselorConstants.NEXT_ASSESSMENT_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date nextAssessmentDate;

	@Column(name = TelecounselorConstants.LAST_MEDICAL_REVIEW_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date lastMedicalReviewDate;

	@Column(name = TelecounselorConstants.LAST_ASSESSMENT_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date lastAssessmentDate;

	@Column(name = TelecounselorConstants.SOURCE_CREATED_AT, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date sourceCreatedAt;

	@Column(name = TelecounselorConstants.SOURCE_CREATED_BY, columnDefinition = "TIMESTAMP")
	private String sourceCreatedBy;

	@Column(name = TelecounselorConstants.SOURCE_UPDATED_AT, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date sourceUpdatedAt;

	@Column(name = TelecounselorConstants.SOURCE_UPDATED_BY, columnDefinition = "TIMESTAMP")
	private String sourceUpdatedBy;
}
