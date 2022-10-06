package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * The persistent class for the city table in the database.
 * 
 * @author vigneshKumar created on Jun 30, 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_DISTRICT)
public class District {

	@Id
	@Column(name = FieldConstants.ID)
	private long id;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Column(name = FieldConstants.IS_ACTIVE)
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = FieldConstants.STATE_ID)
	private State state;
}
