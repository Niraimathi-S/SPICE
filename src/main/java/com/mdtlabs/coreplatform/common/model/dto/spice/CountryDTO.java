package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class CountryDTO {

    private long id;

    private Boolean isDeleted;

	private Boolean isActive;

	private String name;

	private String countryCode;

	private String unitMeasurement;
}
