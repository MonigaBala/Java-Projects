package com.bookapp.exceptions;

/**
 * Custom Exception TitleNotFoundException.
 * 
 * @author MonigaBalasubramanian
 */
public class TitleNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TitleNotFoundException() {
		super();
	}

	public TitleNotFoundException(String message) {
		super(message);
	}
}
