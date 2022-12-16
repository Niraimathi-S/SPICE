package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_LAB_TEST_RESULT_RANGE)
@DynamicUpdate
@JsonFilter("labTestResultRangeFilter")
public class LabTestResultRange extends TenantBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = FieldConstants.LAB_TEST_ID)
	private Long labTestId;

	@NotNull
	@Column(name = FieldConstants.LAB_TEST_RESULT_ID)
	private Long labTestResultId;

	@NotNull(message = "Labtest result range minimum value")
	@Column(name = FieldConstants.MINIMUM_VALUE)
	private Integer minimumValue;

	@NotNull(message = "Labtest result range maximum value")
	@Column(name = FieldConstants.MAXIMUM_VALUE)
	private Integer maximumValue;

	@NotBlank(message = "Labtest result range unit")
	@Column(name = FieldConstants.UNIT)
	private String unit;

	@NotNull(message = "Labtest result range unit id")
	@Column(name = FieldConstants.UNIT_ID)
	private Long unitId;

	@NotNull(message = "Labtest result range display order")
	@Column(name = FieldConstants.DISPLAY_ORDER)
	private Integer displayOrder;

	@NotBlank(message = "Labtest result range display name")
	@Column(name = FieldConstants.DISPLAY_NAME)
	private String displayName;

}
