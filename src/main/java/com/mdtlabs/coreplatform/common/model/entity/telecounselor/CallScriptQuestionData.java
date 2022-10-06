package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * This class is an entity class for questions table.
 * </p>
 *
 * @author AkashGopinath created on Sep 23, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.CALL_SCRIPT_QUESTION_DATA)
public class CallScriptQuestionData extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = PatientProfileConstants.QUESTION)
	private String question;

	@Column(name = PatientProfileConstants.DESCRIPTION)
	private String description;

}
