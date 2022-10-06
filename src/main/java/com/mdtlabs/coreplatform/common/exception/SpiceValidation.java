package com.mdtlabs.coreplatform.common.exception;

import java.util.List;

public class SpiceValidation extends ServicesException {

	public SpiceValidation() {
		this(1001, SpiceValidation.class.getSimpleName());
	}

	public SpiceValidation(final Integer code) {
		this(code, SpiceValidation.class.getSimpleName());
	}

	public SpiceValidation(final Integer code, final String... params) {
		super(code, params);
	}

	public SpiceValidation(final Integer code, final String message) {
		super(code, message);
	}

	public SpiceValidation(final Integer code, final List<String> params) {
		super(code, params);
	}
}