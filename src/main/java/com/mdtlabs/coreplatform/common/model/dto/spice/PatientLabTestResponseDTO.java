package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLabTest;

import lombok.Data;

@Data
//@JsonSerialize(using = CustomDateSerializer.class)
public class PatientLabTestResponseDTO implements Serializable {

	private static final long serialVersionUID = 4342728027730218148L;

	private List<PatientLabTest> patientLabTest;

	private List<Map> patientLabtestDates;
}
