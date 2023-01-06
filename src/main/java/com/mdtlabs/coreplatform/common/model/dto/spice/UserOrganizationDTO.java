package com.mdtlabs.coreplatform.common.model.dto.spice;

import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Timezone;

import lombok.Data;

@Data
public class UserOrganizationDTO {
	private long id;

	private String username;
	
	private String firstName;

	private String lastName;

	private String gender;
	
	private Country country;
	
	private String countryCode;
	
	private String phoneNumber;
	
	private Timezone timezone;
}
