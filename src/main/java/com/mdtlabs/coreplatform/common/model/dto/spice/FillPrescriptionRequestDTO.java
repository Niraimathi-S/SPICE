package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.FillPrescription;

import lombok.Data;

@Data
public class FillPrescriptionRequestDTO extends CommonRequestDTO {

	private List<FillPrescription> fillPrescriptions;

}
