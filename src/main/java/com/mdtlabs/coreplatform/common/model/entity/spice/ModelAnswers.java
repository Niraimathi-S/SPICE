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

/**
 * This class is an entity used to represent answers for questions form the application.
 * 
 * @author Niraimathi S
 *
 */
@Data
@Entity
@Table(name = TableConstants.MODEL_ANSWERS)
public class ModelAnswers extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.ANSWER)
    private String answer;

    @Column(name = FieldConstants.DISPLAY_ORDER)
    private int displayOrder;

    @Column(name = FieldConstants.IS_DEFAULT)
    private boolean isDefault;
    
    @Column(name = FieldConstants.VALUE)
    private int value;
    
}