package com.mdtlabs.coreplatform.common.model.dto;

import java.io.Serializable;
import java.util.List;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.model.entity.EmailTemplate;
import com.mdtlabs.coreplatform.common.model.entity.EmailTemplateValue;
import com.mdtlabs.coreplatform.common.model.entity.Notification;

import lombok.Data;

/**
 * This is a DTO class for email entity.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
@SuppressWarnings(Constants.SERIAL)
@Data
public class EmailDTO implements Serializable {

	private String from;

	private String fromName;

	private String to;

	private String cc;

	private String bcc;

	private String subject;

	private String body;

	private String type;

	private Notification notification;

	private String toMails;

	private EmailTemplate emailTemplate;

	private boolean isHaveAttachment = false;

	private List<String> fileNames;

	private List<EmailTemplateValue> emailTemplateValues;

	private String vmContent;
	
	private String ccMails;
	
	private String bccMails;
	
	private long formDataId;

	private String formName;
	
	public EmailDTO() {

	}
	
	public EmailDTO(String to, String cc, String bcc, String subject, String body) {
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
	}

	public EmailDTO(String subject, String body, String to) {
		this.subject = subject;
		this.body = body;
		this.to = to;
	}

	public EmailDTO(String subject, String body, String to, String from) {
		this.subject = subject;
		this.body = body;
		this.to = to;
		this.from = from;
	}

}
