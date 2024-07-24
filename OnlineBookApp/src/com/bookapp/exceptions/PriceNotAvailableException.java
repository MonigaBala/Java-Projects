/**
 * Package that contains different Custom Exceptions that deals different Exceptions.
 */
package com.bookapp.exceptions;

/**
 * Custom exception PriceNotAvailableException.
 * 
 * @author MonigaBalasubramanian
 * @extends Exception Class
 */
public class PriceNotAvailableException extends Exception {

	/**
	 * A static and final variable serialVersionUID is defined.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor is used to initialize the member.
	 */
	public PriceNotAvailableException() {
		super();
	}

	/**
	 * Constructor with a String message.
	 * 
	 * @param message
	 */
	public PriceNotAvailableException(String message) {
		super(message);
	}
}
