package com.onlinebookapp.exceptions;

/**
 * Custom exception thrown when an author is not found in the system. This
 * exception extends the {@link java.lang.Exception} class to provide more
 * specific error handling for scenarios where an author cannot be located.
 * 
 * <p>
 * This class includes two constructors:
 * </p>
 * <ul>
 * <li>A default constructor with no arguments</li>
 * <li>A constructor that accepts a message string to describe the error</li>
 * </ul>
 * 
 * <p>
 * The {@code serialVersionUID} is defined to maintain the version control of
 * serialized objects of this exception class. It ensures that a loaded class
 * matches the serialized object during deserialization.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @see java.lang.Exception
 */
public class AuthorNotFoundException extends Exception {

	/**
	 * A unique identifier for this class used during serialization. This field is
	 * used to verify that the sender and receiver of a serialized object maintain
	 * serialization compatibility.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor that creates a new {@code AuthorNotFoundException} with
	 * no detail message. The detail message is initialized to {@code null}. This
	 * constructor is used when no specific error message is provided.
	 */
	public AuthorNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code AuthorNotFoundException} with the specified detail
	 * message. The detail message is a {@code String} that describes the reason for
	 * the exception. This constructor is useful when you want to provide a specific
	 * error message.
	 * 
	 * @param message the detail message, which is saved for later retrieval by the
	 *                {@link #getMessage()} method
	 */
	public AuthorNotFoundException(String message) {
		super(message);
	}
}
