package com.mdtlabs.coreplatform.common.model.dto.spice;

import lombok.Data;

@Data
public class SmsDTO {

	String body;
	String subject;
	String toPhoneNo;
	String formName;
	String userName;
	long tenantId;
	long formDataId;
	long notificationId;
}
