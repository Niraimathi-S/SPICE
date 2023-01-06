package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.spice.AccountWorkflow;

import lombok.Data;

@Data
public class AccountDetailsDTO {
	private Long id;
	private String name;
	private int maxNoOfUsers;
	private Long tenantId;
	private CountryDTO country;
	private List<AccountWorkflow> clinicalWorkflow;
	private List<AccountWorkflow> customizedWorkflow;
	private List<UserOrganizationDTO> users;
	private String countryCode;
}
