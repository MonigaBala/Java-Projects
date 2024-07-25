package com.voterapp.exceptions;

/**
 * NotEligibleException is a custom exception used to indicate that a user is
 * not eligible for a certain operation or process within the voter application.
 * 
 * This base exception can be extended by other specific exceptions to provide
 * more detailed reasons for ineligibility. It provides two constructors: - A
 * default constructor that initializes the exception without a message. - A
 * constructor that accepts a custom message to provide more context about the
 * reason for the exception.
 * 
 * By using this custom exception, the voter application can handle various
 * ineligibility scenarios in a consistent and informative manner.
 * 
 * @see Exception
 * @see LocalityNotFoundException
 * @see UnderAgeException
 * @see NoVoterIDException
 * 
 * @author MonigaBalasubramanian
 */
public class NotEligibleException extends Exception {

	/**
	 * static final variable long serialVersionUID is declared.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor() to initialize the exception without a message.
	 */
	public NotEligibleException() {
		super();
	}

	/**
	 * Constructor with a parameter of type String to initialize the exception with
	 * a custom message.
	 * 
	 * @param message the detail message explaining the reason for the exception.
	 */
	public NotEligibleException(String message) {
		super(message);
	}

}
