package com.mdtlabs.coreplatform.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mdtlabs.coreplatform.common.logger.Logger;
import com.mdtlabs.coreplatform.common.util.StringUtil;

/**
 * This class is used to handle TeleCounselorException.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	private ExceptionResolver resolver;

	@PostConstruct
	public final void initiateErrorCodeToResolver() {
		resolver = new ExceptionResolverImpl();
	}

	/**
	 * This method is used to handle runtime exception
	 * 
	 * @param runtimeException run time exception
	 * @return ErrorMessage - error trace message
	 */
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(value = InvalidPathException.class)
	@ResponseBody
	public ErrorMessage runtimeExceptionHandler(RuntimeException runtimeException) {
		Logger.logError(StringUtil.constructString(runtimeException.getClass().getName(),
				ExceptionConstants.MESSAGE_GENERIC, getErrorStackString(runtimeException)));

		return resolver.resolveError(HttpStatus.INTERNAL_SERVER_ERROR, runtimeException.getMessage());
	}

	/**
	 * This method is used to handle bad request
	 * 
	 * @param servicesException - services exception
	 * @return ErrorMessage - error trace message
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ServicesException.class)
	@ResponseBody
	protected final ErrorMessage handleException(ServicesException servicesException) {
		Logger.logError(StringUtil.constructString(servicesException.getClass().getName(),
				ExceptionConstants.MESSAGE_GENERIC, getErrorStackString(servicesException)));

		return resolver.resolveError(HttpStatus.BAD_REQUEST, servicesException.getMessage());
	}

	/**
	 * This method is used to handle internal server error
	 * 
	 * @param exception- passing exception
	 * @return ErrorMessage - error trace message
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorMessage exceptionHandler(Exception exception) {
		Logger.logError(StringUtil.constructString(exception.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
		    getErrorStackString(exception)));

		return resolver.resolveError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
	}

	/**
	 * This method is used to get error stack
	 * 
	 * @param error - passing error
	 * @return ErrorMessage - error trace message
	 */
	private String getErrorStackString(Exception error) {
		StringWriter writer = new StringWriter();
		error.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}

	/**
	 * This method is used to handle internal server error
	 * 
	 * @param exception- passing exception
	 * @return ErrorMessage - error trace message
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = Unauthorized.class)
	@ResponseBody
	public ErrorMessage authExceptionHandler(Exception exception) {
		Logger.logError(StringUtil.constructString(exception.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
				getErrorStackString(exception)));

		return resolver.resolveError(HttpStatus.UNAUTHORIZED, exception.getMessage());
	}
}
