package com.mdtlabs.coreplatform.common.model.entity.spice;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

/**
 * This class is an Entity for SideMenu  which is used to get menu option available for particular user roles.
 * 
 * @author Niraimathi S
 */
@Data
@Table(name = TableConstants.TABLE_SIDE_MENU)
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SideMenu extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = FieldConstants.ROLE_NAME)
	private String roleName;
	@Column(name = FieldConstants.MENU, columnDefinition = "jsonb")
	@Type(type = "jsonb")
	private Map<String, String> menus;
}
