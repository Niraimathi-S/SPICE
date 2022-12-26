package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.dto.spice.GlucoseLogDTO;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;

import lombok.Data;

@Data
public class PatientGlucoseLogDTO {
    
    private int total;

	private int limit;

	private int skip;

	private List<GlucoseLogDTO> glucoseLogList;

	// private List<String> symptomList;

	private GlucoseLogDTO latestGlucoseLog;

	private List<Map<String, Object>> glucoseThreshold;
}
