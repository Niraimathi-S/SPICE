package com.mdtlabs.coreplatform.common.model.entity.spice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mdtlabs.coreplatform.common.ErrorConstants;
import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.TableConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = TableConstants.TABLE_REGION_CUSTOMISATION)
public class RegionCustomization extends TenantBaseEntity {

    private static final long serialVersionUID = -8642271760727722638L;

    @NotBlank(message = ErrorConstants.TYPE_NOT_NULL)
    @Column(name = FieldConstants.TYPE)
    private String type;

    @NotBlank(message = ErrorConstants.CATEGORY_NOT_NULL)
    @Column(name = FieldConstants.CATEGORY)
    private String category;

    @NotBlank(message = ErrorConstants.FORM_INPUT_NOT_NULL)
    @Column(name = FieldConstants.FORM_INPUT)
    private String formInput;

    @NotNull(message = ErrorConstants.COUNTRY_ID_NOT_NULL)
    @Column(name = FieldConstants.COUNTRY_ID)
    private Long countryId;

    @Column(name = FieldConstants.IS_DELETED)
    private Boolean isDeleted = false;

    @Column(name = FieldConstants.IS_ACTIVE)
    private Boolean isActive = true;

}
