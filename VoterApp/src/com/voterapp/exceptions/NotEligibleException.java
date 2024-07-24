/**
 * Package encloses different custom exceptions that may occur in the service package.
 */
package com.voterapp.exceptions;

/**
 * Custom Exception named NotEligibleException.
 * 
 * @author MonigaBalasubramanian
 */
public class NotEligibleException extends Exception {

	/**
	 * static final variable long serialVersionUID is declared.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor() to initialize the field members.
	 */

	public NotEligibleException() {
		super();
	}

	/**
	 * Constructor with a parameter of type String is passed to initialize.
	 * 
	 * @param message
	 */
	public NotEligibleException(String message) {
		super(message);
	}

}
