package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.mdtlabs.coreplatform.common.model.entity.spice.BpLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.GlucoseLog;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealth;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientMedicalCompliance;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientSymptom;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientTracker;

import lombok.Data;

@Data
public class AssessmentResponseDTO {
    
    private PatientDetailDTO patientDetails;

    private GlucoseLogDTO glucoseLog;

    private BpLogDTO bpLog;

    private MentalHealthDTO phq4;

    private List<PatientSymptomDTO> symptoms;

    private List<PatientComplianceDTO> medicalCompliance;

    private String riskLevel;

    private String riskMessage;

    public void setSymptoms(List<PatientSymptom> symptoms) {
        ModelMapper mapper = new ModelMapper();
        this.symptoms = mapper.map(symptoms, new TypeToken<List<PatientSymptomDTO>>() {
        }.getType());
    }

    public void setMedicalCompliance(List<PatientMedicalCompliance> medicalCompliance) {
        ModelMapper mapper = new ModelMapper();
        this.symptoms = mapper.map(medicalCompliance, new TypeToken<List<PatientComplianceDTO>>() {
        }.getType());
    }
}
