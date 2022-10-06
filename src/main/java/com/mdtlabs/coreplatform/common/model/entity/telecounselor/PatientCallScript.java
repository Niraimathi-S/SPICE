package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.Answered;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.InterestLevel;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.OtherEnrolledPlan;
import com.mdtlabs.coreplatform.common.telecounselor.TelecounselorConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for patient call script table.
 * </p>
 * 
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
@Entity
@Table(name = TelecounselorConstants.TABLE_PATIENT_CALL_SCRIPT)
public class PatientCallScript extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = TelecounselorConstants.PATIENT_CHASELIST_ID)
	private PatientChaselist patientChaseList;

	@ManyToOne
	@JoinColumn(name = TelecounselorConstants.PATIENT_CALL_REGISTER_ID)
	private PatientCallRegister patientCallRegister;

	@Column(name = TelecounselorConstants.RESPOND_BY)
	private Answered respondBy;

	@Column(name = TelecounselorConstants.IS_ACCEPTED)
	private String isAccepted;

	@Column(name = TelecounselorConstants.PLANNED_CLINIC)
	private String plannedClinic;

	@Column(name = TelecounselorConstants.IS_VISIT_CLINIC)
	private String isVisitClinic;

	@Column(name = TelecounselorConstants.NO_VISIT_REASON)
	private String noVisitReason;

	@Column(name = TelecounselorConstants.OTHER_CLINIC)
	private String otherClinic;

	@Column(name = TelecounselorConstants.PLANNED_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date plannedDate;

	@Column(name = TelecounselorConstants.FOLLOWUP_INTEREST)
	private String followupInterest;

	@Column(name = TelecounselorConstants.AVAILABLE_DATE, columnDefinition = "TIMESTAMP")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date availableDate;

	@Column(name = TelecounselorConstants.CALL_SUMMARY)
	private String callSummary;

	@Column(name = TelecounselorConstants.INTEREST_LEVEL)
	private InterestLevel interestLevel;

	@Column(name = TelecounselorConstants.WHAT_HAPPENED)
	private String whatHappened;

	@Column(name = TelecounselorConstants.IS_TAKEN_MEDICATION)
	private String isTakenMedication;

	@Column(name = TelecounselorConstants.EATEN_SUMMARY)
	private String eatenSummary;

	@Column(name = TelecounselorConstants.IS_EATEN_MONITORING)
	private String isEatenMonitoring;

	@Column(name = TelecounselorConstants.IS_OTHER_HEALTH_ISSUES)
	private String isOtherHealthIssues;

	@Column(name = TelecounselorConstants.OTHER_ENROLLED_PLAN)
	private OtherEnrolledPlan otherEnrolledPlan;

	@Column(name = TelecounselorConstants.IS_FEELING_GOOD)
	private String isFeelingGood;

	@Column(name = TelecounselorConstants.OTHER_HEALTH_ISSUES)
	private String otherHealthIssues;

	@Column(name = Constants.TENANT_ID)
	private String tenantId;

}
