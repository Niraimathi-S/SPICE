package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;
import com.mdtlabs.coreplatform.common.util.EnrollmentInfo;
import com.mdtlabs.coreplatform.common.util.ScreeningInfo;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_BP_LOG)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
public class BpLog extends TenantBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull(message = ErrorConstants.AVG_SYSTOLIC_NOT_NULL, groups = { Default.class, ScreeningInfo.class,
			EnrollmentInfo.class })
	@Column(name = FieldConstants.AVG_SYSTOLIC)
	private Integer avgSystolic;

	@NotNull(message = ErrorConstants.AVG_DIASTOLIC_NOT_NULL, groups = { Default.class, ScreeningInfo.class,
			EnrollmentInfo.class })
	@Column(name = FieldConstants.AVG_DIASTOLIC)
	private Integer avgDiastolic;

	@Column(name = FieldConstants.AVG_PULSE)
	private Integer avgPulse;

	@Column(name = FieldConstants.HEIGHT)
	private Float height;

	@Column(name = FieldConstants.WEIGHT)
	private Float weight;

	@Column(name = FieldConstants.BMI)
	private Float bmi;

	@Column(name = FieldConstants.TEMPERATURE)
	private Float temperature;

	@Column(name = FieldConstants.CVD_RISK_LEVEL)
	private String cvdRiskLevel;

	@Column(name = FieldConstants.CVD_RISK_SCORE)
	private Integer cvdRiskScore;

	@Column(name = FieldConstants.IS_LATEST)
	private boolean isLatest;

	@NotNull(message = ErrorConstants.IS_REGULAR_SMOKER)
	@Column(name = FieldConstants.IS_REGULAR_SMOKER)
	private boolean isRegularSmoker;

	@Column(name = FieldConstants.TYPE)
	private String type;

	@Column(name = FieldConstants.PATIENT_TRACK_ID)
	private Long patientTrackId;

	@Column(name = FieldConstants.SCREENING_ID)
	private Long screeningId;

	@Type(type = "jsonb")
	@Column(name = FieldConstants.BPLOG_DETAILS, columnDefinition = "jsonb")
	@NotNull(message = ErrorConstants.BPLOG_DETAILS_NOT_EMPTY, groups = { EnrollmentInfo.class, ScreeningInfo.class })
	@Size(min = 2, message = ErrorConstants.BPLOG_EDTAILS_MIN_SIZE, groups = { EnrollmentInfo.class,
			ScreeningInfo.class })
	private List<BpLogDetails> bpLogDetails;

	@Column(name = FieldConstants.RISK_LEVEL)
	private String riskLevel;

	@Column(name = FieldConstants.IS_UPDATED_FROM_ENROLLMENT)
	private boolean isUpdatedFromEnrollment;

	@Column(name = FieldConstants.BP_ARM)
	private String bpArm;

	@Column(name = FieldConstants.BP_POSITION)
	private String bpPosition;

	@Column(name = FieldConstants.COVID_VACC_STATUS)
	private String covidVaccStatus;

	@Column(name = FieldConstants.ASSESSMENT_CATEGORY)
	private String assessmentCategory;

	@Column(name = FieldConstants.ASSESSMENT_LANDMARK)
	private String assessmentLandmark;

	@Column(name = FieldConstants.NOTES)
	private String notes;

	@Column(name = FieldConstants.INSURANCE_STATUS)
	private String insuranceStatus;

	@Column(name = FieldConstants.INSURANCE_TYPE)
	private String insuranceType;

	@Column(name = FieldConstants.INSURANCE_ID)
	private String insuranceId;

	@Column(name = FieldConstants.OTHER_INSURANCE)
	private String otherInsurance;

	@Column(name = FieldConstants.BP_TAKEN_ON)
	private Date bpTakenOn;

	@Column(name = FieldConstants.ASSESSMENT_TENANT_ID)
	private Long assessmentTenantId;

	@Transient
	private boolean isRedRiskPatient;

	@Transient
	private Boolean isBeforeHtnDiagnosis;

	@Transient
	private String unitMeasurement;

}
