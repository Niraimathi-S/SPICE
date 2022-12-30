package com.mdtlabs.coreplatform.common.model.dto.spice;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PaginateDTO {

	private String searchTerm;

	private int limit;

	private int pageNumber;
	
	private int skip;

	private Map<String, String> sort;
}
