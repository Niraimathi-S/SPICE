package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

/**
 * This is an DTO class for Operating Unit entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class OperatingUnitListDTO {
	public OperatingUnitListDTO(long id, String name, Long tenantId) {
		super();
		this.id = id;
		this.name = name;
		this.tenantId = tenantId;
	}
	private long id;
	private String name;
	private int siteCount;
	private Long tenantId;
}
