package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.validation.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class LabTestResultRangeDTO {

	private long id;

	@NotNull(message = "Labtest result range minimum value should not be empty")
	private Integer minimumValue;

	@NotNull(message = "Labtest result range maximum value should not be empty")
	private Integer maximumValue;

	@NotBlank(message = "Labtest result range unit should not be empty")
	private String unit;

	@NotNull(message = "Labtest result range unit id should not empty")
	@Min(1)
	private Long unitId;

	@Min(1)
	@NotNull(message = "Labtest result range display order should not be empty")
	private Integer displayOrder;

	@NotBlank(message = "Labtest result range display name should not be empty")
	private String displayName;
}
