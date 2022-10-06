package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>
 * This class is an entity class for patient call script answer table.
 * </p>
 *
 * @author AkashGopinath created on Sep 23, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.PATIENT_CALL_SCRIPT_ANSWER)
public class PatientCallScriptAnswer extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = PatientProfileConstants.ANSWER_ID)
	private CallScriptAnswerData callScriptAnswerData;

	@Column(name = PatientProfileConstants.DESCRIPTION)
	private String description;

	@Column(name = PatientProfileConstants.FACILITY_ID)
	private String site;

}
