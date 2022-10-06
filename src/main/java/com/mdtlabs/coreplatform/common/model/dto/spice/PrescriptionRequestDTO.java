package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

import javax.validation.*;

@Data
public class PrescriptionRequestDTO {

	private Long patientTrackId;
	private Long patientVisitId;
	private Long tenantId;
	private String signature;
	private MultipartFile signatureFile;
	@Valid
	private List<PrescriptionDTO> prescriptionList;

}
