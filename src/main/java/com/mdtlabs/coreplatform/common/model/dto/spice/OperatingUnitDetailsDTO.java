package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import lombok.Data;

@Data
public class OperatingUnitDetailsDTO {
	private Long id;
	private String name;
	private Long tenantId;
	private List<UserOrganizationDTO> users;
	private ParentOrganizationDTO account;

}
