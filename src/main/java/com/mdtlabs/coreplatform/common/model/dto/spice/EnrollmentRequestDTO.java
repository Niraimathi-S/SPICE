package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;
import java.util.Map;


import lombok.Data;

import javax.validation.*;
import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealth;

/**
 * EnrollmentRequestDTO to handling request for Enrollment.
 */
@Data
public class EnrollmentRequestDTO {

	private Boolean isPregnant;
	@NotEmpty(message = ErrorConstants.GENDER_NOT_NULL)
	private String gender;
	private Integer cvdRiskScore;
	private Date dateOfBirth;
	private String unitMeasurement;
	private String cvdRiskScoreDisplay;
	private BioMetricsDTO bioMetrics;
	private String cvdRiskLevel;
	@NotNull(message = ErrorConstants.SITE_ID_NOT_NULL)
	private Long site;
	private GlucoseLog glucoseLog;
	@Valid
	private BioDataDTO bioData;
	private Long patientTrackerId;
	@NotNull(message = ErrorConstants.AGE_NOT_NULL)
	@PositiveOrZero(message = ErrorConstants.AGE_MIN_VALUE)
	private Integer age;
	@NotNull(message = ErrorConstants.IS_REGULAR_SMOKER)
	private Boolean isRegularSmoker;
	private MentalHealth phq4;
	private Long tenantId;
	private List<String> provisionalDiagnosis;
	private List<Map<String, Object>> customizedWorkflows;
	@Valid
	private BpLog bplog;

}
