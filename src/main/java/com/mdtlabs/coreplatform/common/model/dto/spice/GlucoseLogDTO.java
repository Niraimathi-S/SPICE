package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GlucoseLogDTO {

	  private Integer hb1ac;

	    private String hb1acUnit;

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

	   

}