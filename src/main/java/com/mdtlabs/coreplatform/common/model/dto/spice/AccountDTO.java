package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This is an DTO class for Account entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class AccountDTO {
	private Long id;
	private String name;
	private int maxNoOfUsers;
	private Long updatedAt;
	private Long tenantId;
	private CountryDTO country;
}
