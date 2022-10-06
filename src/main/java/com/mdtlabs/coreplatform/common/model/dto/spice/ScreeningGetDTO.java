package com.mdtlabs.coreplatform.common.model.dto.spice;

import javax.persistence.criteria.Predicate.BooleanOperator;

import lombok.Data;

@Data
public class ScreeningGetDTO {
    
    private boolean isAssessmentDataRequired;

    private Long patientTrackId;

    private Long screeningId;
}
