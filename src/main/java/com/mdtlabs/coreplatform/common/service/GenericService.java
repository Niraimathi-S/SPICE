package com.mdtlabs.coreplatform.common.service;

import java.util.List;

import com.mdtlabs.coreplatform.common.model.entity.BaseEntity;

/**
 * <p>
 * This an interface class in which you can implemented this class in any
 * class.
 * </p>
 * 
 * @author Prabu created on Oct 20, 2022
 */
public interface GenericService<T extends BaseEntity> {

	/**
	 * This method is used to get all entity values
	 * 
	 * @return List of entities
	 * @throws Exception
	 */
	List<T> findAll() throws Exception;

	/**
	 * This method is used to save the entity value
	 * 
	 * @param entity - value to be saved
	 * @return entity - saved entity
	 * @throws Exception
	 */
	T save(T entity) throws Exception;

	/**
	 * This method is used to fetch an entity
	 * 
	 * @param id - id of the entity to be fetched
	 * @return entity
	 * @throws Exception
	 */
	T findById(Long id) throws Exception;
	

}
