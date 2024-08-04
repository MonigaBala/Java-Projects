package com.smsapp.exceptions;

/**
 * Exception thrown when a student is not found in the system.
 * 
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to
 * indicate that a specific student could not be located in the database or
 * system. It provides constructors to allow for both default and custom error
 * messages.
 * </p>
 * 
 * <p>
 * This exception should be used in scenarios where an operation requires the
 * existence of a student, but the student with the specified identifier does
 * not exist. It can be used in service or DAO classes to signal an error
 * condition and handle it appropriately in the application.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code StudentNotFoundException} with {@code null} as its
	 * detail message. The cause is not initialized.
	 */
	public StudentNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code StudentNotFoundException} with the specified detail
	 * message. The cause is not initialized.
	 *
	 * @param message the detail message.
	 */
	public StudentNotFoundException(String message) {
		super(message);
	}

}
