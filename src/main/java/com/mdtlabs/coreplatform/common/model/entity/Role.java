package com.mdtlabs.coreplatform.common.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>
 * User role for an employee is used to authorise.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */

@Data
@Entity
@Table(name = TableConstants.TABLE_ROLE)
public class Role extends BaseEntity implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 2254198222527717773L;

	@Column(name = FieldConstants.NAME)
	private String name;

	// @Column(name = FieldConstants.DESCRIPTION)
	// private String description;

	@Column(name = FieldConstants.LEVEL)
	private String level;

	


	/** 
	 * @return the name property (getAuthority required by Acegi's GrantedAuthority
	 *         interface)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Transient
	private String authority;

	public String getAuthority() {
		return getName();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof Role))
			return false;
		Role role = (Role) object;
		return this.getId() == role.getId();
	}
}
