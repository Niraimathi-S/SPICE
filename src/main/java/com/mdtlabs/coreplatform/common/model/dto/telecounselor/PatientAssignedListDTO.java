package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.model.entity.telecounselor.PatientChaselist;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;

import lombok.Data;

import java.util.Date;

/**
 * This is a DTO class for patient assigned list entity.
 * 
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class PatientAssignedListDTO {
	
	private long id;

	private PatientChaselist patientChaseList;

	private String telecounselorName;

	private String telecounselorId;

	private PatientCategory callReason;

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
