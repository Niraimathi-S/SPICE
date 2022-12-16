package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

/**
 * Entity class for patient comorbidity table
 * 
 * @author Karthick Murugesan
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_COMORBIDITY)
public class PatientComorbidity extends TenantBaseEntity {

    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;

    @Column(name = FieldConstants.COMORBIDITY_ID)
    private Long comorbidityId;

    @Column(name = FieldConstants.OTHER_COMORBIDITY)
    private String otherComorbidity;


    public PatientComorbidity() {
    }

    public PatientComorbidity(Long tenantId, Long patientTrackId, Long patinetVisitId, Long comorbidityId,
            String otherComorbidity) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patientVisitId = patinetVisitId;
        this.comorbidityId = comorbidityId;
        this.otherComorbidity = otherComorbidity;
    }

    public void setIds(Long tenantId, Long patientTrackId, Long patientVisitId) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patientVisitId = patientVisitId;
    }

}
