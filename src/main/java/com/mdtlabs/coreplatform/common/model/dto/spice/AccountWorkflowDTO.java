package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;

import lombok.Data;

@Data
public class AccountWorkflowDTO {
	private Long id;
	@NotBlank(message = ErrorConstants.ACCOUNT_NAME_NOT_NULL)
	private String name;
	private int maxNoOfUsers;
	private boolean isUsersRestricted;
	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	private Long countryId;
	@NotNull(message = ErrorConstants.CLINICAL_WORKFLOW_NOT_NULL)
	private List<Long> clinicalWorkflows;
	private List<Long> customizedWorkflows;
	private String reason;
	private String status;
	private Long tenantId;
}
