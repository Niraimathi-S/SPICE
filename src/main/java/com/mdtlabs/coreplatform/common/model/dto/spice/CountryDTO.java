package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.model.entity.User;

import lombok.Data;

@Data
public class CountryDTO {

    private long id;

    private Boolean isDeleted;

	private Boolean isActive;
	
	@NotEmpty(message = ErrorConstants.COUNTRY_NAME_NOT_NULL)
	private String name;

	@NotEmpty(message = ErrorConstants.COUNTRYCODE_NOT_NULL)
	private String countryCode;

	@NotEmpty(message = ErrorConstants.UNIT_MEASUREMENT_NOT_NULL)
	private String unitMeasurement;

	@NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
	private Long tenantId;

	@Transient
	private List<User> users;
}
