package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import com.mdtlabs.coreplatform.common.model.entity.spice.PatientLabTest;

import lombok.Data;

@Data
public class RequestDTO extends CommonRequestDTO {

	private Long prescriptionId;

	private boolean isLatestRequired;

	private String searchTerm;

	private int limit;

	private int pageNumber;

	private int skip;

	private int sortOrder;

	private String sortField;

	private Map<String, Object> sort;

	private Long countryId;

	private Long operatingUnitId;

	private Long accountId;

	private Long siteId;

	private boolean isPaginated;

	private String type;

	private String category;

	private String searchId;

	private boolean isSearchUserOrgPatient;

	private PatientFilterDTO patientFilterDTO;

	private PatientSortDTO patientSortDTO;

	private boolean isAssessmentDataRequired;

	private List<PatientLabTest> labTest;


	private boolean isDetailedSummaryRequired;

	private String discontinuedReason;
	private Boolean isActive;

    private boolean isMedicalReviewSummary;

	private Long patientTrackerId;

	private Boolean isDeleted = false;
    private Long screeningId;
    private String reason;
    private String status;
	private Long tenantId;
}
