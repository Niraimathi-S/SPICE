package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class SiteListDTO {
	private Long id;

	private String name;

	private Long tenantId;

	private String operatingUnitName;

	private String culture;

	private String siteLevel;

	private String siteType;
}
