package com.smsapp.services.interfaces;

import java.sql.Date;
import java.util.List;

import com.smsapp.exceptions.ExamNotFoundException;
import com.smsapp.model.Exam;
import com.smsapp.model.Student;
import com.smsapp.model.Teacher;

/**
 * Provides methods for managing exam-related operations in the School
 * Management System.
 * 
 * <p>
 * This interface defines the CRUD operations and additional methods for
 * handling exam data. Implementations of this interface should provide the
 * actual logic for interacting with the exam data in the database.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public interface IExam {

	/**
	 * Adds a new exam to the system.
	 * 
	 * @param exam the {@link Exam} object to be added
	 * @throws IllegalArgumentException if the exam object is null
	 */
	void addExam(Exam exam);

	/**
	 * Retrieves an exam by its unique ID.
	 * 
	 * @param examId the unique identifier of the exam
	 * @return the {@link Exam} object with the specified ID
	 * @throws ExamNotFoundException if no exam with the specified ID is found
	 */
	Exam getExamById(int examId) throws ExamNotFoundException;

	/**
	 * Retrieves a list of all exams in the system.
	 * 
	 * @return a {@link List} of {@link Exam} objects
	 */
	List<Exam> getAllExams();

	/**
	 * Updates the details of an existing exam.
	 * 
	 * @param exam the {@link Exam} object containing updated information
	 * @throws ExamNotFoundException    if the exam with the specified ID does not
	 *                                  exist
	 * @throws IllegalArgumentException if the exam object is null
	 */
	void updateExam(Exam exam) throws ExamNotFoundException;

	/**
	 * Deletes an exam from the system by its unique ID.
	 * 
	 * @param examId the unique identifier of the exam to be deleted
	 * @throws ExamNotFoundException if no exam with the specified ID is found
	 */
	void deleteExam(int examId) throws ExamNotFoundException;

	/**
	 * Assigns a list of students to an exam.
	 * 
	 * @param examId     the unique identifier of the exam
	 * @param studentIds a {@link List} of student IDs to be assigned to the exam
	 * @throws ExamNotFoundException    if no exam with the specified ID is found
	 * @throws IllegalArgumentException if the list of student IDs is null
	 */
	void assignStudentsToExam(int examId, List<Integer> studentIds) throws ExamNotFoundException;

	/**
	 * Assigns a list of teachers to an exam.
	 * 
	 * @param examId     the unique identifier of the exam
	 * @param teacherIds a {@link List} of teacher IDs to be assigned to the exam
	 * @throws ExamNotFoundException    if no exam with the specified ID is found
	 * @throws IllegalArgumentException if the list of teacher IDs is null
	 */
	void assignTeachersToExam(int examId, List<Integer> teacherIds) throws ExamNotFoundException;

	/**
	 * Retrieves a list of students assigned to an exam.
	 * 
	 * @param examId the unique identifier of the exam
	 * @return a {@link List} of {@link Student} objects assigned to the exam
	 * @throws ExamNotFoundException if no exam with the specified ID is found
	 */
	List<Student> getStudentsByExamId(int examId) throws ExamNotFoundException;

	/**
	 * Retrieves a list of teachers assigned to an exam.
	 * 
	 * @param examId the unique identifier of the exam
	 * @return a {@link List} of {@link Teacher} objects assigned to the exam
	 * @throws ExamNotFoundException if no exam with the specified ID is found
	 */
	List<Teacher> getTeachersByExamId(int examId) throws ExamNotFoundException;

	/**
	 * Deletes all relationships between an exam and its assigned students and
	 * teachers.
	 * 
	 * @param examId the unique identifier of the exam
	 * @throws ExamNotFoundException if no exam with the specified ID is found
	 */
	void deleteExamRelations(int examId) throws ExamNotFoundException;

	/**
	 * Retrieves a list of exams associated with a specific student.
	 * 
	 * @param studentId the unique identifier of the student
	 * @return a {@link List} of {@link Exam} objects associated with the student
	 */
	List<Exam> getExamsByStudentId(int studentId);

	/**
	 * Retrieves a list of exams scheduled for a specific date.
	 * 
	 * @param examDate the date of the exams
	 * @return a {@link List} of {@link Exam} objects scheduled for the specified
	 *         date
	 */
	List<Exam> getExamsByDate(Date examDate);

	/**
	 * Calculates the total marks obtained by a student across all exams.
	 * 
	 * @param studentId the unique identifier of the student
	 * @return the total marks obtained by the student
	 */
	double calculateTotalExamMarksForStudent(int studentId);

}
