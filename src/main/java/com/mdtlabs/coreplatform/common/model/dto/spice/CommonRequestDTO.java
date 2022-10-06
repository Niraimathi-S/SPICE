package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class CommonRequestDTO {

	private Long id;
	private Long patientTrackId;
	private Long patientVisitId;
	private Long tenantId;

}
