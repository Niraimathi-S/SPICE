package com.mdtlabs.coreplatform.common.model.dto.spice;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomizationDTO {
    public CustomizationDTO(String type2, String category2, String formInput2,
			@NotNull(message = "Country id must not be null") Long countryId2,
			@NotNull(message = "Tenant Id should not be null") Long tenantId2) {
		// TODO Auto-generated constructor stub
	}

	private String type;

    private String category;

    private String formInput;

    private Long countryId;
    
    private long tenantId;
}
