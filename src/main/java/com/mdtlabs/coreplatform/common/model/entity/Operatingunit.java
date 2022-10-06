package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_OPERATING_UNIT)
@DynamicUpdate
public class Operatingunit extends BaseEntity {

	private static final long serialVersionUID = -2584864712605974827L;

	@NotBlank
	@Column(name = FieldConstants.NAME, unique = true)
	private String name;

	@Column(name = FieldConstants.ACCOUNT_ID)
	private Long accountId;

	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

}
