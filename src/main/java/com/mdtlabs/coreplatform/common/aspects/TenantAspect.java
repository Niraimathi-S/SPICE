package com.mdtlabs.coreplatform.common.aspects;

import com.mdtlabs.coreplatform.common.annotations.DisableTenantFilter;
import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.contexts.UserContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserSelectedTenantContextHolder;
import com.mdtlabs.coreplatform.common.contexts.UserTenantsContextHolder;
import com.mdtlabs.coreplatform.common.model.dto.UserDTO;
import com.mdtlabs.coreplatform.common.model.entity.Organization;
import com.mdtlabs.coreplatform.common.model.entity.Role;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Session;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * TenantAspect to enable tenant flow
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 * 
 */
@Aspect
@Component
public class TenantAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Before("execution(* com.mdtlabs.coreplatform.common.repository.TenantableRepository+.find*(..))")
    public void beforeFindOfTenantableRepository(JoinPoint joinPoint) {
        entityManager.unwrap(Session.class).disableFilter(Constants.TENANT_FILTER_NAME);
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();    
        UserDTO userDto = UserContextHolder.getUserDto();
        if (!userDto.getIsSuperUser() &&
        		(AnnotationUtils.getAnnotation(methodSignature.getMethod(), DisableTenantFilter.class) == null))  {
            entityManager
                    .unwrap(Session.class)
                    .enableFilter(Constants.TENANT_FILTER_NAME)
                    //.setParameterList(Constants.TENANT_PARAMETER_NAME, UserTenantsContextHolder.get());
                    .setParameter(Constants.TENANT_PARAMETER_NAME, UserSelectedTenantContextHolder.get());
        }
    }
}