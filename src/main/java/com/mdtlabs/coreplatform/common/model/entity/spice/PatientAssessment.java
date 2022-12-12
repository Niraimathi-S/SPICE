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
@Table(name = TableConstants.TABLE_ASSESSMENT_LOG)
public class PatientAssessment extends BaseEntity {
    
    @Column(name = FieldConstants.BP_LOG_ID)
    private Long bpLogId;

    @Column(name = FieldConstants.GLUCOSE_LOG_ID)
    private Long glucoseLogId;

    public PatientAssessment(Long bpLogId, Long glucoseLogId) {
        this.bpLogId = bpLogId;
        this.glucoseLogId = glucoseLogId;
    }

    public PatientAssessment() {}


}
