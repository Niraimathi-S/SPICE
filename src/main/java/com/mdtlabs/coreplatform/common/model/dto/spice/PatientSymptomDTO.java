package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class PatientSymptomDTO {

    private Long id;

    private Long symptomId;

    private String name;

    private String type;
}
