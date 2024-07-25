package com.onlinebookapp.exceptions;

/**
 * This class represents a custom exception that is thrown when a requested book
 * cannot be found. It extends the {@code Exception} class to provide a specific
 * exception type for handling cases where a book is not found in the context of
 * an online book application.
 * <p>
 * This exception can be used to indicate errors in situations such as querying
 * for a book that does not exist in the database or attempting to access a book
 * that has been deleted or is otherwise unavailable.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class BookNotFoundException extends Exception {

	/**
	 * A unique identifier for this Serializable class. This value is used during
	 * the deserialization process to ensure that a loaded class corresponds to a
	 * serialized object. If the classes do not match, it will result in an
	 * {@code InvalidClassException}.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code BookNotFoundException} with {@code null} as its
	 * detail message. The cause is not initialized and may be initialized by
	 * calling {@link #initCause(Throwable)}. This default constructor is intended
	 * for use when the exception is thrown without a specific error message.
	 */
	public BookNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code BookNotFoundException} with the specified detail
	 * message. The cause is not initialized and may be initialized by calling
	 * {@link #initCause(Throwable)}.
	 * 
	 * @param message the detail message which is saved for later retrieval by the
	 *                {@link #getMessage()} method. It provides more information
	 *                about the reason for the exception.
	 */
	public BookNotFoundException(String message) {
		super(message);
	}

}
