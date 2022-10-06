package com.mdtlabs.coreplatform.common.exception;

import java.util.List;

/**
 * This class is used to handle SendMailException.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class SendMailException extends ServicesException {

	public SendMailException() {
		this(1001, SendMailException.class.getSimpleName());
	}

	public SendMailException(final Integer code) {
		this(code, SendMailException.class.getSimpleName());
	}

	public SendMailException(final Integer code, final String... params) {
		super(code, params);
	}

	public SendMailException(final Integer code, final String message) {
		super(code, message);
	}

	public SendMailException(final Integer code, final List<String> params) {
		super(code, params);
	}
}
