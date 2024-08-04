package com.smsapp.services.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smsapp.dao.ConnectionBean;
import com.smsapp.exceptions.ExamNotFoundException;
import com.smsapp.model.Address;
import com.smsapp.model.BloodGroup;
import com.smsapp.model.Exam;
import com.smsapp.model.Gender;
import com.smsapp.model.Student;
import com.smsapp.model.Subject;
import com.smsapp.model.Teacher;
import com.smsapp.services.interfaces.IExam;
import com.smsapp.util.Queries;

/**
 * Provides implementations for the {@link IExam} interface, managing
 * exam-related operations. This class handles the creation, retrieval,
 * updating, and deletion of exam records in the database. It also manages
 * relationships between exams, students, and teachers.
 * <p>
 * The methods in this class use JDBC to interact with the database. It ensures
 * that the appropriate SQL queries are executed and handles potential SQL
 * exceptions that may occur during database operations.
 * </p>
 * <p>
 * Typical usage involves creating an instance of this class and invoking its
 * methods to perform operations such as adding a new exam, retrieving exam
 * details by ID, and listing all exams.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class ExamImpl implements IExam {

	/**
	 * Adds a new exam to the database.
	 *
	 * <p>
	 * This method inserts a new exam record into the database using the details
	 * provided in the {@link Exam} object. It generates a unique ID for the new
	 * exam, which is set in the {@link Exam} object upon successful insertion.
	 * </p>
	 *
	 * @param exam The {@link Exam} object containing the details of the exam to be
	 *             added. Must not be {@code null}.
	 * @throws IllegalArgumentException If the provided {@link Exam} object is
	 *                                  {@code null}.
	 * @throws RuntimeException         If there is an error during database access.
	 */
	@Override
	public void addExam(Exam exam) {
		String insertExamQuery = Queries.INSERT_EXAM;

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertExamQuery, Statement.RETURN_GENERATED_KEYS)) {

			// Setting parameters for the INSERT query
			pstmt.setString(1, exam.getExamName());
			pstmt.setDate(2, new java.sql.Date(exam.getExamDate().getTime()));
			pstmt.setString(3, exam.getSubject().getValue());

			// Executing the query
			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				// Retrieve generated examId if necessary
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int generatedExamId = generatedKeys.getInt(1);
						exam.setExamId(generatedExamId);
						System.out.println("Exam added successfully with ID: " + generatedExamId);
					}
				}
			} else {
				System.err.println("No rows affected. Exam was not added.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error adding exam.");
		}
	}

	/**
	 * Retrieves an exam by its ID.
	 *
	 * <p>
	 * This method queries the database for an exam with the specified ID. If the
	 * exam is found, it returns an {@link Exam} object populated with the exam
	 * details. The method also retrieves and sets the associated students and
	 * teachers for the exam.
	 * </p>
	 *
	 * @param examId The ID of the exam to retrieve.
	 * @return The {@link Exam} object with the specified ID.
	 * @throws ExamNotFoundException If no exam is found with the given ID.
	 * @throws RuntimeException      If there is an error during database access.
	 */
	@Override
	public Exam getExamById(int examId) throws ExamNotFoundException {
		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.SELECT_EXAM_BY_ID)) {

			pstmt.setInt(1, examId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Exam exam = new Exam();
					exam.setExamId(rs.getInt("exam_id"));
					exam.setExamName(rs.getString("exam_name"));
					exam.setExamDate(rs.getDate("exam_date"));

					// Handling enum conversion
					try {
						exam.setSubject(Subject.fromValue(rs.getString("subject")));
					} catch (IllegalArgumentException e) {
						System.err.println("Invalid subject value found in database: " + rs.getString("subject"));
						exam.setSubject(Subject.UNKNOWN); // Set a default or handle as needed
					}

					// Set associated students and teachers
					exam.setStudents(getStudentsByExamId(examId));
					exam.setTeachers(getTeachersByExamId(examId));

					return exam;
				} else {
					throw new ExamNotFoundException("Exam not found with ID: " + examId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving exam with ID: " + examId, e);
		}
	}

	/**
	 * Retrieves all exams from the database.
	 *
	 * <p>
	 * This method queries the database for all exam records and returns a list of
	 * {@link Exam} objects. Each {@link Exam} object is populated with its details,
	 * including associated students and teachers.
	 * </p>
	 *
	 * @return A list of all {@link Exam} objects.
	 * @throws RuntimeException If there is an error during database access.
	 */
	@Override
	public List<Exam> getAllExams() {
		List<Exam> exams = new ArrayList<>();
		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.SELECT_ALL_EXAMS);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Exam exam = new Exam();
				exam.setExamId(rs.getInt("exam_id"));
				exam.setExamName(rs.getString("exam_name"));
				exam.setExamDate(rs.getDate("exam_date"));

				// Handling enum conversion with updated method
				try {
					exam.setSubject(Subject.fromValue(rs.getString("subject")));
				} catch (IllegalArgumentException e) {
					System.err.println("Invalid subject value found in database: " + rs.getString("subject"));
					exam.setSubject(Subject.UNKNOWN); // Set a default or handle as needed
				}

				// Retrieve and set associated students and teachers
				exam.setStudents(getStudentsByExamId(exam.getExamId()));
				exam.setTeachers(getTeachersByExamId(exam.getExamId()));

				exams.add(exam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exams;
	}

	/**
	 * Updates the details of an existing exam.
	 *
	 * <p>
	 * This method updates the details of an exam in the database based on the
	 * information provided in the {@link Exam} object. The exam ID must be set in
	 * the {@link Exam} object to identify which exam to update.
	 * </p>
	 *
	 * @param exam The {@link Exam} object containing the updated details of the
	 *             exam. Must not be {@code null} and must have a valid exam ID.
	 * @throws IllegalArgumentException If the provided {@link Exam} object is
	 *                                  {@code null} or if the exam ID is not set.
	 * @throws RuntimeException         If there is an error during database access.
	 */
	@Override
	public void updateExam(Exam exam) throws ExamNotFoundException {

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.UPDATE_EXAM)) {

			pstmt.setString(1, exam.getExamName()); // Set exam name
			pstmt.setDate(2, new java.sql.Date(exam.getExamDate().getTime())); // Set exam date

			// Handle enum conversion
			try {
				pstmt.setString(3, exam.getSubject().getValue()); // Convert Subject enum to database value
			} catch (IllegalArgumentException e) {
				System.err.println("Invalid subject value found for enum: " + exam.getSubject());
				pstmt.setString(3, Subject.UNKNOWN.getValue()); // Set default or handle error
			}

			pstmt.setInt(4, exam.getExamId()); // Set exam ID

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated == 0) {
				throw new ExamNotFoundException("Exam not found with ID: " + exam.getExamId());
			}
			System.out.println("Exam updated successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an exam by its ID.
	 *
	 * <p>
	 * This method deletes the exam record with the specified ID from the database.
	 * It also handles any dependencies that might exist between the exam and
	 * associated students or teachers.
	 * </p>
	 *
	 * @param examId The ID of the exam to be deleted.
	 * @throws RuntimeException If there is an error during database access.
	 */
	@Override
	public void deleteExam(int examId) throws ExamNotFoundException {

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.DELETE_EXAM)) {

			pstmt.setInt(1, examId);

			int rowsDeleted = pstmt.executeUpdate();
			if (rowsDeleted == 0) {
				throw new ExamNotFoundException("Exam not found with ID: " + examId);
			}
			System.out.println("Exam deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error deleting exam with ID: " + examId, e);
		}
	}

	/**
	 * Assigns a list of students to a specific exam.
	 *
	 * <p>
	 * This method assigns students to the exam identified by the specified
	 * {@code examId}. It starts a transaction to ensure that all operations are
	 * performed atomically. The process involves checking if the exam exists,
	 * deleting any existing student-exam relationships for the specified exam, and
	 * then inserting new student-exam relationships based on the provided list of
	 * student IDs.
	 * </p>
	 *
	 * <p>
	 * If any error occurs during the operation, the transaction is rolled back to
	 * maintain data integrity.
	 * </p>
	 *
	 * @param examId     The ID of the exam to which students are to be assigned.
	 * @param studentIds A list of student IDs to be assigned to the exam. Each ID
	 *                   should correspond to a valid student.
	 * @throws ExamNotFoundException    If no exam is found with the given
	 *                                  {@code examId}.
	 * @throws IllegalArgumentException If the {@code studentIds} list is
	 *                                  {@code null} or empty.
	 * @throws RuntimeException         If there is an error during database access
	 *                                  or transaction handling.
	 */

	@Override
	public void assignStudentsToExam(int examId, List<Integer> studentIds) throws ExamNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionBean.openConnection();
			conn.setAutoCommit(false); // Start transaction

			// Check if the exam exists
			Exam exam = getExamById(examId);
			if (exam == null) {
				throw new ExamNotFoundException("Exam not found with ID: " + examId);
			}

			// Delete existing student-exam relations
			try (PreparedStatement pstmt = conn.prepareStatement(Queries.DELETE_STUDENT_EXAM_RELATIONS)) {
				pstmt.setInt(1, examId);
				pstmt.executeUpdate();
			}

			// Insert new student-exam relations
			try (PreparedStatement pstmt = conn.prepareStatement(Queries.INSERT_STUDENT_EXAM_RELATION)) {
				for (Integer studentId : studentIds) {
					pstmt.setInt(1, examId);
					pstmt.setInt(2, studentId);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}

			conn.commit(); // Commit transaction
			System.out.println("Students assigned to exam successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback(); // Rollback transaction in case of error
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			throw new RuntimeException("Error assigning students to exam with ID: " + examId, e);
		} finally {
			if (conn != null) {
				try {
					conn.close(); // Close connection
				} catch (SQLException closeEx) {
					closeEx.printStackTrace();
				}
			}
		}
	}

	/**
	 * Assigns a list of teachers to a specific exam.
	 *
	 * <p>
	 * This method assigns teachers to the exam identified by the specified
	 * {@code examId}. It first checks if the exam exists. If the exam exists, it
	 * deletes any existing teacher-exam relationships for the specified exam and
	 * then inserts new teacher-exam relationships based on the provided list of
	 * teacher IDs.
	 * </p>
	 *
	 * <p>
	 * This method uses a single database connection and handles transactions
	 * implicitly. In case of an SQL error, a {@code RuntimeException} is thrown.
	 * </p>
	 *
	 * @param examId     The ID of the exam to which teachers are to be assigned.
	 * @param teacherIds A list of teacher IDs to be assigned to the exam. Each ID
	 *                   should correspond to a valid teacher.
	 * @throws ExamNotFoundException If no exam is found with the given
	 *                               {@code examId}.
	 * @throws RuntimeException      If there is an error during database access or
	 *                               handling.
	 */
	@Override
	public void assignTeachersToExam(int examId, List<Integer> teacherIds) throws ExamNotFoundException {
		try (Connection conn = ConnectionBean.openConnection()) {
			// Check if the exam exists
			getExamById(examId);

			// Delete existing teacher-exam relations
			try (PreparedStatement pstmt = conn.prepareStatement(Queries.DELETE_TEACHER_EXAM_RELATIONS)) {
				pstmt.setInt(1, examId);
				pstmt.executeUpdate();
			}

			// Insert new teacher-exam relations
			try (PreparedStatement pstmt = conn.prepareStatement(Queries.INSERT_TEACHER_EXAM_RELATION)) {
				for (Integer teacherId : teacherIds) {
					pstmt.setInt(1, examId);
					pstmt.setInt(2, teacherId);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error assigning teachers to exam with ID: " + examId, e);
		}
	}

	/**
	 * Retrieves a list of students associated with a specific exam.
	 *
	 * <p>
	 * This method queries the database to find all students who are associated with
	 * the specified exam ID and returns a list of {@link Student} objects
	 * representing these students.
	 * </p>
	 *
	 * @param examId The ID of the exam whose associated students are to be
	 *               retrieved.
	 * @return A list of {@link Student} objects associated with the specified exam.
	 * @throws RuntimeException If there is an error during database access.
	 */
	@Override
	public List<Student> getStudentsByExamId(int examId) {
		List<Student> students = new ArrayList<>();

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.GET_STUDENTS_BY_EXAM_ID)) {
			pstmt.setInt(1, examId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Student student = new Student();
					student.setStudentId(rs.getInt("student_id"));
					student.setStudentName(rs.getString("student_name"));

					// Convert java.sql.Date to java.util.Date
					student.setDateOfBirth(rs.getDate("date_of_birth"));
					student.setDateOfJoining(rs.getDate("date_of_joining"));

					student.setParentContact(rs.getInt("parent_contact"));

					// Address details
					Address address = new Address();
					address.setDoorNo(rs.getString("door_no"));
					address.setStreet(rs.getString("street"));
					address.setCity(rs.getString("city"));
					address.setDistrict(rs.getString("district"));
					address.setPincode(rs.getInt("pincode"));
					address.setState(rs.getString("state"));
					address.setCountry(rs.getString("country"));
					student.setAddress(address);

					// Gender enum mapping
					String genderStr = rs.getString("gender");
					student.setGender(genderStr != null ? Gender.fromValue(genderStr) : null);

					// Blood group enum mapping
					String bloodGroupStr = rs.getString("blood_group");
					student.setBloodGroup(bloodGroupStr != null ? BloodGroup.fromValue(bloodGroupStr) : null);

					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving students for exam ID: " + examId, e);
		}
		return students;
	}

	/**
	 * Retrieves a list of teachers associated with a specific exam.
	 *
	 * <p>
	 * This method queries the database to find all teachers who are associated with
	 * the specified exam ID and returns a list of {@link Teacher} objects
	 * representing these teachers.
	 * </p>
	 *
	 * @param examId The ID of the exam whose associated teachers are to be
	 *               retrieved.
	 * @return A list of {@link Teacher} objects associated with the specified exam.
	 * @throws RuntimeException If there is an error during database access.
	 */
	@Override
	public List<Teacher> getTeachersByExamId(int examId) throws ExamNotFoundException {
		String sql = "SELECT t.teacher_id, t.teacher_name, t.subject FROM teacher t "
				+ "JOIN teacher_exam et ON t.teacher_id = et.teacher_id " + "WHERE et.exam_id = ?";
		List<Teacher> teachers = new ArrayList<>();

		try (Connection conn = ConnectionBean.openConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, examId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setTeacherId(rs.getInt("teacher_id"));
					teacher.setTeacherName(rs.getString("teacher_name"));
					// Ensure 'subject' column exists or use correct column name
					teacher.setSubjectStart(Subject.fromValue(rs.getString("subject")));
					teachers.add(teacher);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving teachers for exam ID: " + examId, e);
		}
		return teachers;
	}

	/**
	 * Deletes all relationships associated with a specific exam.
	 *
	 * <p>
	 * This method removes all student-exam and teacher-exam associations for the
	 * exam identified by the specified {@code examId}. It first verifies the
	 * existence of the exam. If the exam exists, it proceeds to delete all related
	 * records from the database.
	 * </p>
	 *
	 * <p>
	 * The method uses two separate SQL statements to delete the relationships from
	 * the respective tables. The first statement deletes student-exam relations,
	 * and the second statement deletes teacher-exam relations. It handles SQL
	 * exceptions by printing the stack trace and throwing a
	 * {@code RuntimeException} with a descriptive message.
	 * </p>
	 *
	 * @param examId The ID of the exam for which relationships are to be deleted.
	 * @throws ExamNotFoundException If no exam is found with the given
	 *                               {@code examId}.
	 * @throws RuntimeException      If there is an error during database access or
	 *                               handling.
	 */
	@Override
	public void deleteExamRelations(int examId) throws ExamNotFoundException {
		// Check if the exam exists before trying to delete relations
		getExamById(examId);

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(Queries.DELETE_STUDENT_EXAM_RELATIONS);
				PreparedStatement pstmt2 = conn.prepareStatement(Queries.DELETE_TEACHER_EXAM_RELATIONS)) {

			// Set examId for both delete statements
			pstmt1.setInt(1, examId);
			pstmt2.setInt(1, examId);

			// Execute delete statements
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error deleting exam relations for exam ID: " + examId, e);
		}
	}

	/**
	 * Retrieves a list of exams associated with a specific student.
	 *
	 * <p>
	 * This method queries the database to find all exams that are linked to the
	 * student identified by the given {@code studentId}. It returns a list of
	 * {@link Exam} objects representing these exams. Each {@link Exam} is populated
	 * with its ID, name, date, and subject. If the subject retrieved from the
	 * database is not valid, it is set to {@link Subject#UNKNOWN}.
	 * </p>
	 *
	 * <p>
	 * The method uses a SQL query to fetch the exam details from the database. It
	 * handles SQL exceptions by printing the stack trace and throwing a
	 * {@code RuntimeException} with a descriptive message.
	 * </p>
	 *
	 * @param studentId The ID of the student whose exams are to be retrieved.
	 * @return A list of {@link Exam} objects associated with the specified student.
	 * @throws RuntimeException If there is an error during database access or
	 *                          handling.
	 */
	@Override
	public List<Exam> getExamsByStudentId(int studentId) {
		List<Exam> exams = new ArrayList<>();

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.SELECT_EXAMS_BY_STUDENT_ID)) {

			pstmt.setInt(1, studentId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Exam exam = new Exam();
					exam.setExamId(rs.getInt("exam_id"));
					exam.setExamName(rs.getString("exam_name"));
					exam.setExamDate(rs.getDate("exam_date"));

					// Convert string to Subject enum
					String subjectStr = rs.getString("subject");
					try {
						exam.setSubject(Subject.fromValue(subjectStr));
					} catch (IllegalArgumentException e) {
						System.err.println("Invalid subject value found in database: " + subjectStr);
						exam.setSubject(Subject.UNKNOWN); // Handle invalid values
					}

					exams.add(exam);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving exams for student ID: " + studentId, e);
		}
		return exams;
	}

	/**
	 * Retrieves a list of exams scheduled on a specific date.
	 *
	 * <p>
	 * This method queries the database to find all exams that are scheduled on the
	 * given {@code examDate}. It returns a list of {@link Exam} objects
	 * representing these exams. Each {@link Exam} is populated with its ID, name,
	 * date, and subject. If the subject retrieved from the database is not valid,
	 * it is set to {@link Subject#UNKNOWN}.
	 * </p>
	 *
	 * <p>
	 * The method uses a SQL query to fetch the exam details from the database. It
	 * handles SQL exceptions by printing the stack trace and throwing a
	 * {@code RuntimeException} with a descriptive message.
	 * </p>
	 *
	 * @param examDate The date of the exams to be retrieved.
	 * @return A list of {@link Exam} objects scheduled on the specified date.
	 * @throws RuntimeException If there is an error during database access or
	 *                          handling.
	 */
	@Override
	public List<Exam> getExamsByDate(Date examDate) {
		List<Exam> exams = new ArrayList<>();

		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.SELECT_EXAMS_BY_DATE)) {

			pstmt.setDate(1, examDate);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Exam exam = new Exam();
					exam.setExamId(rs.getInt("exam_id"));
					exam.setExamName(rs.getString("exam_name"));
					exam.setExamDate(rs.getDate("exam_date"));

					// Convert string to Subject enum
					String subjectStr = rs.getString("subject");
					try {
						exam.setSubject(Subject.fromValue(subjectStr));
					} catch (IllegalArgumentException e) {
						System.err.println("Invalid subject value found in database: " + subjectStr);
						exam.setSubject(Subject.UNKNOWN); // Handle invalid values
					}

					exams.add(exam);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving exams by date: " + examDate, e);
		}
		return exams;
	}

	/**
	 * Calculates the total exam marks for a specific student.
	 *
	 * <p>
	 * This method queries the database to retrieve the total marks obtained by the
	 * student in all their exams. It aggregates the marks from the result set and
	 * returns the total as a {@code double}. If there are any errors during
	 * database access, a {@code RuntimeException} is thrown.
	 * </p>
	 *
	 * <p>
	 * The method executes a SQL query to fetch the total marks from the database.
	 * It iterates through the result set and accumulates the marks into the
	 * {@code totalMarks} variable.
	 * </p>
	 *
	 * @param studentId The ID of the student whose total exam marks are to be
	 *                  calculated.
	 * @return The total exam marks for the student.
	 * @throws RuntimeException If there is an error during database access or
	 *                          handling.
	 */
	@Override
	public double calculateTotalExamMarksForStudent(int studentId) {
		double totalMarks = 0.0;
		try (Connection conn = ConnectionBean.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(Queries.CALCULATE_TOTAL_MARKS_BY_STUDENT_ID)) {

			pstmt.setInt(1, studentId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					totalMarks += rs.getDouble("total_marks"); // Updated to match the alias in the query
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error calculating total exam marks for student ID: " + studentId, e);
		}
		return totalMarks;
	}

}
