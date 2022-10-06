package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import java.util.Date;
import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLabTestResult;



@Data
public class PatientLabTestResultResponseDTO {
    private String comment;
    private Date resultDate;
    private List<PatientLabTestResult> patientLabTestResults;
}
