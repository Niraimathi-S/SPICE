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
public class Organization extends TenantBaseEntity {

	public Organization(String formName, String name, Long parentOrganizationId, Long tenantId) {
		super();
		this.formName = formName;
		this.name = name;
		this.parentOrganizationId = parentOrganizationId;
		this.tenantId = tenantId;
	}

	public Organization() {
	}

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.FORM_DATA_ID)
	private Long formDataId;

	@Column(name = FieldConstants.FORM_NAME)
	private String formName;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Column(name = FieldConstants.SEQUENCE)
	private Long sequence;

	@Column(name = FieldConstants.PARENT_ORGANIZATION_ID)
	private Long parentOrganizationId;

}