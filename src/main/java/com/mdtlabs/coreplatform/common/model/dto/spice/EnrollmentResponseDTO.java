package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealth;
import com.mdtlabs.coreplatform.common.model.entity.spice.Patient;

import lombok.Data;

/**
 * This class is a data transfer objects for enrollment response.
 * 
 * @author Niraimathi S
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnrollmentResponseDTO  {
	
	private String phoneNumber;
    
    private PatientDetailDTO enrollment;
    
    private GlucoseLogDTO glucoseLog;
    
    private BpLogDTO bpLog;
    
    private List<Map<String, String>> treatmentPlan;
    
   private Boolean isConfirmDiagnosis;
    
   private List<String> confirmDiagnosis;
    
   private List<String> provisionalDiagnosis;

   private MentalHealthDTO phq4;

}
