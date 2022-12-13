package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;

import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.Patient;

import lombok.Data;

/**
 * This class is a data transfer objects for enrollment response.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class EnrollmentResponseDTO  {
    
    private Patient enrollment;
    
    private GlucoseLog glucoseLog;
    
    private BpLog bpLog;
    
    private List<Map<String, String>> treatmentPlan;

	public PatientDTO getEnrollment() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(enrollment, PatientDTO.class);
	}

	public GlucoseLogDTO getGlucoseLog() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(glucoseLog, GlucoseLogDTO.class);
	}

	public BpLogDTO getBpLog() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(bpLog, BpLogDTO.class);
	}
    
//    private Boolean isConfirmDiagnosis;
    
//    private String[] confirmDiagnosis;
    
//    private String[] provisionalDiagnosis;
}
