package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

/**
 * Entity class for patient lifstyle
 * 
 * @author Karthick Murugesan
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_LIFESTYLE)
public class PatientLifestyle extends BaseEntity {

    public PatientLifestyle() {}
    
    public PatientLifestyle(Long tenantId, Long patientTrackId, Long patinetVisitId, Long lifestyleId,
            String answer, String comments) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patinetVisitId = patinetVisitId;
        this.lifestyleId = lifestyleId;
        this.answer = answer;
        this.comments = comments;
    }

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patinetVisitId;

    @Column(name = FieldConstants.LIFESTYLE_ID)
    private Long lifestyleId;

    @Column(name = FieldConstants.ANSWER)
    private String answer;

    @Column(name = FieldConstants.COMMENTS)
    private String comments;

}
