package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

/**
 * This class represents the CountryClassification entity. 
 * 
 * @author Niraimathi S
 *
 */
@Entity
@Table(name = TableConstants.TABLE_COUNTRY_CLASSIFICATION)
@Data
public class CountryClassification extends TenantBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = FieldConstants.CLASSIFICATION_ID)
	private Long classificatinId;
	
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;	
}
