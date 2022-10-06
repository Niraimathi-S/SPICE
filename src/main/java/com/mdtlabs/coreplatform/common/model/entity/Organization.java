package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;

import lombok.Data;

/**
 * <p>
 * Organization class to get the notification entity.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@Data
@Entity
@Table(name = "organization")
public class Organization extends BaseEntity {

	@Column(name = FieldConstants.FORM_DATA_ID)
	private Long formDataId;

	@Column(name = FieldConstants.FORM_NAME)
	private String formName;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Column(name = FieldConstants.SEQUENCE)
	private long sequence;

	@Column(name = FieldConstants.PARENT_ORGANIZATION_ID)
	private Long parentOrganizationId;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

}