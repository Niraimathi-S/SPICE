package com.mdtlabs.coreplatform.common.model.dto.spice;

import javax.persistence.Column;

import com.mdtlabs.coreplatform.common.FieldConstants;

import lombok.Data;

@Data
public class NotificationDTO {
	
	private Long id;
	
	private String toEmail;

	private String ccEmails;

	private String subject;

	private String body;

	private String status;


}
