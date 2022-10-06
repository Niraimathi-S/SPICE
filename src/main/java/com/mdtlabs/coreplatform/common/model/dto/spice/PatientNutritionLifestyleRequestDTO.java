package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mdtlabs.coreplatform.common.model.entity.spice.PatientNutritionLifestyle;

@Data
public class PatientNutritionLifestyleRequestDTO {
    
    private Set<Long> lifestyle;

    private List<PatientNutritionLifestyle> lifestyles;

    private String lifestyleAssessment;

    private boolean isNutritionist;

    private Long referredBy;

    private Date referredDate;

    private String referredByDisplay;

    private String referredFor;

    private Long patientTrackId;

    private Long tenantId;

    private Long patientVisitId;

    private String clinicalNote;

    private String otherNote;
}
