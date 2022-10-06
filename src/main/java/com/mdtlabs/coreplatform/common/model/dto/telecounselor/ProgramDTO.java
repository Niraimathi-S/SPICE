package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import com.mdtlabs.coreplatform.common.model.entity.Account;
import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.Operatingunit;
import com.mdtlabs.coreplatform.common.model.entity.Site;

import lombok.Data;

/**
 * This is a DTO class for program entity.
 * 
 * @author Arunkarthik Created on 26 aug 2022
 */
@Data
public class ProgramDTO {

	private String id;

	private String name;

	private Country country;

	private Account account;

	private Operatingunit operatingUnit;

	private Site site;

	private String tenantId;

	private Boolean isDeleted;

	private Boolean isActive;
}
