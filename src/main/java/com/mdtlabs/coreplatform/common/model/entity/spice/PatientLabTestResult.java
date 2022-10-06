package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

@Data
@Table(name = TableConstants.TABLE_PATIENT_LAB_TEST_RESULT)
@Entity
public class PatientLabTestResult extends BaseEntity {

    @NotBlank
    @Column(name = FieldConstants.RESULT_NAME)
    private String resultName;

    @Column(name = FieldConstants.DISPLAY_NAME)
    private String displayName;

    @NotBlank
    @Column(name = FieldConstants.RESULT_VALUE)
    private String resultValue;

    @NotBlank
    @Column(name = FieldConstants.UNIT)
    private String unit;

    @Column(name = FieldConstants.RESULT_STATUS)
    private String resultStatus;

    @Column(name = FieldConstants.IS_ABNORMAL)
    private Boolean isAbnormal;

    @Column(name = FieldConstants.LAB_TEST_RESULT_ID)
    private Long labTestResultId;

    @Column(name = FieldConstants.PATIENT_LAB_TEST_ID)
    private Long patientLabTestId;

    @Column(name = FieldConstants.LAB_TEST_ID)
    private Long labTestId;

    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;

    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;

    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.DISPLAY_ORDER)
    private Integer displayOrder;

}
