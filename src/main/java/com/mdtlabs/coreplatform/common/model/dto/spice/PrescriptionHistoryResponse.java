package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.PrescriptionHistory;

import lombok.Data;

@Data
public class PrescriptionHistoryResponse {

	List<PrescriptionHistory> patientPrescription;
	List<Date> prescriptionHistoryDates;

}
