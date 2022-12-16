package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Table(name = TableConstants.TABLE_RED_RISK_NOTIFICATION)
@Entity
public class RedRiskNotification extends TenantBaseEntity {

    @Column(name = FieldConstants.BP_LOG_ID)
    private Long BpLogId;

    @Column(name = FieldConstants.GLUCOSE_LOG_ID)
    private Long glucoseLogId;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.STATUS)
    private String status;

    @Column(name = FieldConstants.ASSESSMENT_LOG_ID)
    private Long assessmentLogId;

}
