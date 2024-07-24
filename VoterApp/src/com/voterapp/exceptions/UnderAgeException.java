/**
 * Package encloses different custom exceptions that may occur in the service package.
 */
package com.voterapp.exceptions;

/**
 * Custom Exception named UnderAgeException.
 * 
 * @author MonigaBalasubramanian
 */
public class UnderAgeException extends NotEligibleException {

	/**
	 * static final variable long serialVersionUID is declared.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor() to initialize the field members.
	 */
	public UnderAgeException() {
		super();
	}

	/**
	 * Constructor with a parameter of type String is passed to initialize.
	 * 
	 * @param message
	 */
	public UnderAgeException(String message) {
		super(message);
	}

}
