package com.mdtlabs.coreplatform.common.model.dto.telecounselor;

import org.json.simple.JSONObject;

import lombok.Data;

/**
 * This is a DTO class for patient filter entity.
 * 
 * @author TamilarasiShanmugasundaram created on Sep 01, 2022
 */
@Data
public class UserFilterLockDTO {

	private long id;

	private long userId;

	private JSONObject filterValues;

}
