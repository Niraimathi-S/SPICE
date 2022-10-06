package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.telecounselor.PatientProfileConstants;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * This class is an entity class for question category table.
 * </p>
 *
 * @author AkashGopinath created on Sep 23, 2022
 */
@Data
@Entity
@Table(name = PatientProfileConstants.QUESTION_CATEGORY)
public class QuestionCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = PatientProfileConstants.CATEGORY_NAME)
	private String categoryName;

	@Column(name = PatientProfileConstants.QUESTION_GROUP)
	private String questionGroup;

	@Column(name = PatientProfileConstants.DISPLAY_ORDER)
	private int displayOrder;

	@Column(name = PatientProfileConstants.QUESTION_ID)
	private long questionId;

}
