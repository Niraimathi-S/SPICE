package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.TABLE_ACCOUNT_CUSTOMIZATION)
public class AccountCustomization extends BaseEntity {

	@NotBlank(message = ErrorConstants.TYPE_NOT_NULL)
	@Column(name = FieldConstants.TYPE)
	private String type;

	@NotBlank(message = ErrorConstants.CATEGORY_NOT_NULL)
	@Column(name = FieldConstants.CATEGORY)
	private String category;

	@NotBlank(message = ErrorConstants.FORM_INPUT_NOT_NULL)
	@Column(name = FieldConstants.FORM_INPUT)
	private String formInput;

	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@Column(name = FieldConstants.CLINICAL_WORFKLOW_ID)
	private Long clinicalWorkflowId;

//	@NotNull
	@Column(name = FieldConstants.ACCOUNT_ID)
	private Long accountId;

	@Column(name = FieldConstants.WORKFLOW)
	private Long workflow;

	@NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

}
