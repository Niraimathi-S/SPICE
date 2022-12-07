package com.mdtlabs.coreplatform.common.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * The persistent class for the Base Entity.
 * 
 * @author vigneshKumar created on Jun 30, 2022
 */
@Data
@MappedSuperclass
public class TenantBaseEntity extends Tenantable implements Serializable {

	private static final long serialVersionUID = 4174505913611242103L;

	@Id
	@Column(name = FieldConstants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = FieldConstants.CREATED_BY, updatable = false, nullable = false)
	private long createdBy = getUserValue();

	@Column(name = FieldConstants.UPDATED_BY, nullable = true)
	private long updatedBy = getUserValue();

	@Column(name = FieldConstants.CREATED_AT, columnDefinition = Constants.TIMESTAMP, nullable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;

	@Column(name = FieldConstants.UPDATED_AT, columnDefinition = Constants.TIMESTAMP)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updatedAt;

	@Column(name = FieldConstants.IS_ACTIVE)
	private boolean isActive;

	@Column(name = FieldConstants.IS_DELETED)
	private boolean isDeleted;

	/**
	 * Default Constructor
	 */
	public TenantBaseEntity() {

	}

	/**
	 * Constructor to set Id
	 */
	public TenantBaseEntity(long id) {
		this.id = id;
	}

	/**
	 * This method is used to get user value
	 * 
	 * @return String - user value
	 */
	@JsonIgnore
	public long getUserValue() {
		if (null != UserContextHolder.getUserDto()) {
			return UserContextHolder.getUserDto().getId();
		}
		return Constants.ZERO;
	}
}