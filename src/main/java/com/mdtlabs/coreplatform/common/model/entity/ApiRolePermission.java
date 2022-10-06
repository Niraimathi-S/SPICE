package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.Constants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for api role permission table.
 * </p>
 * 
 * @author Prabu created on Oct 10 2022
 */
@Data
@Entity
@Table(name = Constants.TABLE_API_ROLE_PERMISSION)
public class ApiRolePermission {

	@Id
	@Column(name = Constants.ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = Constants.METHOD)
	private String method;
	
	@Column(name = Constants.API)
	private String api;
	
	@Column(name = Constants.ROLES)
	private String roles;

}
