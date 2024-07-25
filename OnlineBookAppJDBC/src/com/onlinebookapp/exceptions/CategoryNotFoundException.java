package com.onlinebookapp.exceptions;

/**
 * Custom exception thrown when a category is not found in the system. This
 * exception extends the {@link java.lang.Exception} class, providing a more
 * specific type of exception for handling cases where a category cannot be
 * located.
 * 
 * <p>
 * The class includes two constructors:
 * </p>
 * <ul>
 * <li>A default constructor with no arguments</li>
 * <li>A constructor that accepts a message string to describe the error</li>
 * </ul>
 * 
 * <p>
 * The {@code serialVersionUID} is defined to maintain the version control of
 * serialized objects of this exception class. This helps ensure that a
 * serialized object matches the class definition during deserialization.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @see java.lang.Exception
 */
public class CategoryNotFoundException extends Exception {

	/**
	 * A unique identifier for this class used during serialization. This field is
	 * used to verify that the sender and receiver of a serialized object maintain
	 * serialization compatibility.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor that creates a new {@code CategoryNotFoundException} with
	 * no detail message. The detail message is initialized to {@code null}. This
	 * constructor is used when no specific error message is needed.
	 */
	public CategoryNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code CategoryNotFoundException} with the specified detail
	 * message. The detail message is a {@code String} that provides a description
	 * of the error. This constructor is useful for providing a specific error
	 * message when the exception is thrown.
	 * 
	 * @param message the detail message, which is saved for later retrieval by the
	 *                {@link #getMessage()} method
	 */
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
