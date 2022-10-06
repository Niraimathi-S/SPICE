package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_VISIT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientVisit extends BaseEntity{

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
    private Long patientTrackId;
    
    @Column(name = FieldConstants.TENANT_ID)
    private Long tenantId;

    @Column(name = FieldConstants.VISIT_DATE,  columnDefinition = "TIMESTAMP")
    private Date visitDate;

	@Column(name = FieldConstants.IS_PRESCRIPTION)
	private boolean isPrescription;

	@Column(name = FieldConstants.IS_INVESTIGATION)
	private boolean isInvestigation;

	@Column(name = FieldConstants.IS_MEDICAL_REVIEW)
	private boolean isMedicalReview;

}
