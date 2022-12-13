package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.EmailTemplateValue;

import lombok.Data;

@Data
public class EmailTemplateDTO {
	
	private long id;

	private String type;

	private String vmContent;

	private String body;

	private String title;

	private String appUrl;

	private List<EmailTemplateValueDTO> emailTemplateValues;


}
