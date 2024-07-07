package com.voterapp.exceptions;

/**
 * Custom Exception named NotEligibleException.
 * 
 * @author MonigaBalasubramanian
 */
public class NotEligibleException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEligibleException() {
		super();
	}

	public NotEligibleException(String message) {
		super(message);
	}

}
