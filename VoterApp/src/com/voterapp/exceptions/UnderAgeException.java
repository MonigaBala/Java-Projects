package com.voterapp.exceptions;

/**
 * Custom Exception named UnderAgeException.
 * 
 * @author MonigaBalasubramanian
 */
public class UnderAgeException extends NotEligibleException {

	private static final long serialVersionUID = 1L;

	public UnderAgeException() {
		super();
	}

	public UnderAgeException(String message) {
		super(message);
	}

}
