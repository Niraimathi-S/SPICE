package com.mdtlabs.coreplatform.common.exception;

import org.springframework.http.HttpStatus;

/**
 * <p>
 * This an interface class for exception resolver you can implemented this class
 * in any class.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
public interface ExceptionResolver {

	/**
	 * This method is used to construct error resolver
	 * 
	 * @param statusCode - status code of error
	 * @param msg        - error trace
	 * @return ErrorMessage - error message builder
	 */
	ErrorMessage resolveError(final HttpStatus statusCode, final String msg);
}
