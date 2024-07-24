/**
 * Package encloses different custom exceptions that may occur in the service package.
 */
package com.voterapp.exceptions;

/**
 * Custom Exception named LocalityNotFoundException.
 * 
 * @author MonigaBalasubramanian
 */
public class LocalityNotFoundException extends NotEligibleException {

	/**
	 * static final variable long serialVersionUID is declared.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor() to initialize the field members.
	 */
	public LocalityNotFoundException() {
		super();
	}

	/**
	 * Constructor with a parameter of type String is passed to initialize.
	 * 
	 * @param message
	 */
	public LocalityNotFoundException(String message) {
		super(message);
	}

}
