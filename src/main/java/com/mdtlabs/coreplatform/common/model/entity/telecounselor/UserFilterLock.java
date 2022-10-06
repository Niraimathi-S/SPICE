package com.mdtlabs.coreplatform.common.model.entity.telecounselor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.telecounselor.TelecounselorConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for patient filter table.
 * </p>
 * 
 * @author TamilarasiShanmugasundaram created on Sep 01, 2022
 */
@Data
@Entity
@Table(name = Constants.TABLE_USER_FILTER_LOCK)
public class UserFilterLock {

	@Id
	@Column(name = Constants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = Constants.USER_ID, unique = true)
	private long userId;

	@Column(name = TelecounselorConstants.FILTER_VALUES)
	private String filterValues;

	@Column(name = Constants.CREATED_BY)
	private long createdBy;

	@Column(name = Constants.CREATED_AT, columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;
}
