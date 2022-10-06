package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data

public class MedicationDTO extends CommonRequestDTO {

	private String medicationName;

	private Long countryId;

	private Long classificationId;

	private Long dosageFormId;

	private String dosageFormName;

	private Long brandId;

}
