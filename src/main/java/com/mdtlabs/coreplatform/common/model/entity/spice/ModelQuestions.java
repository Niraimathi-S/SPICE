package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.MODEL_QUESTIONS)
public class ModelQuestions extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name =  FieldConstants.COUNTRY_ID)
    private Long countryId;

    @Column(name = FieldConstants.QUESTIONS)
    private String questions;

    @Column(name =  FieldConstants.DISPLAY_ORDER)
    private int displayOrder;

    @Column(name = FieldConstants.IS_DEFAULT)
    private boolean isDefault;

    @Column(name =  FieldConstants.TYPE)
    private String type;

    @Column(name = FieldConstants.IS_MANDATORY)
    private String isMandatory;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = FieldConstants.QUESTION_ID)
    private List<ModelAnswers> modelAnswers;
}
