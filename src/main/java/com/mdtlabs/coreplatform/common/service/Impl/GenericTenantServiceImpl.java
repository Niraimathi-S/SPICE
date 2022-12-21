package com.mdtlabs.coreplatform.common.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.logger.Logger;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;
import com.mdtlabs.coreplatform.common.repository.GenericTenantRepository;
import com.mdtlabs.coreplatform.common.service.GenericTenantService;

/**
 * <p>
 * This service class contain all the business logic and perform all the
 * operation here.
 * </p>
 * 
 * @author Niraimathi S created on Dec 20, 2022
 */
@Service
public class GenericTenantServiceImpl<T extends TenantBaseEntity> implements GenericTenantService<T> {
	@Autowired
	private GenericTenantRepository<T> genericTenantRepository;

	@Override
	public List<T> findAll() throws Exception {
		try {
			return genericTenantRepository.findAll();
		} catch (Exception exception) {
			Logger.logError(exception);
			throw exception;
		}
	}

	@Override
	public T findById(Long id) throws Exception {
		try {
			Optional<T> entity = genericTenantRepository.findById(id);
			if (!entity.isEmpty()) {
				return entity.get();
			} else {
				return null;
			}
		} catch (Exception exception) {
			Logger.logError(exception);
			throw exception;
		}
	}

	@Override
	public T save(T entity) throws Exception {
		try {
			return genericTenantRepository.save(entity);
		} catch (Exception exception) {
			Logger.logError(exception);
			throw exception;
		}
	}
}
