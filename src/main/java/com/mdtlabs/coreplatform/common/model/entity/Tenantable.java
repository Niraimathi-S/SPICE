package com.mdtlabs.coreplatform.common.model.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import com.mdtlabs.coreplatform.common.listeners.TenantEntityListener;
import com.mdtlabs.coreplatform.common.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * <p>
 * This class is for tenant entity
 * </p>
 * 
 * @author Vignesh created on July 30 2022
 */
@Data
@MappedSuperclass
@FilterDef(name = Constants.TENANT_FILTER_NAME,
        parameters = @ParamDef(name = Constants.TENANT_PARAMETER_NAME, type = Constants.TENANT_PARAMETER_TYPE),
        defaultCondition = Constants.TENANT_COLUMN_NAME + " in (:" + Constants.TENANT_PARAMETER_NAME + ")")
@Filter(name = Constants.TENANT_FILTER_NAME)
@EntityListeners(TenantEntityListener.class)
public class Tenantable {

    @JsonIgnore
    @Column(name = Constants.TENANT_ID, nullable = false)
    private int tenantId;
}