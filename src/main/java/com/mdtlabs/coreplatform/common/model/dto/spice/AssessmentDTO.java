package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealth;

import lombok.Data;

/**
 * This class is an Request DTO class for assessment.
 *
 * @author Karthick M
 */
@Data
@Validated
public class AssessmentDTO extends CommonRequestDTO {

	private String nationalId;

	@Valid
	private BpLog bpLog;

	private GlucoseLog glucoseLog;

	private String gender;

	private String firstName;

	private String lastName;

	private Integer age;

	@NotNull(message = ErrorConstants.IS_REGULAR_SMOKER)
	private Boolean isRegularSmoker;

	private Integer cvdRiskScore;

	private String unitMeasurement;

	private String cvdRiskScoreDisplay;

	private String cvdRiskLevel;

	private MentalHealth phq4;

	@Valid
	private Set<ComplianceDTO> compliances;

	@Valid
	private Set<SymptomDTO> symptoms;

	private Long siteId;

	private List<Map<String, Object>> customizedWorkflows;

	private List<String> provisionalDiagnosis;

}
