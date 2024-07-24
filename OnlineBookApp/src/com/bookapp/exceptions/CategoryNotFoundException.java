/**
 * Package that contains different Custom Exceptions that deals different Exceptions.
 */
package com.bookapp.exceptions;

/**
 * Custom Exception CategoryNotFoundException.
 * 
 * @author MonigaBalasubramanian
 * @extends Exception Class
 */
public class CategoryNotFoundException extends Exception {

	/**
	 * A static and final variable serialVersionUID is defined.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor is used to initialize the member.
	 */
	public CategoryNotFoundException() {
		super();
	}

	/**
	 * Constructor with a String message.
	 * 
	 * @param message
	 */
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
