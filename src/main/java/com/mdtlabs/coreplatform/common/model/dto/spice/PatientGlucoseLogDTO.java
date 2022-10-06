package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;

import lombok.Data;

@Data
public class PatientGlucoseLogDTO {
    
    private int total;

	private int limit;

	private int skip;

	private List<GlucoseLog> glucoseLogList;

	private List<String> symptomList;

	private GlucoseLog latestGlucoseLog;

	private Map<String, Object> glucoseThreshold;
}
