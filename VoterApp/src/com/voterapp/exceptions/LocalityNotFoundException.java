package com.voterapp.exceptions;

/**
 * LocalityNotFoundException is thrown when a user's locality cannot be found in
 * the system. This exception extends NotEligibleException to indicate that the
 * user is not eligible to proceed due to their locality not being recognized.
 * 
 * This custom exception provides two constructors: - A default constructor that
 * initializes the exception without a message. - A constructor that accepts a
 * custom message to provide more context about the exception.
 * 
 * This exception is specifically used in the voter application to handle cases
 * where a user's locality is not found, ensuring that the application can
 * appropriately respond to such situations.
 * 
 * @see NotEligibleException
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
	 * @param message the detail message explaining the reason for the exception.
	 */
	public LocalityNotFoundException(String message) {
		super(message);
	}

}
