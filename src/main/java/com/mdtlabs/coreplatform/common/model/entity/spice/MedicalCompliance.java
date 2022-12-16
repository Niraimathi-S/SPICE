package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_MEDICAL_COMPLIANCE)
public class MedicalCompliance extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.NAME)
    private String name;
    
    @Column(name = FieldConstants.STATUS)
    private boolean status;
    
    @Column(name = FieldConstants.DISPLAY_ORDER)
    private int displayOrder;
    
    @Column(name = FieldConstants.IS_CHILD_EXISTS)
    private boolean isChildExists;
    
    @Column(name = FieldConstants.PARENT_COMPLIANCE_ID)
    private Long parentComplianceId;
}
