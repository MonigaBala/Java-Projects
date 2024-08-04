package com.smsapp.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smsapp.dao.ConnectionBean;
import com.smsapp.exceptions.TeacherNotFoundException;
import com.smsapp.model.Address;
import com.smsapp.model.BloodGroup;
import com.smsapp.model.Department;
import com.smsapp.model.Gender;
import com.smsapp.model.Student;
import com.smsapp.model.Subject;
import com.smsapp.model.Teacher;
import com.smsapp.services.interfaces.ITeacher;
import com.smsapp.util.Queries;

/**
 * Implementation of the {@link ITeacher} interface for managing teacher records
 * in a school management system. This class provides methods for performing
 * CRUD (Create, Read, Update, Delete) operations on teacher data, as well as
 * additional functionalities such as assigning students to teachers.
 * <p>
 * The class interacts with the database through JDBC, using SQL queries defined
 * in the {@link Queries} class. It handles operations involving the `Teacher`
 * and `Address` entities, and supports transactions to ensure data consistency.
 * </p>
 * <p>
 * Key methods include:
 * <ul>
 * <li>{@link #addTeacher(Teacher)}: Adds a new teacher to the database.</li>
 * <li>{@link #getTeacherById(int)}: Retrieves a teacher's details by their ID,
 * including associated students.</li>
 * <li>{@link #getAllTeachers()}: Retrieves a list of all teachers in the
 * database, including their assigned students.</li>
 * <li>{@link #updateTeacher(Teacher)}: Updates the details of an existing
 * teacher.</li>
 * <li>{@link #deleteTeacher(int)}: Deletes a teacher from the database by their
 * ID.</li>
 * <li>{@link #assignStudentsToTeacher(int, List)}: Assigns a list of students
 * to a teacher.</li>
 * </ul>
 * </p>
 * <p>
 * The implementation ensures proper handling of database resources and
 * transactions, committing changes where necessary and rolling back in case of
 * errors. It also includes exception handling to manage potential issues with
 * database operations.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class TeacherImpl implements ITeacher {

	/**
	 * Adds a new teacher to the database.
	 * <p>
	 * This method performs the following operations:
	 * <ul>
	 * <li>Inserts the teacher's address into the database and retrieves the
	 * generated address ID.</li>
	 * <li>Inserts the teacher's details into the `teacher` table using the
	 * retrieved address ID.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param teacher The {@link Teacher} object containing the details of the
	 *                teacher to be added.
	 * @throws RuntimeException If a database error occurs during the insertion
	 *                          process.
	 */
	@Override
	public void addTeacher(Teacher teacher) {
		Connection connection = null;
		PreparedStatement psAddress = null;
		PreparedStatement psTeacher = null;
		ResultSet generatedKeys = null;

		try {
			connection = ConnectionBean.openConnection();
			connection.setAutoCommit(false); // Start transaction

			// 1. Insert Address and get generated ID
			String insertAddressSQL = Queries.INSERT_ADDRESS;
			psAddress = connection.prepareStatement(insertAddressSQL, Statement.RETURN_GENERATED_KEYS);
			Address address = teacher.getAddress();
			psAddress.setString(1, address.getDoorNo());
			psAddress.setString(2, address.getStreet());
			psAddress.setString(3, address.getCity());
			psAddress.setString(4, address.getDistrict());
			psAddress.setInt(5, address.getPincode());
			psAddress.setString(6, address.getState());
			psAddress.setString(7, address.getCountry());
			psAddress.executeUpdate();

			// Retrieve generated address ID
			generatedKeys = psAddress.getGeneratedKeys();
			int addressId = -1;
			if (generatedKeys.next()) {
				addressId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Failed to retrieve address ID.");
			}

			// 2. Insert Teacher
			psTeacher = connection.prepareStatement(Queries.INSERT_TEACHER);
			psTeacher.setInt(1, teacher.getTeacherId());
			psTeacher.setString(2, teacher.getTeacherName());
			psTeacher.setDate(3, new java.sql.Date(teacher.getDateOfBirth().getTime()));
			psTeacher.setDate(4, new java.sql.Date(teacher.getDateOfJoining().getTime()));
			psTeacher.setLong(5, teacher.getContact());
			psTeacher.setInt(6, addressId); // Set address ID from the first insert
			psTeacher.setString(7, teacher.getMailId());
			psTeacher.setString(8, teacher.getGender().getValue()); // Use getValue() for Gender enum
			psTeacher.setString(9, teacher.getBloodGroup().getValue()); // Use getValue() for BloodGroup enum
			psTeacher.setInt(10, teacher.getExperience());
			psTeacher.setDouble(11, teacher.getSalary());
			psTeacher.setString(12, teacher.getDepartment().getValue()); // Use getValue() for Department enum
			psTeacher.setString(13, teacher.getSubjectStart().getValue()); // Use getValue() for Subject enum

			psTeacher.executeUpdate();
			connection.commit(); // Commit transaction

			System.out.println("Teacher added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback(); // Rollback transaction in case of error
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			try {
				if (psAddress != null)
					psAddress.close();
				if (psTeacher != null)
					psTeacher.close();
				if (generatedKeys != null)
					generatedKeys.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Retrieves a teacher by their ID.
	 * <p>
	 * This method fetches the details of a teacher from the database using the
	 * specified teacher ID. It also retrieves the list of students assigned to the
	 * teacher.
	 * </p>
	 * 
	 * @param teacherId The ID of the teacher to retrieve.
	 * @return The {@link Teacher} object with the specified ID.
	 * @throws TeacherNotFoundException If no teacher with the specified ID is found
	 *                                  in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  retrieval process.
	 */
	@Override
	public Teacher getTeacherById(int teacherId) throws TeacherNotFoundException {
		Teacher teacher = null;
		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.GET_TEACHER_BY_ID);
				PreparedStatement studentPs = connection.prepareStatement(Queries.GET_STUDENTS_BY_TEACHER_ID)) {

			// Fetch teacher details
			ps.setInt(1, teacherId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setDateOfBirth(rs.getDate("date_of_birth"));
				teacher.setDateOfJoining(rs.getDate("date_of_joining"));
				teacher.setContact(rs.getLong("contact"));

				Address address = new Address();
				address.setDoorNo(rs.getString("door_no")); // Verify this is the correct type
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setDistrict(rs.getString("district"));
				address.setPincode(rs.getInt("pincode"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				teacher.setAddress(address);

				teacher.setMailId(rs.getString("mail_id"));

				// Safe parsing of enums with default values
				String genderStr = rs.getString("gender");
				try {
					teacher.setGender(Gender.fromValue(genderStr));
				} catch (IllegalArgumentException | NullPointerException e) {
					teacher.setGender(Gender.OTHER); // Default value or handle accordingly
				}

				String bloodGroupStr = rs.getString("blood_group");
				try {
					teacher.setBloodGroup(BloodGroup.fromValue(bloodGroupStr));
				} catch (IllegalArgumentException | NullPointerException e) {
					teacher.setBloodGroup(BloodGroup.A_NEGATIVE); // Default value or handle accordingly
				}

				// Handle potential nulls for department and subjectStart
				String departmentStr = rs.getString("department");
				try {
					teacher.setDepartment(Department.fromValue(departmentStr));
				} catch (IllegalArgumentException | NullPointerException e) {
					teacher.setDepartment(null); // Handle accordingly
				}

				String subjectStartStr = rs.getString("subject_start");
				try {
					teacher.setSubjectStart(Subject.fromValue(subjectStartStr)); // Adjust if needed
				} catch (IllegalArgumentException | NullPointerException e) {
					teacher.setSubjectStart(null); // Handle accordingly
				}

				teacher.setExperience(rs.getInt("experience"));
				teacher.setSalary(rs.getDouble("salary"));

				// Fetch students assigned to the teacher
				studentPs.setInt(1, teacherId);
				ResultSet studentRs = studentPs.executeQuery();
				List<Student> students = new ArrayList<>();
				while (studentRs.next()) {
					Student student = new Student();
					student.setStudentId(studentRs.getInt("student_id"));
					student.setStudentName(studentRs.getString("student_name"));
					student.setDateOfBirth(studentRs.getDate("date_of_birth"));
					student.setDateOfJoining(studentRs.getDate("date_of_joining"));
					student.setParentContact(studentRs.getInt("parent_contact"));

					Address studentAddress = new Address();
					studentAddress.setDoorNo(studentRs.getString("door_no")); // Verify this is the correct type
					studentAddress.setStreet(studentRs.getString("street"));
					studentAddress.setCity(studentRs.getString("city"));
					studentAddress.setDistrict(studentRs.getString("district"));
					studentAddress.setPincode(studentRs.getInt("pincode"));
					studentAddress.setState(studentRs.getString("state"));
					studentAddress.setCountry(studentRs.getString("country"));
					student.setAddress(studentAddress);

					student.setMailId(studentRs.getString("mail_id"));

					String studentGenderStr = studentRs.getString("gender");
					try {
						student.setGender(Gender.fromValue(studentGenderStr));
					} catch (IllegalArgumentException | NullPointerException e) {
						student.setGender(Gender.OTHER); // Default value or handle accordingly
					}

					String studentBloodGroupStr = studentRs.getString("blood_group");
					try {
						student.setBloodGroup(BloodGroup.fromValue(studentBloodGroupStr));
					} catch (IllegalArgumentException | NullPointerException e) {
						student.setBloodGroup(BloodGroup.A_NEGATIVE); // Default value or handle accordingly
					}

					student.setGrade(studentRs.getInt("grade"));
					student.setHouse(studentRs.getString("house"));

					students.add(student);
				}
				teacher.setStudents(students);
			} else {
				throw new TeacherNotFoundException("Teacher with ID " + teacherId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database error occurred.", e);
		}
		return teacher;
	}

	/**
	 * Retrieves a list of all teachers.
	 * <p>
	 * This method fetches all teacher records from the database, including their
	 * assigned students.
	 * </p>
	 * 
	 * @return A {@link List} of {@link Teacher} objects representing all teachers
	 *         in the database.
	 * @throws RuntimeException If a database error occurs during the retrieval
	 *                          process.
	 */
	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_TEACHERS);
				ResultSet rs = ps.executeQuery()) {

			// First, fetch all teachers
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setDateOfBirth(rs.getDate("date_of_birth"));
				teacher.setDateOfJoining(rs.getDate("date_of_joining"));
				teacher.setContact(rs.getLong("contact"));

				Address address = new Address();
				address.setDoorNo(rs.getString("door_no"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setDistrict(rs.getString("district"));
				address.setPincode(rs.getInt("pincode"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				teacher.setAddress(address);

				teacher.setMailId(rs.getString("mail_id"));

				// Handle Gender conversion
				try {
					teacher.setGender(Gender.fromValue(rs.getString("gender")));
				} catch (IllegalArgumentException e) {
					System.err.println("Invalid gender value found in database: " + rs.getString("gender"));
					teacher.setGender(Gender.OTHER); // Set a default or handle as needed
				}

				// Handle BloodGroup conversion
				try {
					teacher.setBloodGroup(BloodGroup.fromValue(rs.getString("blood_group")));
				} catch (IllegalArgumentException e) {
					System.err.println("Invalid blood group value found in database: " + rs.getString("blood_group"));
					teacher.setBloodGroup(BloodGroup.A_NEGATIVE); // Set a default or handle as needed
				}

				teacher.setExperience(rs.getInt("experience"));
				teacher.setSalary(rs.getDouble("salary"));
				teacher.setDepartment(Department.fromValue(rs.getString("department")));
				teacher.setSubjectStart(Subject.fromValue(rs.getString("subject_start")));

				// Fetch students assigned to the teacher
				try (PreparedStatement studentPs = connection.prepareStatement(Queries.GET_STUDENTS_BY_TEACHER_ID)) {
					studentPs.setInt(1, teacher.getTeacherId());
					ResultSet studentRs = studentPs.executeQuery();
					List<Student> students = new ArrayList<>();
					while (studentRs.next()) {
						Student student = new Student();
						student.setStudentId(studentRs.getInt("student_id"));
						student.setStudentName(studentRs.getString("student_name"));
						student.setDateOfBirth(studentRs.getDate("date_of_birth"));
						student.setDateOfJoining(studentRs.getDate("date_of_joining"));
						student.setParentContact(studentRs.getInt("parent_contact"));

						Address studentAddress = new Address();
						studentAddress.setDoorNo(studentRs.getString("door_no"));
						studentAddress.setStreet(studentRs.getString("street"));
						studentAddress.setCity(studentRs.getString("city"));
						studentAddress.setDistrict(studentRs.getString("district"));
						studentAddress.setPincode(studentRs.getInt("pincode"));
						studentAddress.setState(studentRs.getString("state"));
						studentAddress.setCountry(studentRs.getString("country"));
						student.setAddress(studentAddress);

						student.setMailId(studentRs.getString("mail_id"));

						try {
							student.setGender(Gender.fromValue(studentRs.getString("gender")));
						} catch (IllegalArgumentException e) {
							student.setGender(Gender.OTHER); // Default value or handle as needed
						}

						try {
							student.setBloodGroup(BloodGroup.fromValue(studentRs.getString("blood_group")));
						} catch (IllegalArgumentException e) {
							student.setBloodGroup(BloodGroup.A_NEGATIVE); // Default value or handle as needed
						}

						student.setGrade(studentRs.getInt("grade"));
						student.setHouse(studentRs.getString("house"));

						students.add(student);
					}
					teacher.setStudents(students);
				}

				teachers.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database error occurred.");
		}
		return teachers;
	}

	/**
	 * Updates the details of an existing teacher.
	 * <p>
	 * This method updates the teacher's information in the database, including
	 * their address.
	 * </p>
	 * 
	 * @param teacher The {@link Teacher} object containing the updated details of
	 *                the teacher.
	 * @throws TeacherNotFoundException If the teacher with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the update
	 *                                  process.
	 */
	@Override
	public void updateTeacher(Teacher teacher) throws TeacherNotFoundException {
		try (Connection connection = ConnectionBean.openConnection()) {

			// Check if the teacher exists
			Teacher existingTeacher = getTeacherById(teacher.getTeacherId());
			if (existingTeacher == null) {
				throw new TeacherNotFoundException("Teacher with ID " + teacher.getTeacherId() + " not found.");
			}

			// Insert or update the address
			int addressId = teacher.getAddress().getAddressId();
			if (addressId == 0) {
				// Insert new address and get the generated address ID
				String insertAddressQuery = "INSERT INTO address (door_no, street, city, district, pincode, state, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
				try (PreparedStatement addressPs = connection.prepareStatement(insertAddressQuery,
						Statement.RETURN_GENERATED_KEYS)) {
					addressPs.setString(1, teacher.getAddress().getDoorNo());
					addressPs.setString(2, teacher.getAddress().getStreet());
					addressPs.setString(3, teacher.getAddress().getCity());
					addressPs.setString(4, teacher.getAddress().getDistrict());
					addressPs.setInt(5, teacher.getAddress().getPincode());
					addressPs.setString(6, teacher.getAddress().getState());
					addressPs.setString(7, teacher.getAddress().getCountry());
					addressPs.executeUpdate();

					try (ResultSet generatedKeys = addressPs.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							addressId = generatedKeys.getInt(1);
							teacher.getAddress().setAddressId(addressId); // Update the address ID in the teacher object
						} else {
							throw new RuntimeException("Failed to insert address, no ID obtained.");
						}
					}
				}
			} else {
				// Update existing address
				try (PreparedStatement addressPs = connection.prepareStatement(Queries.UPDATE_ADDRESS)) {
					addressPs.setString(1, teacher.getAddress().getDoorNo());
					addressPs.setString(2, teacher.getAddress().getStreet());
					addressPs.setString(3, teacher.getAddress().getCity());
					addressPs.setString(4, teacher.getAddress().getDistrict());
					addressPs.setInt(5, teacher.getAddress().getPincode());
					addressPs.setString(6, teacher.getAddress().getState());
					addressPs.setString(7, teacher.getAddress().getCountry());
					addressPs.setInt(8, addressId);
					int addressRowsAffected = addressPs.executeUpdate();
					if (addressRowsAffected == 0) {
						throw new RuntimeException("Failed to update address with ID " + addressId + ".");
					}
				}
			}

			// Update teacher details
			try (PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_TEACHER)) {
				ps.setString(1, teacher.getTeacherName());
				ps.setDate(2, new java.sql.Date(teacher.getDateOfBirth().getTime()));
				ps.setDate(3, new java.sql.Date(teacher.getDateOfJoining().getTime()));
				ps.setLong(4, teacher.getContact());
				ps.setString(5, teacher.getMailId());
				ps.setString(6, teacher.getGender().getValue()); // Ensure this matches the enum value
				ps.setString(7, teacher.getBloodGroup().getValue()); // Ensure this matches the enum value
				ps.setInt(8, teacher.getExperience());
				ps.setDouble(9, teacher.getSalary());
				ps.setString(10, teacher.getDepartment().getValue()); // Ensure this matches the enum value
				ps.setString(11, teacher.getSubjectStart().getValue()); // Ensure this matches the enum value
				ps.setInt(12, addressId); // Address ID for update
				ps.setInt(13, teacher.getTeacherId()); // Teacher ID for update
				int rowsAffected = ps.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Teacher with ID " + teacher.getTeacherId() + " successfully updated.");
				} else {
					System.out.println("No changes made to Teacher with ID " + teacher.getTeacherId() + ".");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database error occurred: " + e.getMessage(), e);
		}
	}

	/**
	 * Deletes a teacher from the database by their ID.
	 * <p>
	 * This method removes the teacher record from the database. It first verifies
	 * that the teacher exists before performing the deletion.
	 * </p>
	 * 
	 * @param teacherId The ID of the teacher to be deleted.
	 * @throws TeacherNotFoundException If the teacher with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  deletion process.
	 */
	@Override
	public void deleteTeacher(int teacherId) throws TeacherNotFoundException {
		Connection connection = null; // Declare connection outside try-with-resources

		try {
			connection = ConnectionBean.openConnection();
			connection.setAutoCommit(false); // Start transaction

			// Delete the teacher
			try (PreparedStatement ps = connection.prepareStatement(Queries.DELETE_TEACHER)) {
				ps.setInt(1, teacherId);
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected == 0) {
					throw new TeacherNotFoundException("Teacher with ID " + teacherId + " not found.");
				}
			}

			// Optionally delete the associated address
			try (PreparedStatement psAddress = connection.prepareStatement(Queries.DELETE_ADDRESS)) {
				psAddress.setInt(1, teacherId); // Assuming teacher_id is also the foreign key in the address table
				psAddress.executeUpdate();
			}

			connection.commit(); // Commit transaction
			System.out.println("Teacher deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback(); // Rollback transaction in case of error
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.close(); // Ensure connection is closed
				} catch (SQLException closeEx) {
					closeEx.printStackTrace();
				}
			}
		}
	}

	/**
	 * Assigns a list of students to a teacher.
	 * <p>
	 * This method adds entries to the `student_teacher` junction table to associate
	 * the specified students with the teacher.
	 * </p>
	 * 
	 * @param teacherId  The ID of the teacher to whom students are to be assigned.
	 * @param studentIds The {@link List} of student IDs to be assigned to the
	 *                   teacher.
	 * @throws TeacherNotFoundException If the teacher with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  assignment process.
	 */
	@Override
	public void assignStudentsToTeacher(int teacherId, List<Integer> studentIds) {
		Connection connection = null;
		try {
			connection = ConnectionBean.openConnection();
			connection.setAutoCommit(false); // Start transaction

			PreparedStatement ps = connection.prepareStatement(Queries.ASSIGN_STUDENTS_TO_TEACHER);

			for (int studentId : studentIds) {
				ps.setInt(1, teacherId); // Set the teacher ID
				ps.setInt(2, studentId); // Set the student ID
				ps.addBatch(); // Add to batch
			}

			ps.executeBatch(); // Execute batch update
			connection.commit(); // Commit transaction
			System.out.println("Students assigned to teacher successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback(); // Rollback transaction in case of error
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
		} finally {
			if (connection != null) {
				ConnectionBean.closeConnection(); // Close connection
			}
		}
	}

}
