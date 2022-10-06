package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import javax.validation.*;
import java.util.Date;
import java.util.List;

/**
 * This class is a DTO used to get request for PatientLabtestResult entity operations.
 *
 * @author Niraimathi S
 */
@Data
public class PatientLabTestResultRequestDTO {
    private Long patientLabTestId;
    private Long tenantId;
    private Boolean isReviewed;
    private Date testedOn;
    private String comment;
    private Boolean isEmptyRanges;
    @Valid
    private List<PatientLabTestResultDTO> patientLabTestResults;
}
