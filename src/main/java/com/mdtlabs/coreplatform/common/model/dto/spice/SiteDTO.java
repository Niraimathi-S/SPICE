package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import lombok.Data;

/**
 * This class is a Data transfer object for Site entity.
 * 
 * @author Niraimathi S
 *
 */
@Data
public class SiteDTO {
	private Long id;
	private String name;
	private Long tenantId;
	private List<String> roleName;
	private List<String> displayName;
}
