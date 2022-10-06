package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class LabTestDTO extends CommonRequestDTO {

	private String name;

	// private List<LabTestResult> labTestResults;

	private Long countryId;

	private Boolean isActive;

	private Integer displayOrder;

	private boolean isResultTemplate;
}
