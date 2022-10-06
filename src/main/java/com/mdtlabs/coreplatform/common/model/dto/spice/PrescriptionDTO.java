package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.*;

import com.mdtlabs.coreplatform.common.ErrorConstants;

/**
 * DTO class for prescription
 * 
 * @author Jeyaharini T A
 *
 */

@Data
public class PrescriptionDTO {
	private Long id;
	@NotNull(message = ErrorConstants.MEDICATION_ID_NOT_NULL)
	private Long medicationId;
	@NotNull(message = ErrorConstants.DOSAGE_FREQUENCY_NOT_NULL)
	private Long dosageFrequencyId;
	@NotNull(message = ErrorConstants.DOSAGE_UNIT_NOT_NULL)
	private Long dosageUnitId;
	private Date endDate;
	@NotNull(message = ErrorConstants.PRESCRIBED_DAYS)
	private Integer prescribedDays;
	private String classificationName;
	private String brandName;
	@NotEmpty(message = ErrorConstants.MEDICATION_NAME_NOT_NULL)
	private String medicationName;
	@NotEmpty(message = ErrorConstants.DOSAGE_UNIT_VALUE_NOT_NULL)
	private String dosageUnitValue;
	@NotEmpty(message = ErrorConstants.DOSAGE_UNIT_NAME_NOT_NULL)
	private String dosageUnitName;
	@NotEmpty(message = ErrorConstants.DOSAGE_FREQUENCY_NAME_NOT_NULL)
	private String dosageFrequencyName;
	private String instructionNote;
	@NotEmpty(message = ErrorConstants.DOSAGE_FORM_NAME_NOT_NULL)
	private String dosageFormName;
	private Boolean isActive;
	private Boolean isDeleted;
	private Date prescribedSince;
	private Integer prescriptionRemainingDays;
}
