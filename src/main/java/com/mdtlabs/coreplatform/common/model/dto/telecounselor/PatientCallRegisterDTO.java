package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.entity.telecounselor.PatientCallScriptQuestion;
import com.mdtlabs.coreplatform.common.model.entity.telecounselor.PatientChaselist;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.LastCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * This is a DTO class for patient call register entity.
 *
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class PatientCallRegisterDTO {

	private long id;

	private PatientChaselist patientChaseList;

	private String day;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date startTime;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date endTime;

	private String callDuration;

	private LastCallStatus callStatus;

	private PatientCategory callReason;

	private List<PatientCallScriptQuestion> patientCallScriptQuestions;

	private String assignedBy;

	private String tenantId;

	private long createdBy;

	private long updatedBy;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updatedAt;

	private boolean isActive;

	private boolean isDeleted;

}
