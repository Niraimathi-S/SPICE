package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.spice.Comorbidity;
import com.mdtlabs.coreplatform.common.model.entity.spice.Complaints;
import com.mdtlabs.coreplatform.common.model.entity.spice.Complication;
import com.mdtlabs.coreplatform.common.model.entity.spice.CurrentMedication;
import com.mdtlabs.coreplatform.common.model.entity.spice.Lifestyle;
import com.mdtlabs.coreplatform.common.model.entity.spice.PhysicalExamination;

import lombok.Data;

@Data
public class MedicalReviewStaticDataDTO {
	private List<Comorbidity> comorbidity;
	private List<Complication> complications;
	private List<CurrentMedication> currentMedication;
	private List<PhysicalExamination> physicalExamination;
	private List<Lifestyle> lifestyle;
	private List<Complaints> complaints;
	private Map<String, Object> treatmentPlanFromData;
}
