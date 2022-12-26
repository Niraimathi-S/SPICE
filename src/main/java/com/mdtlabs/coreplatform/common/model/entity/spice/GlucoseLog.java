package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_GLUCOSE_LOG)
public class GlucoseLog extends TenantBaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.HBA1C)
	private Float hba1c;

	@Column(name = FieldConstants.GLUCOSE_TYPE)
	private String glucoseType;

	@Column(name = FieldConstants.GLUCOSE_VALUE)
	private Float glucoseValue;

	@Column(name = FieldConstants.LAST_MEAL_TIME)
	private Date lastMealTime;

	@Column(name = FieldConstants.GLUCOSE_DATE_TIME)
	private Date glucoseDateTime;

	@Column(name = FieldConstants.GLUCOSE_UNIT)
	private String glucoseUnit;

	@Column(name = FieldConstants.HBA1C_UNIT)
	private String hba1cUnit;

	@Column(name = FieldConstants.TYPE)
	private String type;

	@Column(name = FieldConstants.IS_LATEST)
	private boolean isLatest;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
	private Long patientTrackId;

	@Column(name = FieldConstants.IS_UPDATED_FROM_ENROLLMENT)
	private boolean isUpdatedFromEnrollment;

	@Column(name = FieldConstants.SCREENING_ID)
	private Long screeningId;

	@Column(name = FieldConstants.ASSESSMENT_TENANT_ID)
	private Long assessmentTenantId;

	@Column(name = FieldConstants.BG_TAKEN_ON)
	private Date bgTakenOn;

	@Transient
	private boolean isRedRiskPatient;

	@Column(name = FieldConstants.RISK_LEVEL)
	private String riskLevel;

	@Transient
	private Long glocoseLogId;

}