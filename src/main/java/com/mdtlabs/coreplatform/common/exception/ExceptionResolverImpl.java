package com.mdtlabs.coreplatform.common.exception;

import org.springframework.http.HttpStatus;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.logger.Logger;

import java.time.ZonedDateTime;

/**
 * <p>
 * This service class contain all the business logic for exception resolver
 * module and perform all the user operation here.
 * </p>
 * 
 * @author VigneshKumar created on Jun 30, 2022
 */
public class ExceptionResolverImpl implements ExceptionResolver {

	/**
	 * {@inheritDoc}
	 */
	public ErrorMessage resolveError(final HttpStatus statusCode, final String msg) {
		Logger.logInfo(Constants.RESOLVER_ERROR + msg);
		final ErrorMessage.Builder builder = new ErrorMessage.Builder();
		builder.setDateTime(ZonedDateTime.now().toInstant().toEpochMilli());

		Logger.logInfo(Constants.RESOLVER_ERROR + msg);

		builder.setErrorCode(statusCode.value());
		builder.setMessage(msg);
		builder.setException(msg);
		builder.setStatus(Boolean.FALSE);
		return builder.build();
	}

}
