package com.mdtlabs.coreplatform.common.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.spice.AccountWorkflow;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_ACCOUNT)
public class Account extends BaseEntity {

	@NotBlank(message = ErrorConstants.ACCOUNT_NAME_NOT_NULL)
	@Column(name = FieldConstants.NAME, unique = true)
	private String name;
	
	@Column(name = FieldConstants.MAX_NO_OF_USERS)
	private int maxNoOfUsers;

	@Column(name = FieldConstants.IS_USERS_RESTRICTED)
	private boolean isUsersRestricted;
	
	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

	@NotNull(message = ErrorConstants.CLINICAL_WORKFLOW_NOT_NULL)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_ACCOUNT_CLINICAL_WORKFLOW, joinColumns = {
			@JoinColumn(name = FieldConstants.ACCOUNT_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.CLINICAL_WORFKLOW_ID) })
	private List<AccountWorkflow> clinicalWorkflows;

	@NotNull(message = ErrorConstants.CLINICAL_WORKFLOW_NOT_NULL)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @Fetch(FetchMode.SELECT)
	@JoinTable(name = TableConstants.TABLE_ACCOUNT_CLINICAL_WORKFLOW, joinColumns = {
			@JoinColumn(name = FieldConstants.ACCOUNT_ID) }, inverseJoinColumns = { @JoinColumn(name = FieldConstants.CUSTOMIZED_WORFKLOW_ID) })
	private List<AccountWorkflow> customizedWorkflows;

}
