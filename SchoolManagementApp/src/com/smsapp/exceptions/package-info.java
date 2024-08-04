/**
 * Contains custom exception classes for the School Management System
 * application.
 * 
 * <p>
 * This package provides custom exceptions that are used throughout the
 * application to handle specific error conditions related to the domain objects
 * of the school management system. These exceptions extend
 * {@link RuntimeException} to indicate exceptional conditions that are
 * unchecked. They help in providing meaningful error messages and handling
 * specific error cases such as when an entity is not found or a particular
 * operation fails.
 * </p>
 * 
 * <p>
 * The exceptions in this package include:
 * <ul>
 * <li>{@link com.smsapp.exceptions.StudentNotFoundException} - Thrown when a
 * student is not found.</li>
 * <li>{@link com.smsapp.exceptions.TeacherNotFoundException} - Thrown when a
 * teacher is not found.</li>
 * <li>{@link com.smsapp.exceptions.ExamNotFoundException} - Thrown when an exam
 * is not found.</li>
 * </ul>
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
package com.smsapp.exceptions;
