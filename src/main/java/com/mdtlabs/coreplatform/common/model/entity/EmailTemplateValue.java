package com.mdtlabs.coreplatform.common.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * <p>
 * This persistent class for email template value table.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_EMAIL_TEMPLATE_VALUE)
public class EmailTemplateValue {

	@Id
	@Column(name = FieldConstants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Transient
	private String value;

}
