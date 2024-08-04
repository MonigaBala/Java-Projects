package com.smsapp.exceptions;

/**
 * Exception thrown when a teacher is not found in the system.
 * 
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to
 * indicate that a specific teacher could not be located in the database or
 * system. It provides constructors to allow for both default and custom error
 * messages.
 * </p>
 * 
 * <p>
 * This exception should be used in scenarios where an operation requires the
 * existence of a teacher, but the teacher with the specified identifier does
 * not exist. It can be used in service or DAO classes to signal an error
 * condition and handle it appropriately in the application.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class TeacherNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code TeacherNotFoundException} with {@code null} as its
	 * detail message. The cause is not initialized.
	 */
	public TeacherNotFoundException() {
		super();
	}

	/**
	 * Constructs a new {@code TeacherNotFoundException} with the specified detail
	 * message. The cause is not initialized.
	 *
	 * @param message the detail message.
	 */
	public TeacherNotFoundException(String message) {
		super(message);
	}

}
