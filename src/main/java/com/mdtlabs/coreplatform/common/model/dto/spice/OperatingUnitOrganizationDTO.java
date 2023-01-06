package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.Account;

import lombok.Data;

@Data
public class OperatingUnitOrganizationDTO {
	private String name;
	private Account account;
	private Long countryId;
	private Long tenantId;
	private Long parentOrganizationId;
	private List<UserOrganizationDTO> users;
}
