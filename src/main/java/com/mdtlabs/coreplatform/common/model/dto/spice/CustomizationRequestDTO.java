package com.mdtlabs.coreplatform.common.model.dto.spice;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomizationRequestDTO {

	@NotNull
	private Long countryId;

	private String type;

	private String category;

	private Long clinicalWorkflowId;

	@NotNull
	private Long accountId;
	// private long tenantId;
}
