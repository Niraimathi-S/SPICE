package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;

import lombok.Data;

@Data
public class AccountOrganizationDTO {
	private Long id;
	@NotBlank(message = ErrorConstants.ACCOUNT_NAME_NOT_NULL)
	private String name;
	private int maxNoOfUsers;
	private Long tenantId;
	private boolean isUsersRestricted;
	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	private Long countryId;
	@NotNull(message = ErrorConstants.CLINICAL_WORKFLOW_NOT_NULL)
	private List<Long> clinicalWorkflow;
	private List<Long> customizedWorkflow;
	private List<UserOrganizationDTO> users;
	private String countryCode;
	@NotNull(message = ErrorConstants.PARENT_ORG_ID_NOT_NULL)
	private Long parentOrganizationId;
}
