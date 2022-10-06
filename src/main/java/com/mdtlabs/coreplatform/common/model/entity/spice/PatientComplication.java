package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

/**
 * Entity class for patient complication table
 * 
 * @author Karthick Murugesan 
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_COMPLICATION)
public class PatientComplication extends BaseEntity{
    
    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patinetVisitId;

    
    @Column(name = FieldConstants.COMPLICATION_ID)
    private Long complicationId;

    @Column(name = FieldConstants.OTHER_COMPLICATION)
    private String otherComplication;
    
    
    public void setIds(Long tenantId, Long patientTrackId, Long patinetVisitId) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patinetVisitId = patinetVisitId;
    }
    
    public PatientComplication(Long tenantId, Long patientTrackId, Long patinetVisitId, Long complicationId,
            String otherComplication) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patinetVisitId = patinetVisitId;
        this.complicationId = complicationId;
        this.otherComplication = otherComplication;
    }
    
}
