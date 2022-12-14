package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.model.entity.User;

import lombok.Data;

@Data
public class CountryOrganizationDTO {
	private long id;

//	private boolean isDeleted;
//
//	private boolean isActive;

	@NotEmpty(message = ErrorConstants.COUNTRY_NAME_NOT_NULL)
	private String name;

	@NotEmpty(message = ErrorConstants.COUNTRYCODE_NOT_NULL)
	private String countryCode;

	@NotEmpty(message = ErrorConstants.UNIT_MEASUREMENT_NOT_NULL)
	private String unitMeasurement;

	private List<UserOrganizationDTO> users;
	
	private Long tenantId;
}
