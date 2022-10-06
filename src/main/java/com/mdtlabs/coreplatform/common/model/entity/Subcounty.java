package com.mdtlabs.coreplatform.common.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

@Data
@Entity
@Table(name = TableConstants.TABLE_SUB_COUNTY)
public class Subcounty extends BaseEntity {

	@NotEmpty(message = ErrorConstants.SUB_COUNTY_NAME_NOT_NULL)
	@Column(name = FieldConstants.NAME)
	private String name;
	
	@Column(name = FieldConstants.DISPLAY_ORDER)
	private int displayOrder;

	@NotNull(message = ErrorConstants.COUNTRY_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@NotNull(message = ErrorConstants.COUNTY_NOT_NULL)
	@Column(name = FieldConstants.COUNTY_ID)
	private Long countyId;

}
