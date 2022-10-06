package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Set;

import com.mdtlabs.coreplatform.common.model.entity.spice.PatientComorbidity;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientComplication;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientDiagnosis;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLifestyle;

import lombok.Data;

@Data
public class InitialMedicalReviewDTO {
    
    private PatientDiagnosis diagnosis;

    private CurrentMedicationDetailsDTO currentMedications;
    
    private Set<PatientComorbidity> comorbidities;
    
    private Set<PatientComplication> complications;

    private Set<PatientLifestyle> lifestyle;

}
