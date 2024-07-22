package com.onlinebookapp.exceptions;

/**
 * Custom Exception named PriceNotAvailableException.
 * 
 * @author MonigaBalasubramanian
 */
public class PriceNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public PriceNotAvailableException() {
		super();
	}

	public PriceNotAvailableException(String message) {
		super(message);
	}

}
