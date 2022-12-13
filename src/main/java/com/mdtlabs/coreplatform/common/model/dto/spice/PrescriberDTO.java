package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.Date;

import lombok.Data;

@Data
public class PrescriberDTO {

	public String firstName;
	public String lastName;
	public String countryCode;
	public String phoneNumber;
	public Date lastRefillDate;
	public long lastRefillVisitId;

}
