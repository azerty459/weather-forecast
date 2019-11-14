package com.nextoo.meteo.exception;

public class ApiException extends Exception {

	private static final long serialVersionUID = -3448413386314027511L;

	public ApiException() {
		super();
	}

	public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

}
