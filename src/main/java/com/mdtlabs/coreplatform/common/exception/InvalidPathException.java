package com.mdtlabs.coreplatform.common.exception;

import java.util.List;

/**
 * This class is used to handle InvalidPathException.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class InvalidPathException extends ServicesException {

	public InvalidPathException() {
		this(1001, InvalidPathException.class.getSimpleName());
	}

	public InvalidPathException(final Integer code) {
		this(code, InvalidPathException.class.getSimpleName());
	}

	public InvalidPathException(final Integer code, final String... params) {
		super(code, params);
	}

	public InvalidPathException(final Integer code, final String message) {
		super(code, message);
	}

	public InvalidPathException(final Integer code, final List<String> params) {
		super(code, params);
	}
}
