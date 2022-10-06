package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.CurrentCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.LastCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileDateSerializer;
import com.mdtlabs.coreplatform.common.telecounselor.TelecounselorConstants;
import com.mdtlabs.coreplatform.common.util.DateUtil;

import lombok.Data;

import java.util.Date;

/**
 * This is a DTO class for patient chaselist entity.
 *
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class PatientChaselistDTO {

	private long id;

	private String patientId;

	private String patientTrackerId;

	private String nationalId;

	private String firstName;

	private String lastName;

	private String dob;

	private String gender;

	private String countryCode;

	private String phoneNumber;

	private String phoneNumberCategory;

	private String region;

	private String account;

	private String operatingUnit;

	private String site;

	private String program;

	private String regionId;

	private String accountId;

	private String operatingUnitId;

	private String siteId;

	private String programId;

	private PatientCategory patientCategory;

	private LastCallStatus lastCallStatus;

	private CurrentCallStatus currentCallStatus;

	private Integer remainingAttempts;

	private Integer numberOfRedAlerts;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date assignedDate;

	private String assignedBy;

	private String telecounselorName;

	private String telecounselorId;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date screenedDate;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date enrolledDate;

	private String tenantId;

	private long createdBy;

	private long updatedBy;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updatedAt;

	private Integer cvdRiskScore;

	private String cvdRisk;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date redriskDate;

	private String redAlertReason;

	private String referredReason;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date lastMedicalReviewDate;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date nextMedicalReviewDate;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date lastAssessmentDate;

	@JsonSerialize(using = PatientProfileDateSerializer.class)
	private Date nextAssessmentDate;

	private boolean isActive;

	private boolean isDeleted;

	private boolean isHTN;

	private boolean isDM;

	private String sourceCreatedBy;

	private String sourceUpdatedBy;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date sourceCreatedAt;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date sourceUpdatedAt;

	private String screeningReferralStatus;

	private int age;

	private long daysSinceLastScreening;

	private long daysSinceLastRedAlert;

	private long daysSinceLastMissedMedicalReview;

	private long daysSinceLastMissedAssessment;

	private long daysSinceLastMedicalReview;

	private long daysSinceLastAssessment;

	private boolean isMedicalReviewDue = false;

	private boolean isAssessmentReviewDue = false;

	/*
	 * age should be calculated by adding age at the time of enrollment with years
	 * elapsed till current year.
	 *
	 * if age is 0 then it tries to determine the age by date of birth.
	 */
	public int getAge() {
		int ageCalculation = Constants.ZERO;

		if (age != Constants.ZERO) {
			ageCalculation = DateUtil.yearsSincePast(enrolledDate) + age;
		} else {
			ageCalculation = DateUtil.yearsSincePast(dob);
		}
		return ageCalculation;
	}

	public long getDaysSinceLastScreening() {
		return DateUtil.daysSincePast(screenedDate);
	}

	public long getDaysSinceLastRedAlert() {
		return DateUtil.daysSincePast(redriskDate);
	}

	public long getDaysSinceLastMissedMedicalReview() {
		return DateUtil.daysSincePast(nextMedicalReviewDate);
	}

	public long getDaysSinceLastMissedAssessment() {
		return DateUtil.daysSincePast(nextAssessmentDate);
	}

	public long getDaysSinceLastMedicalReview() {
		return DateUtil.daysSincePast(lastMedicalReviewDate);
	}

	public long getDaysSinceLastAssessment() {
		return DateUtil.daysSincePast(lastAssessmentDate);
	}

	public boolean isMedicalReviewDue() {
		return getDaysSinceLastMissedMedicalReview() > Constants.THREE;
	}

	public boolean isAssessmentReviewDue() {
		return getDaysSinceLastMissedAssessment() > TelecounselorConstants.THIRTY;
	}
}
