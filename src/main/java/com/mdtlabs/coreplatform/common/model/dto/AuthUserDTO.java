package com.mdtlabs.coreplatform.common.model.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.mdtlabs.coreplatform.common.model.dto.spice.CountryDTO;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;
import com.mdtlabs.coreplatform.common.model.entity.Timezone;

import lombok.Data;

/**
 * This is a DTO class for user entity.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
@Data
public class AuthUserDTO {

	private long id;

	private String username;

	private String gender;

	private Set<Role> roles = new HashSet<>();

	private Boolean isActive;

	private boolean accountExpired;

	private boolean accountLocked;

	private boolean credentialsExpired;

	private String authorization;

	private long currentDate;

	private String firstName;

	private String lastName;

	private String middleName;

	private String subject;

	private String phonenumber;

	private Timezone timezone;

	private Set<Organization> tenants;
	
	private String countryCode;
	
	private Boolean isBlocked;
	
	private Country country;
	
	private Long deviceInfoId;

	public Set<RoleDTO> getRoles() {
		return roles.stream().map(role -> new ModelMapper().map(role, RoleDTO.class)).collect(Collectors.toSet());
	}
	
}
