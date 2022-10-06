package com.mdtlabs.coreplatform.common.authentications;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * TenantAuthenticationToken is used to authenticate tenan token
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class TenantAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final List<Integer> tenantIds;
    private final int roleId;

    public TenantAuthenticationToken(Object principal, int roleId, Collection<? extends GrantedAuthority> authorities, List<Integer> tenantIds) {
        super(authorities);
        setAuthenticated(true);
        this.principal = principal;
        this.roleId = roleId;
        this.tenantIds = tenantIds;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public List<Integer> getTenantIds() {
        return this.tenantIds;
    }

    public int getRoleId() {
        return this.roleId;
    }
}