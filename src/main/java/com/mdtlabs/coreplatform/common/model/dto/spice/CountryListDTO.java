package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class CountryListDTO {
	private long id;
	private String name;
	private int accountsCount;
	private int OUCount;
	private int siteCount;
}
