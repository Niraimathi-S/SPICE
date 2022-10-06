package com.mdtlabs.coreplatform.common.exception;

import java.util.List;

/**
 * This class is used to validate all the validation code.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class Validation extends ServicesException {

	public Validation() {
		this(1001, Validation.class.getSimpleName());
	}

	public Validation(final Integer code) {
		this(code, Validation.class.getSimpleName());
	}

	public Validation(final Integer code, final String... params) {
		super(code, params);
	}

	public Validation(final Integer code, final String message) {
		super(code, message);
	}

	public Validation(final Integer code, final List<String> params) {
		super(code, params);
	}
}
