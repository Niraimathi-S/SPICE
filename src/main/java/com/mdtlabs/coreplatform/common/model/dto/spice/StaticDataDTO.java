package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.County;
import com.mdtlabs.coreplatform.common.model.entity.Program;
import com.mdtlabs.coreplatform.common.model.entity.Site;
import com.mdtlabs.coreplatform.common.model.entity.Subcounty;
import com.mdtlabs.coreplatform.common.model.entity.spice.Diagnosis;
import com.mdtlabs.coreplatform.common.model.entity.spice.DosageForm;
import com.mdtlabs.coreplatform.common.model.entity.spice.DosageFrequency;
import com.mdtlabs.coreplatform.common.model.entity.spice.MedicalCompliance;
import com.mdtlabs.coreplatform.common.model.entity.spice.NutritionLifestyle;
import com.mdtlabs.coreplatform.common.model.entity.spice.Reason;
import com.mdtlabs.coreplatform.common.model.entity.spice.SideMenu;
import com.mdtlabs.coreplatform.common.model.entity.spice.Symptom;
import com.mdtlabs.coreplatform.common.model.entity.spice.Unit;

import lombok.Data;

/**
 * 
 * This class is a Data transfer object for static data service. It contains all
 * the meta data requested.
 * 
 */
@Data
public class StaticDataDTO {
	private List<Site> operatingSites;
	private List<SideMenu> menus;
	private List<Program> programs;
	private List<MedicalCompliance> medicalCompliances;
	private List<Diagnosis> diagnosis;
	private List<Country> countries;
	private List<County> counties;
	private List<Subcounty> subcounties;
	private List<DosageForm> dosageForm;
	private List<DosageFrequency> dosageFrequency;
	private List<Reason> reasons;
	private List<Unit> units;
	private List<NutritionLifestyle> nutritionLifestyle;
	private List<Symptom> symptoms;
	private Map<String, Object> cvdRiskAlgorithms;
	private Site defaultSite;
	private List<SiteDTO> sites;
	private Long accountId;
	private Long operatingUnitId;
	private Map<String, Boolean> clinicalWorkflow;
	private Map<String, Boolean> customizedWorkflow;
	private Map<String, String> enrollment;
	private Map<String, String> screening;
	private Map<String, String> assessment;
//	private Map<String, List<ModelQuestions>> mentalHealth;
	private List<Map<String, String>> mentalHealth;
}
