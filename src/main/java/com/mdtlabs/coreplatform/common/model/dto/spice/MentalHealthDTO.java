package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mdtlabs.coreplatform.common.model.entity.spice.MentalHealthDetails;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MentalHealthDTO {

    private Long id;

    private List<MentalHealthDetails> phq9MentalHealth;

    private String phq9RiskLevel;

    private Integer phq9Score;

    private List<MentalHealthDetails> gad7MentalHealth;

    private String gad7RiskLevel;

    private Integer gad7Score;

    private List<MentalHealthDetails> phq4MentalHealth;

    private String phq4RiskLevel;

    private Integer phq4Score;
    
    private Integer phq4FirstScore;

    private Integer phq4SecondScore;

}
