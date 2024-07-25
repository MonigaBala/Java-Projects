package com.onlinebookapp.exceptions;

/**
 * Custom exception thrown when the price of an item (e.g., a book) is not
 * available. This exception extends the {@link java.lang.Exception} class,
 * providing a specific exception type to handle cases where price information
 * is missing or cannot be retrieved.
 * 
 * <p>
 * The class includes two constructors:
 * </p>
 * <ul>
 * <li>A default constructor with no arguments.</li>
 * <li>A constructor that accepts a message string to describe the error.</li>
 * </ul>
 * 
 * <p>
 * The {@code serialVersionUID} is defined to maintain compatibility during
 * serialization. This unique identifier helps ensure that a serialized object
 * matches the class definition during deserialization, preventing version
 * conflicts.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @see java.lang.Exception
 */
public class PriceNotAvailableException extends Exception {

	/**
	 * A unique identifier for this class used during serialization. This field
	 * ensures that a serialized object matches the class definition during
	 * deserialization, helping to prevent version conflicts.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor that creates a new {@code PriceNotAvailableException}
	 * with no detail message. The detail message is initialized to {@code null}.
	 * This constructor is useful when no specific error message is needed.
	 */
	public PriceNotAvailableException() {
		super();
	}

	/**
	 * Constructs a new {@code PriceNotAvailableException} with the specified detail
	 * message. The detail message is a {@code String} that provides a description
	 * of the error. This constructor allows you to provide a specific message when
	 * the exception is thrown.
	 * 
	 * @param message the detail message, which is saved for later retrieval by the
	 *                {@link #getMessage()} method
	 */
	public PriceNotAvailableException(String message) {
		super(message);
	}
}
