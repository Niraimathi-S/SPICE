package com.mdtlabs.coreplatform.common.model.dto.spice;


import lombok.Data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientBpLogsDTO {
	
	private int total;

	private int limit;

	private int skip;

	private List<BpLogDTO> bpLogList;

//	private List<String> symptomList;

	private BpLogDTO latestBpLog;

	private Map<String, Integer> bpThreshold;
    
}
