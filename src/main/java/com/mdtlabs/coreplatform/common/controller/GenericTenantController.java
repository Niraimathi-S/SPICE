package com.mdtlabs.coreplatform.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mdtlabs.coreplatform.common.FieldConstants;
import com.mdtlabs.coreplatform.common.model.entity.TenantBaseEntity;
import com.mdtlabs.coreplatform.common.service.GenericTenantService;

/**
 * <p>
 * Generic Controller used to perform any action like read and write for tenant based entities.
 * </p>
 * 
 * @author Niraimathi S created on Dec 21, 2022
 */
@ResponseBody
public class GenericTenantController<T extends TenantBaseEntity> {
	@Autowired
	private GenericTenantService<T> genericTenantService;

	/**
	 * This method is used to add new entity
	 * 
	 * @param entity - entity to be saved
	 * @return ResponseEntity<Object> - entity response
	 */
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody T entity) {
		try {
			return new ResponseEntity<>(genericTenantService.save(entity), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method is used to select entity values
	 * 
	 * @return ResponseEntity<T> - entity object
	 */
	@GetMapping
	public ResponseEntity<T> findAll() {
		try {
			return new ResponseEntity(genericTenantService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method is used to get entity with respect to id
	 * 
	 * @param id - id of the entity
	 * @return ResponseEntity<T> - response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable(FieldConstants.ID) Long id) {
		try {
			T entity = genericTenantService.findById(id);
			if (entity != null) {
				return new ResponseEntity(entity, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
