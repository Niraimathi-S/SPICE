package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.Country;

import lombok.Data;

/**
 * <p>
 * State class to get the notification entity.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_STATE)
public class State {

	@Id
	@Column(name = FieldConstants.ID)
	private long id;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Column(name = FieldConstants.IS_ACTIVE)
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = FieldConstants.COUNTRY_ID)
	private Country country;
}
