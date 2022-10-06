package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_ACCOUNT_WORKFLOW, uniqueConstraints = {
		@UniqueConstraint(name = TableConstants.NAME_AND_COUNTRY_ID, columnNames = { FieldConstants.NAME,
				FieldConstants.COUNTRY_ID }) })
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@DynamicUpdate
public class AccountWorkflow extends BaseEntity {

	@NotBlank(message = ErrorConstants.ACCOUNT_WORKFLOW_NAME_NOT_EMPTY)
	@Column(name = FieldConstants.NAME)
	private String name;

	@NotNull(message = ErrorConstants.ACCOUNT_WORKFLOW_VIEWSCREEN_NOT_NULL)
	@Size(min = 1,message = ErrorConstants.ACCOUNT_WORKFLOW_VIEWSCREEN_NOT_NULL)
	@Type(type = "list-array")
	@Column(name = FieldConstants.VIEW_SCREENS, columnDefinition = "text[]")
	private List<String> viewScreens;

	@Column(name = FieldConstants.WORKFLOW)
	private String workflow;

	@Column(name = FieldConstants.MODULE_TYPE)
	private String moduleType;

	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;
}
