package com.mdtlabs.coreplatform.common.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.mdtlabs.coreplatform.common.Constants;

import lombok.Data;

/**
 * <p>
 * This class is an entity class for timezone table.
 * </p>
 * 
 * @author Prabu created on Dec 06 2022
 */
@Data
public class TimezoneDTO {

	private long id;

	private String offset;
	
}
