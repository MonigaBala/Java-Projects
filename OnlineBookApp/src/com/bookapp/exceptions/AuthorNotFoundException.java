/**
 * Package that contains different Custom Exceptions that deals different Exceptions.
 */
package com.bookapp.exceptions;

/**
 * Custom Exception AuthorNotFoundException.
 * 
 * @author MonigaBalasubramanian
 * @extends Exception Class
 */
public class AuthorNotFoundException extends Exception {

	/**
	 * A static and final variable serialVersionUID is defined.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor is used to initialize the member.
	 */
	public AuthorNotFoundException() {
		super();
	}

	/**
	 * Constructor with a String message.
	 * 
	 * @param message
	 */
	public AuthorNotFoundException(String message) {
		super(message);
	}
}
