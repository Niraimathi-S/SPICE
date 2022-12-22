package com.mdtlabs.coreplatform.common.model.dto.spice;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.mdtlabs.coreplatform.common.ErrorConstants;

import lombok.Data;

@Data
@Validated
// @JsonInclude(JsonInclude.)
public class ComplianceDTO {

	private Long id;

	@NotNull(message = ErrorConstants.COMPLIANCE_NAME_NOT_NULL)
	private String name;

	@NotNull(message = ErrorConstants.COMPLIANCE_ID_NOT_NULL)
	private Long complianceId;

	private Boolean isChildExist;

	private String otherCompliance;
}
