package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;
import com.mdtlabs.coreplatform.common.telecounselor.TelecounselorConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for patient assigned list table.
 * </p>
 * 
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
@Entity
@Table(name = TelecounselorConstants.TABLE_PATIENT_ASSIGNED_LIST)
public class PatientAssignedList extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = TelecounselorConstants.PATIENT_CHASELIST_ID)
	private PatientChaselist patientChaseList;

	@Column(name = TelecounselorConstants.TELECOUNSELOR_NAME)
	private String telecounselorName;

	@Column(name = TelecounselorConstants.TELECOUNSELOR_ID)
	private String telecounselorId;

	@Column(name = TelecounselorConstants.CALL_REASON)
	private PatientCategory callReason;

	@Column(name = TelecounselorConstants.ASSIGNED_BY)
	private String assignedBy;

	@Column(name = Constants.TENANT_ID)
	private String tenantId;

}
