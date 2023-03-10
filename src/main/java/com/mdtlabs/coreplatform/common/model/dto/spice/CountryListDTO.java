package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This is an DTO class for Country entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class CountryListDTO {
	private long id;
	private String name;
	private int accountsCount;
	private int OUCount;
	private int siteCount;
	private Long tenantId;
}
