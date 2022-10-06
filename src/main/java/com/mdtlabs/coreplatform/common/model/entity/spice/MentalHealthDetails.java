package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.io.Serializable;

import lombok.Data;

@Data
public class MentalHealthDetails implements Serializable {
    
    private Long questionId;

    private Long answerId;

    private int displayOrder;

    private int score;

}
