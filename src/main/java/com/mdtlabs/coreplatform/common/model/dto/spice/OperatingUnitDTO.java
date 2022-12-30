package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class OperatingUnitDTO {
	private Long id;
	private String name;
	private Long tenantId;
	private ParentOrganizationDTO account;
}
