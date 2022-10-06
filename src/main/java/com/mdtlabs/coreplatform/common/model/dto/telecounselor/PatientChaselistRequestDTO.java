package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * This is a DTO class for patient chaselist request entity.
 *
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class PatientChaselistRequestDTO {

	private Map<String, List> filters;

	private int limit;

	private int pageNumber;

	private Map<String, List> adFilters;
}
