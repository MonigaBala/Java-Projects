package com.onlinebookapp.exceptions;

/**
 * Custom Exception named IdNotFoundException.
 * 
 * @author MonigaBalasubramanian
 */
public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String message) {
		super(message);
	}

}
