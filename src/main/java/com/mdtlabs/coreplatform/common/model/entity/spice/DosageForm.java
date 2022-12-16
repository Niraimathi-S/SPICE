package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_DOSAGE_FORM)
public class DosageForm extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.NAME)
	private String name;

	@Column(name = FieldConstants.IS_ACTIVE)
	private boolean isActive;

	@Column(name = FieldConstants.IS_DELETED)
	private boolean isDeleted;

	@Column(name = FieldConstants.DISPLAY_ORDER)
	private int displayOrder;
}
