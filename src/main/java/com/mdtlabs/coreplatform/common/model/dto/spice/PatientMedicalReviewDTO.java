package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class PatientMedicalReviewDTO {

    private Long id;

    private Long patientVisitId;
    
    private Set<String> physicalExams;

    private Set<String> complaints;

    private String physicalExamComments;

    private String compliantComments;

    private Date reviewedAt;

    public PatientMedicalReviewDTO(Long id, Long patientVisitId, Set<String> physicalExams, Set<String> complaints,
            String physicalExamComments, String compliantComments, Date reviewedAt) {
        this.id = id;
        this.patientVisitId = patientVisitId;
        this.physicalExams = physicalExams;
        this.complaints = complaints;
        this.physicalExamComments = physicalExamComments;
        this.compliantComments = compliantComments;
        this.reviewedAt = reviewedAt;
    }

    
}
