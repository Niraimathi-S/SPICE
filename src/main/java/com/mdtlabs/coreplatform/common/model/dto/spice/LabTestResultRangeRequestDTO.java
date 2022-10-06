package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.io.Serializable;
import java.util.List;

import lombok.*;
import org.springframework.validation.annotation.*;

import javax.validation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class LabTestResultRangeRequestDTO extends CommonRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5972366800870662104L;

	private Long labTestResultId;

	@Valid
	private List<LabTestResultRangeDTO> labTestResultRanges;

}
