package com.mdtlabs.coreplatform.common.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtlabs.coreplatform.common.logger.Logger;
import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;
import com.mdtlabs.coreplatform.common.repository.GenericRepository;
import com.mdtlabs.coreplatform.common.service.GenericService;

/**
 * <p>
 * This service class contain all the business logic and perform all the
 * operation here.
 * </p>
 * 
 * @author Prabu created on Oct 20, 2022
 */
@Service
public class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

	@Autowired
	private GenericRepository<T> genericRepository;

	@Override
	public List<T> findAll() throws Exception {
		try {
			return genericRepository.findAll();
		} catch (Exception exception) {
			Logger.logError(exception);
			throw exception;
		}
	}

	@Override
	public T findById(Long id) throws Exception {
		try {
			Optional<T> entity = genericRepository.findById(id);
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
			return genericRepository.save(entity);
		} catch (Exception exception) {
			Logger.logError(exception);
			throw exception;
		}
	}

}
