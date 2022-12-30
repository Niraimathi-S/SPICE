package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class ParentOrganizationDTO {
    private Long id;
    private String name;
    private Long tenantId;
}
