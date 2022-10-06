package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class LifestyleDTO {

    private Long lifestyleId;

    private Boolean isAnswerDependent;
    
    private String comments;
    
    private String lifestyleAnswer;

}
