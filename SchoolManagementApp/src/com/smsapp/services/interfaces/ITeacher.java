package com.smsapp.services.interfaces;

import java.util.List;

import com.smsapp.exceptions.TeacherNotFoundException;
import com.smsapp.model.Teacher;

/**
 * Provides methods for managing teacher-related operations in the School
 * Management System.
 * 
 * <p>
 * This interface defines the CRUD operations and additional methods for
 * handling teacher data. Implementations of this interface should provide the
 * actual logic for interacting with the teacher data in the database.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public interface ITeacher {

	/**
	 * Adds a new teacher to the system.
	 * 
	 * @param teacher the {@link Teacher} object to be added
	 * @throws IllegalArgumentException if the teacher object is null
	 */
	void addTeacher(Teacher teacher);

	/**
	 * Retrieves a teacher by their unique ID.
	 * 
	 * @param teacherId the unique identifier of the teacher
	 * @return the {@link Teacher} object with the specified ID
	 * @throws TeacherNotFoundException if no teacher with the specified ID is found
	 */
	Teacher getTeacherById(int teacherId) throws TeacherNotFoundException;

	/**
	 * Retrieves a list of all teachers in the system.
	 * 
	 * @return a {@link List} of {@link Teacher} objects
	 */
	List<Teacher> getAllTeachers();

	/**
	 * Updates the details of an existing teacher.
	 * 
	 * @param teacher the {@link Teacher} object containing updated information
	 * @throws TeacherNotFoundException if the teacher with the specified ID does
	 *                                  not exist
	 * @throws IllegalArgumentException if the teacher object is null
	 */
	void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

	/**
	 * Deletes a teacher from the system by their unique ID.
	 * 
	 * @param teacherId the unique identifier of the teacher to be deleted
	 * @throws TeacherNotFoundException if no teacher with the specified ID is found
	 */
	void deleteTeacher(int teacherId) throws TeacherNotFoundException;

	/**
	 * Assigns a list of students to a teacher.
	 * 
	 * @param teacherId  the unique identifier of the teacher
	 * @param studentIds a {@link List} of student IDs to be assigned to the teacher
	 * @throws TeacherNotFoundException if no teacher with the specified ID is found
	 * @throws IllegalArgumentException if the list of student IDs is null
	 */
	void assignStudentsToTeacher(int teacherId, List<Integer> studentIds) throws TeacherNotFoundException;

}
