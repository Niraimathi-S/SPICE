package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.*;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_MEDICAL_COMPLIANCE)
public class PatientMedicalCompliance extends BaseEntity {

    @Column(name = FieldConstants.NAME)
    private String name;

    @Column(name = FieldConstants.OTHER_COMPLIANCE)
    private String otherCompliance;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.COMPLIANCE_ID)
    private Long complianceId;

    @Column(name = FieldConstants.BP_LOG_ID)
    private Long bpLogId;

    @Column(name = FieldConstants.ASSESSMENT_LOG_ID)
    private Long assessmentLogId;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

}
