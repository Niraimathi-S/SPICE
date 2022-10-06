package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PregnancyRequestDTO {
    private List<String> diagnosis;
    private Date diagnosisTime;
    private Date estimatedDeliveryDate;
    private Integer gravida;
    private Boolean isOnTreatment;
    private Date lastMenstrualPeriodDate;
    private Integer parity;
    private Long patientTrackId;
    private Integer pregnancyFetusesNumber;
    private Float temperature;
    private Long tenantId;
    private String unitMeasurement;
    private Long patientPregnancyId; // for update request
}
