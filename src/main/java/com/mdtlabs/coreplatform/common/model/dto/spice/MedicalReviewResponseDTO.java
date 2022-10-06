package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLabTest;

import lombok.Data;

@Data
@JsonInclude(value =  JsonInclude.Include.NON_NULL)
public class MedicalReviewResponseDTO {

    private Map<String, Object> patientDetails;

    private List<PatientMedicalReviewDTO> medicalReviews;

    private List<Map<String, Object>> patientReviewDates;

    private List<PatientMedicalReviewDTO> patientMedicalReview;

    private Object prescriptions;

    private List<PatientLabTest> investigations;

    private Map<String, String> reviewerDetails;

    // private List<PrescriptionHistory> history;

    private Boolean isSigned;

    private Date reviewedAt;
    
    private String medicalReviewFrequency;
    
    public MedicalReviewResponseDTO(Map<String, Object> patientDetails, List<PatientMedicalReviewDTO> medicalReviews,
            List<Map<String, Object>> patientReviewDates, List<PatientMedicalReviewDTO> patientMedicalReview,
            List<Object> prescriptions, List<PatientLabTest> investigations, Map<String, String> reviewerDetails,
            Boolean isSigned, Date reviewedAt, String medicalReviewFrequency) {
        this.patientDetails = patientDetails;
        this.medicalReviews = medicalReviews;
        this.patientReviewDates = patientReviewDates;
        this.patientMedicalReview = patientMedicalReview;
        this.prescriptions = prescriptions;
        this.investigations = investigations;
        this.reviewerDetails = reviewerDetails;
        this.isSigned = isSigned;
        this.reviewedAt = reviewedAt;
        this.medicalReviewFrequency = medicalReviewFrequency;
    }

    public MedicalReviewResponseDTO() {
    }

    public MedicalReviewResponseDTO(List<Map<String, Object>> patientReviewDates, List<PatientMedicalReviewDTO> patientMedicalReview) {
        this.patientReviewDates = patientReviewDates;
        this.patientMedicalReview = patientMedicalReview;
    }

    
}
