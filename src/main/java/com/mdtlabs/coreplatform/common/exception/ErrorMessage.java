package com.mdtlabs.coreplatform.common.exception;

import java.util.Objects;

/**
 * This class is used to handle error message.
 * 
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class ErrorMessage {

	private final long dateTime;
	private final Boolean status;
	private final Integer errorCode;
	private final String message;
	private final String exception;

	public ErrorMessage(final long dateTime, final Boolean status, final Integer errorCode, final String message,
			final String exception) {
		this.dateTime = dateTime;
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.exception = exception;
	}

	public Boolean getStatus() {
		return status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getException() {
		return exception;
	}

	public long getDateTime() {
		return dateTime;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return Boolean.TRUE;
		}
		if (o instanceof ErrorMessage) {
			final ErrorMessage error = (ErrorMessage) o;
			return Objects.equals(getStatus(), error.getStatus()) && getErrorCode() == error.getErrorCode()
					&& Objects.equals(getMessage(), error.getMessage()) && Objects.equals(getException(), error.getException());
		}

		return Boolean.FALSE;
	}


	@Override
	public int hashCode() {
		return Objects.hash(getDateTime(), getStatus(), getErrorCode(), getMessage(), getException());
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getStatus()).toString();
	}

	public static class Builder {

		private long dateTime;
		private Boolean status;
		private Integer errorCode;
		private String message;
		private String exception;

		public Builder() {
		}

		public Builder setDateTime(final long dateTime) {
			this.dateTime = dateTime;
			return this;
		}

		public Builder setStatus(final Boolean status) {
			this.status = status;
			return this;
		}

		public Builder setErrorCode(final Integer errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder setMessage(final String message) {
			this.message = message;
			return this;
		}

		public Builder setException(final String exception) {
			this.exception = exception;
			return this;
		}

		public ErrorMessage build() {
			return new ErrorMessage(this.dateTime, this.status, this.errorCode, this.message, this.exception);
		}
	}

}
