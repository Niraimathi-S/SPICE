package com.mdtlabs.coreplatform.common.util;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * Common class for pagination
 * 
 * @author Jeyaharini T A
 *
 */
public class Pagination  {

	public static Pageable setPagination(int skip, int limit, String fieldToSort, boolean sortByAscending) {
		int pageNumber = (0 != skip) ? (skip / limit) : 0;
		limit = 0 != limit ? limit : 10;
		return PageRequest.of(pageNumber, limit,
				(sortByAscending ? Sort.by(fieldToSort).ascending() : Sort.by(fieldToSort).descending()));
	}

	public static Pageable setPagination(int skip, int limit, List<Order> sorts) {
		int pageNumber = 0 != skip ? (skip / limit) : 0;
		limit = 0 != limit ? limit : 10;
		return PageRequest.of(pageNumber, limit, Sort.by(sorts));
	}

	public static Pageable setPagination(int skip, int limit) {
		int pageNumber;
		limit = 0 != limit ? limit : 10;
		pageNumber = skip / limit;
		// if (skip != 0) {
		// 	pageNumber = skip / limit;
		// } else {
		// 	pageNumber = 0;
		// }
		// pageNumber = 0 != pageNumber ? pageNumber : 0;
		return PageRequest.of(pageNumber, limit);
	}

	public static Pageable setPagination(int skip, int limit, Sort sort) {
		int pageNumber;
		limit = 0 != limit ? limit : 10;
		pageNumber = skip / limit;
		// if (skip != 0) {
		// 	pageNumber = skip / limit;
		// } else {
		// 	pageNumber = 0;
		// }
		// pageNumber = 0 != pageNumber ? pageNumber : 0;
		return PageRequest.of(pageNumber, limit, sort);
	}

}
