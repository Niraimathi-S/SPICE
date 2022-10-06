package com.mdtlabs.coreplatform.common.model.dto.spice;

import com.mdtlabs.coreplatform.common.model.entity.Country;

import lombok.Data;

@Data
public class ProgramDTO {
    
    private long id;
    
	private Boolean isDeleted;

	private Boolean isActive;

	private String name;

    private Country country;

    private long account;

    private long operatingUnit;

    private long site;

}
