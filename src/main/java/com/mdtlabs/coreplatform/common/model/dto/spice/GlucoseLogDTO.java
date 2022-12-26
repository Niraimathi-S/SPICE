package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GlucoseLogDTO {

	private Long id;

	private Float hba1c;

	private String hba1cUnit;

	private String glucoseType;

	private Float glucoseValue;

	private Date lastMealTime;

	private Date glucoseDateTime;

	private String glucoseUnit;

	private String type;

	private Boolean isBeforeDiabetesDiagnosis;

	private Long glucoseId;

	private boolean isLatest;
	
	private Long patientTrackId;
	
	private boolean isUpdatedFromEnrollment;
	
	private Long screeningId;
	
	private Long tenantId;

	private Date createdAt;
    
    private List<String> symptomList;

	public GlucoseLogDTO(String glucoseType, Float glucoseValue, Date lastMealTime, Date glucoseDateTime,
							String glucoseUnit) {
		this.glucoseType = glucoseType;
		this.glucoseValue = glucoseValue;
		this.lastMealTime = lastMealTime;
		this.glucoseDateTime = glucoseDateTime;
		this.glucoseUnit = glucoseUnit;
	}

	public GlucoseLogDTO(String glucoseType, Float glucoseValue, String glucoseUnit) {
		this.glucoseType = glucoseType;
		this.glucoseValue = glucoseValue;
		this.glucoseUnit = glucoseUnit;
	}

	public GlucoseLogDTO() {
	}

	public GlucoseLogDTO(Long id, Float hba1c, String hba1cUnit, String glucoseType, Float glucoseValue,
			Date glucoseDateTime, String glucoseUnit, Date createdAt) {
		this.id = id;
		this.hba1c = hba1c;
		this.hba1cUnit = hba1cUnit;
		this.glucoseType = glucoseType;
		this.glucoseValue = glucoseValue;
		this.glucoseDateTime = glucoseDateTime;
		this.glucoseUnit = glucoseUnit;
		this.createdAt = createdAt;
	}   

}