package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.entity.telecounselor.PatientCallRegister;
import com.mdtlabs.coreplatform.common.model.entity.telecounselor.PatientChaselist;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.Answered;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.InterestLevel;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.OtherEnrolledPlan;

import lombok.Data;

import java.util.Date;

/**
 * This is a DTO class for patient call script entity.
 * 
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class PatientCallScriptDTO {

	private long id;

	private PatientChaselist patientChaseList;

	private PatientCallRegister patientCallRegister;

	private Answered responsedBy;

	private boolean isAccepted;

	private String plannedClinic;

	private boolean isVisitClinic;

	private String noVisitReason;

	private String otherClinic;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date plannedDate;

	private String followupInterest;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date availableDate;

	private String callSummary;

	private InterestLevel interestLevel;

	private String whatHappened;

	private boolean isTakenMedication;

	private String eatenSummary;

	private boolean isEatenMonitoring;

	private boolean isOtherHealthIssues;

	private OtherEnrolledPlan otherEnrolledPlan;

	private boolean isFeelingGood;

	private String otherHealthIssues;

	private long createdBy;

	private long updatedBy;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updatedAt;

	private String tenantId;

	private boolean isActive;

	private boolean isDeleted;

}
