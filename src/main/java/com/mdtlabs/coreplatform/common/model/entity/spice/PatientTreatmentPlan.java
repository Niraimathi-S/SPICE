package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

/**
 * this class is used to get PatientTreatmentPlan Entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_TREATMENT_PLAN)
public class PatientTreatmentPlan extends TenantBaseEntity {
    
    private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.MEDICAL_REVIEW_FREQUENCY)
    private String medicalReviewFrequency;

    @Column(name = FieldConstants.BP_CHECK_FREQUENCY)
    private String bpCheckFrequency;

    @Column(name = FieldConstants.BG_CHECK_FREQUENCY)
    private String bgCheckFrequency;

    @Column(name = FieldConstants.HBA1C_CHECK_FREQUENCY)
    private String hba1cCheckFrequency;

    @NotNull(message = ErrorConstants.IS_PROVISIONAL_NOT_NULL)
    @Column(name = FieldConstants.IS_PROVISIONAL)
    private Boolean isProvisional;

    @Column(name = FieldConstants.RISK_LEVEL)
    private String riskLevel;

//    @NotNull(message = ErrorConstants.PATIENT_VISIT_ID_NOT_NULL)
    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;

    @NotNull(message = ErrorConstants.PATIENT_TRACK_ID_NOT_NULL)
    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.IS_LATEST)
    private boolean isLatest;
}