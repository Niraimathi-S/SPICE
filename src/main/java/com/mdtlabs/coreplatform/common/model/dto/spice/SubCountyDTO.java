package com.mdtlabs.coreplatform.common.model.dto.spice;


import com.mdtlabs.coreplatform.common.model.entity.Country;
import com.mdtlabs.coreplatform.common.model.entity.County;

import lombok.Data;

@Data
public class SubCountyDTO {

    private long id;

    private Boolean isDeleted;

	private Boolean isActive;

	private String name;

	private int displayOrder;

	private Country country;

	private County county;
    
}
