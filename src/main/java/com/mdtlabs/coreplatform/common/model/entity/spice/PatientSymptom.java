package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_PATIENT_SYMPTOM)
public class PatientSymptom extends TenantBaseEntity {

	private static final long serialVersionUID = 1L;

	// @NotNull
	@Column(name = FieldConstants.NAME)
	private String name;

//    @NotNull
	@Column(name = FieldConstants.TYPE)
	private String type;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
	private Long patientTrackerId;

	@Column(name = FieldConstants.SYMPTOM_ID)
	private Long symptomId;

	@Column(name = FieldConstants.OTHER_SYMPTOM)
	private String otherSymptom;

	@Column(name = FieldConstants.BP_LOG_ID)
	private Long bpLogId;

	@Column(name = FieldConstants.GLUCOSE_LOG_ID)
	private Long glucoseLogId;

	@Column(name = FieldConstants.ASSESSMENT_LOG_ID)
	private Long assessmentLogId;

}
