package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class PatientBpLogsRequestDTO {
	private boolean isLatestRequired;

	private long patientTrackerId;
    
}
