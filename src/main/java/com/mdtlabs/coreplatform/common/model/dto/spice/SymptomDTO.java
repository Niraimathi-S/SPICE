package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import com.mdtlabs.coreplatform.common.ErrorConstants;

import javax.validation.constraints.*;

@Data
@Validated
public class SymptomDTO {

	private Long id;

	@NotNull(message = ErrorConstants.SYMPTOM_ID_NOT_NULL)
	private Long symptomId;

	@NotEmpty(message = ErrorConstants.SYMPTOM_NAME_NOT_NULL)
	private String name;

	@NotEmpty(message = ErrorConstants.TYPE_NOT_NULL)
	private String type;

	private String otherSymptom;
}