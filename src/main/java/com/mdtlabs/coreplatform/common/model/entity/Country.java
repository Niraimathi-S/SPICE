package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for country table.
 * </p>
 * 
 * @author VigneshKumar created on Jun 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_COUNTRY)
public class Country extends BaseEntity {

	@NotEmpty(message = ErrorConstants.COUNTRY_NAME_NOT_NULL)
	@Column(name = FieldConstants.NAME)
	private String name;

	@NotEmpty(message = ErrorConstants.COUNTRYCODE_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_CODE)
	private String countryCode;

	@NotEmpty(message = ErrorConstants.UNIT_MEASUREMENT_NOT_NULL)
	@Column(name = FieldConstants.UNIT_MEASUREMENT)
	private String unitMeasurement;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;
}