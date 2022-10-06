package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class FillPrescriptionResponseDTO implements Serializable {

	private static final long serialVersionUID = -5831078400623272997L;

	Long id;
	String medicationName;
	String dosageUnitName;
	String dosageUnitValue;
	String dosageFormName;
	String dosageFrequencyName;
	String instructionNote;
	Date endDate;
	int remainingPrescriptionDays;
	long tenantId;
	long prescription;
	Date createdAt;
	String classificationName;
	String brandName;

}
