package com.bookapp.exceptions;

/**
 * Custom exception thrown when a book title is not found in the system. This
 * exception extends the {@link java.lang.Exception} class, providing a more
 * specific type of exception for scenarios where a title cannot be located or
 * retrieved.
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
 * The {@code serialVersionUID} is defined to ensure compatibility during
 * serialization. This unique identifier helps to verify that a serialized
 * object matches the class definition during deserialization, thereby
 * preventing version conflicts.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @see java.lang.Exception
 */
public class TitleNotFoundException extends Exception {

	/**
	 * A unique identifier for this class used during serialization. This field
	 * ensures that a serialized object matches the class definition during
	 * deserialization, which helps to avoid version conflicts.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor that creates a new {@code TitleNotFoundException} with no
	 * detail message. The detail message is initialized to {@code null}. This
	 * constructor is useful when no specific error message is needed.
	 */
	public TitleNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code TitleNotFoundException} with the specified detail
	 * message. The detail message is a {@code String} that provides a description
	 * of the error. This constructor is useful for providing a specific message
	 * when the exception is thrown.
	 * 
	 * @param message the detail message, which is saved for later retrieval by the
	 *                {@link #getMessage()} method
	 */
	public TitleNotFoundException(String message) {
		super(message);
	}
}
