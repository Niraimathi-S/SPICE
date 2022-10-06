package com.mdtlabs.coreplatform.common.listeners;

import com.mdtlabs.coreplatform.common.model.entity.Tenantable;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * This class is for tenant entity listener
 * 
 * @author VigneshKumar created on Jun 30, 2022 
 *
 */
public class TenantEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(Object object) {
        if (object instanceof Tenantable) {
            ((Tenantable) object).setTenantId(UserSelectedTenantContextHolder.get());
        }
    }

    @PreRemove
    public void preRemove(Object object) {
        if (object instanceof Tenantable && ((Tenantable) object).getTenantId() != UserSelectedTenantContextHolder.get()) {
            throw new EntityNotFoundException();
        }
    }
}