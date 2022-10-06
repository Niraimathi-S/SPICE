package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

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
    
//    private Boolean isConfirmDiagnosis;
    
//    private String[] confirmDiagnosis;
    
//    private String[] provisionalDiagnosis;
}
