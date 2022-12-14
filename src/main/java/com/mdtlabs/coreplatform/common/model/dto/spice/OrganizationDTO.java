package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.User;

import lombok.Data;

@Data
public class OrganizationDTO {
	public OrganizationDTO(Organization organization, List<User> users, List<String> roles, Boolean isSiteOrganization) {
		super();
		this.organization = organization;
		this.users = users;
		this.roles = roles;
		this.isSiteOrganization = isSiteOrganization;
	}
	
	public OrganizationDTO() {
	}
	
	private Organization organization;
	private List<User> users;
	private List<String> roles;
	private boolean isSiteOrganization;
}
