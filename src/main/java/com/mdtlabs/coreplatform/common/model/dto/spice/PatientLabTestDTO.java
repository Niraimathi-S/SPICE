package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.ErrorConstants;

@Data
public class PatientLabTestDTO extends CommonRequestDTO {

	@NotNull(message = ErrorConstants.IS_REVIEWED_NOT_NULL)
	private Boolean isReviewed;

	@NotNull(message = ErrorConstants.LABTEST_ID_NOT_NULL)
	private String labTestId;

	private String labTestName;

	private Date referDateDisplay;

	private Long referredBy;

	private String referredByDisplay;

	private Date resultDate;

//    @NotNull(message = ErrorConstants.PATIENT_TRACK_ID_NOT_NULL)
	private Long patientTrackId;

	private Boolean isDeleted = Constants.BOOLEAN_FALSE;

	private Long resultUpdateBy;

}
