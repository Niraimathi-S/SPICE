package com.mdtlabs.coreplatform.common.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for timezone table.
 * </p>
 * 
 * @author ArunKarthik created on Aug 2022
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_TIMEZONE)
public class Timezone extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.ABBREVIATION)
	private String abbreviation;

	@Column(name = FieldConstants.DESCRIPTION)
	private String description;

	@Column(name = FieldConstants.OFFSET)
	private String offset;

}
