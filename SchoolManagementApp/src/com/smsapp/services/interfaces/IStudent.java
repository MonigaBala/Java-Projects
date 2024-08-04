package com.smsapp.services.interfaces;

import java.util.List;

import com.smsapp.exceptions.StudentNotFoundException;
import com.smsapp.model.Student;

/**
 * Provides methods for managing student-related operations in the School
 * Management System.
 * 
 * <p>
 * This interface defines the CRUD operations and additional methods for
 * handling student data. Implementations of this interface should provide the
 * actual logic for interacting with the student data in the database.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public interface IStudent {

	/**
	 * Adds a new student to the system.
	 * 
	 * @param student the {@link Student} object to be added
	 * @throws IllegalArgumentException if the student object is null
	 */
	void addStudent(Student student);

	/**
	 * Retrieves a student by their unique ID.
	 * 
	 * @param studentId the unique identifier of the student
	 * @return the {@link Student} object with the specified ID
	 * @throws StudentNotFoundException if no student with the specified ID is found
	 */
	Student getStudentById(int studentId) throws StudentNotFoundException;

	/**
	 * Retrieves a list of all students in the system.
	 * 
	 * @return a {@link List} of {@link Student} objects
	 */
	List<Student> getAllStudents();

	/**
	 * Updates the details of an existing student.
	 * 
	 * @param student the {@link Student} object containing updated information
	 * @throws StudentNotFoundException if the student with the specified ID does
	 *                                  not exist
	 * @throws IllegalArgumentException if the student object is null
	 */
	void updateStudent(Student student) throws StudentNotFoundException;

	/**
	 * Deletes a student from the system by their unique ID.
	 * 
	 * @param studentId the unique identifier of the student to be deleted
	 * @throws StudentNotFoundException if no student with the specified ID is found
	 */
	void deleteStudent(int studentId) throws StudentNotFoundException;

	/**
	 * Assigns a random house to a student.
	 * 
	 * @param studentId the unique identifier of the student
	 * @throws StudentNotFoundException if no student with the specified ID is found
	 */
	void assignRandomHouse(int studentId) throws StudentNotFoundException;

}
