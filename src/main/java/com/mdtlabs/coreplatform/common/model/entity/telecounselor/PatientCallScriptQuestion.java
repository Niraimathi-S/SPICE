package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * <p>
 * This class is an entity class for patient call script question table.
 * </p>
 *
 * @author AkashGopinath created on Sep 23, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.PATIENT_CALL_SCRIPT_QUESTION)
public class PatientCallScriptQuestion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = PatientProfileConstants.QUESTION_ID)
	private CallScriptQuestionData callScriptQuestionData;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = PatientProfileConstants.PATIENT_CALL_SCRIPT_QUESTION_ID)
	private List<PatientCallScriptAnswer> patientCallScriptAnswers;

}
