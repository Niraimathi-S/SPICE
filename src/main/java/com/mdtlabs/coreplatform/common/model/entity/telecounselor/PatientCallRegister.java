package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.LastCallStatus;
import com.mdtlabs.coreplatform.common.model.enumeration.telecounselor.PatientCategory;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is an entity class for patient call register table.
 * </p>
 *
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.PATIENT_CALL_REGISTER)
public class PatientCallRegister extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = PatientProfileConstants.PATIENT_CHASELIST_ID)
	private PatientChaselist patientChaseList;

	@Column(name = PatientProfileConstants.DAY)
	private String day;

	@Column(name = PatientProfileConstants.START_TIME)
	private Date startTime;

	@Column(name = PatientProfileConstants.END_TIME)
	private Date endTime;

	@Column(name = PatientProfileConstants.CALL_DURATION)
	private String callDuration;

	@Enumerated(EnumType.STRING)
	@Column(name = PatientProfileConstants.CALL_STATUS)
	private LastCallStatus callStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = PatientProfileConstants.CALL_REASON)
	private PatientCategory callReason;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = PatientProfileConstants.PATIENT_CALL_REGISTER_ID)
	private List<PatientCallScriptQuestion> patientCallScriptQuestions;
}
