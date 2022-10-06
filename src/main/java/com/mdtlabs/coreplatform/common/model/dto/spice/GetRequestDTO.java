package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class GetRequestDTO extends RequestDTO {

    private boolean isDeleted;
    private boolean isLatestRequired;
    private Long prescriptionId;
    private String roleName;
    private String comment;
    private Long patientPregnancyId;
}
