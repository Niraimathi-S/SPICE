package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLabTest;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientVisit;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalReviewSummaryDTO {
    
    private PatientDetailsDTO patientDetails;

    private List<PatientMedicalReviewDTO> medicalReviews;

    private List<PatientVisit> patientReviewDates;

    private List<Object> prescriptions;

    private List<PatientLabTest> investigations;

    private ReviewerDetailsDTO reviewerDetails;

    private boolean isSigned;

    private Date reviewedAt;

    private String medicalReviewFrequency;

    public MedicalReviewSummaryDTO(PatientDetailsDTO patientDetails, List<PatientMedicalReviewDTO> medicalReviews,
            List<Object> prescriptions, List<PatientLabTest> investigations, ReviewerDetailsDTO reviewerDetails,
            boolean isSigned, Date reviewedAt, String medicalReviewFrequency) {
        this.patientDetails = patientDetails;
        this.medicalReviews = medicalReviews;
        this.prescriptions = prescriptions;
        this.investigations = investigations;
        this.reviewerDetails = reviewerDetails;
        this.isSigned = isSigned;
        this.reviewedAt = reviewedAt;
        this.medicalReviewFrequency = medicalReviewFrequency;
    }

    public MedicalReviewSummaryDTO() {
    }

    
    

 
}
