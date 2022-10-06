package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;

@Data
public class PatientLabTestResultDTO {
    private String id;
    @NotEmpty(message = ErrorConstants.PATIENT_LABTEST_RESULT_NAME_NOT_NULL)
    private String name;
    private String displayName;
    @NotEmpty(message = ErrorConstants.RESULT_VALUE_NOT_NULL)
    private String resultValue;
    @NotEmpty(message = ErrorConstants.UNIT_NOT_NULL)
    private String unit;
    private String resultStatus;
    private Boolean isAbnormal;
    private Boolean IsUnitValid;
    private Boolean IsResultValueValid;
    @NotNull(message = ErrorConstants.DISPLAY_ORDER_NOT_NULL)
    @Min(value = 1,message = ErrorConstants.DISPLAY_ORDER_MIN_VALUE)
    private Integer displayOrder;
}
