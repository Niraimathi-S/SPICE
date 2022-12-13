package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class MentalHealthDetailsDTO {
	
    private Long questionId;

    private Long answerId;

    private int displayOrder;

    private int score;


}
