package com.mdtlabs.coreplatform.common.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * <p>
 * Notification class to get the notification entity.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@Entity
@Data
@Table(name = TableConstants.TABLE_NOTIFICATION)
public class Notification extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.TO_EMAIL)
	private String toEmail;

	@Column(name = FieldConstants.CC_EMAILS)
	private String ccEmails;

	@Column(name = FieldConstants.SUBJECT)
	private String subject;

	@Column(name = FieldConstants.BODY)
	private String body;

	@Column(name = FieldConstants.STATUS)
	private String status;

	public Notification() {

	}

	public Notification(String subject, String body, String toEmail) {
		this.subject = subject;
		this.body = body;
		this.toEmail = toEmail;
	}

}
