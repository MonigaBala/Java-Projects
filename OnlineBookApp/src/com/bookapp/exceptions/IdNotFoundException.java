package com.bookapp.exceptions;

/**
 * Custom exception thrown when an ID is not found in the system. This exception
 * extends the {@link java.lang.Exception} class to provide a more specific
 * exception type for handling scenarios where an ID (e.g., book ID, author ID)
 * cannot be located.
 * 
 * <p>
 * The class provides two constructors:
 * </p>
 * <ul>
 * <li>A default constructor with no arguments</li>
 * <li>A constructor that accepts a message string to describe the error</li>
 * </ul>
 * 
 * <p>
 * The {@code serialVersionUID} is defined to maintain serialization
 * compatibility. This unique identifier ensures that a serialized object
 * matches the class definition during deserialization.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @see java.lang.Exception
 */
public class IdNotFoundException extends Exception {

	/**
	 * A unique identifier for this class used during serialization. This field is
	 * used to ensure that a serialized object matches the class definition during
	 * deserialization, helping to prevent version conflicts.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor that creates a new {@code IdNotFoundException} with no
	 * detail message. The detail message is initialized to {@code null}. This
	 * constructor is used when no specific error message is needed.
	 */
	public IdNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code IdNotFoundException} with the specified detail
	 * message. The detail message is a {@code String} that provides a description
	 * of the error. This constructor is useful for providing a specific error
	 * message when the exception is thrown.
	 * 
	 * @param message the detail message, which is saved for later retrieval by the
	 *                {@link #getMessage()} method
	 */
	public IdNotFoundException(String message) {
		super(message);
	}
}
