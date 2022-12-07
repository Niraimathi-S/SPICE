package com.mdtlabs.coreplatform.common.model.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.mdtlabs.coreplatform.common.model.entity.Role;

import lombok.Data;

/**
 * This is a DTO class for user profile entity.
 *
 * @author TamilarasiShanmugasundaram created on July 26, 2022
 */
@Data
public class UserProfileDTO {

	private long id;

	private Set<Role> roles = new HashSet<>();

	private String firstName;

	private String lastName;
	
	public Set<RoleDTO> getRoles() {
		return roles.stream().map(role -> new ModelMapper().map(role, RoleDTO.class)).collect(Collectors.toSet());
	}
}
