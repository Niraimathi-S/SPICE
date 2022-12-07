package com.mdtlabs.coreplatform.common.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.CustomDateSerializer;
import com.mdtlabs.coreplatform.common.UserContextHolder;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * <p>
 * auditing the records on every update
 * </p>
 * 
 * @author Prabu created on July 11, 2022
 *
 */
@Data
@Entity
@Table(name = Constants.TABLE_AUDIT)
public class Audit implements Serializable {

	private static final long serialVersionUID = 4174505913611242103L;

	@Column(name = Constants.ENTITY)
	private String entity;

	@Column(name = Constants.ACTION)
	private String action;

	@Column(name = Constants.ENTITY_ID)
	private long entityId;

	@Column(name = Constants.COLUMN_NAME)
	private String columnName;

	@Column(name = Constants.OLD_VALUE)
	private String oldValue;

	@Column(name = Constants.NEW_VALUE)
	private String newValue;

	@Id
	@Column(name = Constants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = Constants.CREATED_BY, updatable = false, nullable = false)
	private long createdBy = getUserValue();

	@Column(name = Constants.UPDATED_BY, nullable = true)
	private long updatedBy = getUserValue();

	@Column(name = Constants.CREATED_AT, columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createdAt;

	@Column(name = Constants.UPDATED_AT, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updatedAt;

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