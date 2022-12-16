package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_LAB_TEST)
public class PatientLabTest extends TenantBaseEntity {

    private static final long serialVersionUID = 1L;

	@NotNull
    @Column(name = FieldConstants.LAB_TEST_ID)
    private Long labTestId;
    
    @Column(name = FieldConstants.LABTEST_NAME)
    private String labTestName;
    
    @Column(name = FieldConstants.RESULT_DATE)
    private Date resultDate;
    
    @Column(name = FieldConstants.REFERRED_BY)
    private Long referredBy;
    
    //@NotNull
    @Column(name = FieldConstants.IS_REVIEWED)
    private Boolean isReviewed;

    @Column(name = FieldConstants.IS_OTHER_LABTEST)
    private boolean isOtherLabtest;

    @Column(name = FieldConstants.IS_ABNORMAL)
    private boolean isAbnormal;
    
    @NotNull
    @Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;
    
    @Column(name = FieldConstants.PATIENT_VISIT_ID)
    private Long patientVisitId;
    
    @Column(name = FieldConstants.RESULT_UPDATE_BY)
    private Long resultUpdateBy;

    @Column(name = FieldConstants.COMMENTS)
    private String comments;
}
