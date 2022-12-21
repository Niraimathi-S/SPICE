package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This is a DTO class for account entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class AccountListDTO {
	private long id;
	private String name;
	private int OUCount;
	private int siteCount;
	private Long tenantId;
}
