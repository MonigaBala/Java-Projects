package com.onlinebookapp.exceptions;

/**
 * Custom Exception named BookNotFoundException.
 * 
 * @author MonigaBalasubramanian
 */
public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String message) {
		super(message);
	}

}
