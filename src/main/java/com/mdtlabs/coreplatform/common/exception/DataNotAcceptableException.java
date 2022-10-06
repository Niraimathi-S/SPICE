package com.mdtlabs.coreplatform.common.exception;

import java.util.*;

public class DataNotAcceptableException extends ServicesException {
    public DataNotAcceptableException() {
        this(1001, DataNotAcceptableException.class.getSimpleName());
    }

    public DataNotAcceptableException(final Integer code) {
        this(code, DataNotAcceptableException.class.getSimpleName());
    }

    public DataNotAcceptableException(final Integer code, final String... params) {
        super(code, params);
    }

    public DataNotAcceptableException(final Integer code, final String message) {
        super(code, message);
    }

    public DataNotAcceptableException(final Integer code, final List<String> params) {
        super(code, params);
    }

}
