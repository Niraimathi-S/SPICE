package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

/**
 * Entity class for patient diagnosis
 * 
 * @author Karthick Murugesan
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_DIAGNOSIS)
public class PatientDiagnosis extends TenantBaseEntity {

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;

    @Column(name = FieldConstants.HTN_YEAR_OF_DIAGNOSIS)
    private int htnYearOfDiagnosis;

    @Column(name = FieldConstants.DIABETES_YEAR_OF_DIAGNOSIS)
    private int diabetesYearOfDiagnosis;

    @Column(name = FieldConstants.HTN_PATIENT_TYPE)
    private String htnPatientType;

    @Column(name = FieldConstants.DIABETES_PATIENT_TYPE)
    private String diabetesPatientType;

    @Column(name = FieldConstants.DIABETES_DIAGNOSIS)
    private String diabetesDiagnosis;

    @Column(name = FieldConstants.DIABETES_DIAG_CONTROLLED_TYPE)
    private String diabetesDiagControlledType;

    @Column(name = FieldConstants.IS_HTN_DIAGNOSIS)
    private boolean isHtnDiagnosis;

    @Column(name = FieldConstants.IS_DIABETES_DIAGNOSIS)
    private boolean isDiabetesDiagnosis;

    public PatientDiagnosis() {
    }

    public PatientDiagnosis(Long tenantId, Long patientTrackId, Long patientVisitId, Integer htnYearOfDiagnosis,
            Integer diabetesYearOfDiagnosis, String htnPatientType, String diabetesPatientType,
            String diabetesDiagnosis, String diabetesDiagControlledType, Boolean isHtnDiagnosis,
            Boolean isDiabetesDiagnosis) {
        this.tenantId = tenantId;
        this.patientTrackId = patientTrackId;
        this.patientVisitId = patientVisitId;
        this.htnYearOfDiagnosis = htnYearOfDiagnosis;
        this.diabetesYearOfDiagnosis = diabetesYearOfDiagnosis;
        this.htnPatientType = htnPatientType;
        this.diabetesPatientType = diabetesPatientType;
        this.diabetesDiagnosis = diabetesDiagnosis;
        this.diabetesDiagControlledType = diabetesDiagControlledType;
        this.isHtnDiagnosis = isHtnDiagnosis;
        this.isDiabetesDiagnosis = isDiabetesDiagnosis;
    }
}
