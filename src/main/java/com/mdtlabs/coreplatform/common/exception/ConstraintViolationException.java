package com.mdtlabs.coreplatform.common.exception;

import java.util.List;

public class ConstraintViolationException extends ServicesException {

	public ConstraintViolationException() {
		this(1001, ConstraintViolationException.class.getSimpleName());
	}

	public ConstraintViolationException(final Integer code) {
		this(code, ConstraintViolationException.class.getSimpleName());
	}

	public ConstraintViolationException(final Integer code, final String... params) {
		super(code, params);
	}

	public ConstraintViolationException(final Integer code, final String message) {
		super(code, message);
	}

	public ConstraintViolationException(final Integer code, final List<String> params) {
		super(code, params);
	}

}
