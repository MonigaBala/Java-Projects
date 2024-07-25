package com.voterapp.exceptions;

/**
 * UnderAgeException is a custom exception used to indicate that a user is not
 * eligible due to being under the required age limit. This exception extends
 * NotEligibleException to specify that the user is not eligible because they
 * are not old enough.
 * 
 * This exception provides two constructors: - A default constructor that
 * initializes the exception without a message. - A constructor that accepts a
 * custom message to provide more context about the reason for the exception.
 * 
 * This exception is specifically used in the voter application to handle cases
 * where a user attempts to perform an operation that requires a minimum age,
 * ensuring that the application can appropriately respond to such situations.
 * 
 * @see NotEligibleException
 * @author MonigaBalasubramanian
 */
public class UnderAgeException extends NotEligibleException {

	/**
	 * static final variable long serialVersionUID is declared.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor() to initialize the exception without a message.
	 */
	public UnderAgeException() {
		super();
	}

	/**
	 * Constructor with a parameter of type String to initialize the exception with
	 * a custom message.
	 * 
	 * @param message the detail message explaining the reason for the exception.
	 */
	public UnderAgeException(String message) {
		super(message);
	}

}
