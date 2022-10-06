package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for question answers table.
 * </p>
 *
 * @author TamilarasiShanmugasundaram created on Sep 26, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.QUESTION_ANSWERS)
public class QuestionAnswers extends BaseEntity {

	@Column(name = PatientProfileConstants.ANSWER_ID)
	private long answerId;

	@Column(name = PatientProfileConstants.QUESTION_ID)
	private long questionId;
}
