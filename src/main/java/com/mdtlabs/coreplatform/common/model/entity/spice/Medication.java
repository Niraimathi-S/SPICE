package com.mdtlabs.coreplatform.common.model.entity.spice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

/**
 * 
 * This Medication Class is used to get Medication Entity.
 * 
 * @author Niraimathi
 *
 */
@Data
@Entity
@Table(name = TableConstants.TABLE_MEDICATION_COUNTRY_DETAIL)
public class Medication extends BaseEntity {
    
	@NotBlank(message = ErrorConstants.MEDICATION_NAME_NOT_NULL)
	@Column(name = FieldConstants.MEDICATION_NAME)
	private String medicationName;
	
	@NotBlank(message = ErrorConstants.CLASSIFICATION_NAME_NOT_NULL)
	@Column(name = FieldConstants.CLASSIFICATION_NAME)
	private String classificationName;
	
	@NotBlank(message = ErrorConstants.BRAND_NAME_NOT_NULL)
	@Column(name = FieldConstants.BRAND_NAME)
	private String brandName;
	
	@NotBlank(message = ErrorConstants.DOSAGE_FORM_NAME_NOT_NULL)
	@Column(name = FieldConstants.DOSAGE_FORM_NAME)
	private String dosageFormName;

	@Column(name = FieldConstants.DOSAGE_UNIT_NAME)
	private String dosageUnitName;
	
	@NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
	@Column(name = FieldConstants.COUNTRY_ID)
	private Long countryId;

	@NotNull(message = ErrorConstants.CLASSIFICATION_ID_NOT_NULL)
	@Column(name = FieldConstants.CLASSIFICATION_ID)
	private Long classificationId;
	
	@NotNull(message = ErrorConstants.DOSAGE_FORM_ID_NOT_NULL)
	@Column(name = FieldConstants.DOSAGE_FORM_ID)
	private Long dosageFormId;

	@NotNull(message = ErrorConstants.BRAND_ID_NOT_NULL)
	@Column(name = FieldConstants.BRAND_ID)
	private Long brandId;

	@NotNull(message = ErrorConstants.TENANT_ID_NOT_NULL)
	@Column(name = FieldConstants.TENANT_ID)
	private Long tenantId;

	@Column(name = FieldConstants.DISPLAY_ORDER)
	private int displayOrder;

	@Column(name = FieldConstants.TYPE)
	private String type;

	@Column(name = FieldConstants.STATUS)
	private boolean status;


}
