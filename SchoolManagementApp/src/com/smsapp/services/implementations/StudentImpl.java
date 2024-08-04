package com.smsapp.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.smsapp.dao.ConnectionBean;
import com.smsapp.exceptions.StudentNotFoundException;
import com.smsapp.model.Address;
import com.smsapp.model.BloodGroup;
import com.smsapp.model.Gender;
import com.smsapp.model.Student;
import com.smsapp.services.interfaces.IStudent;
import com.smsapp.util.Queries;

/**
 * Implementation of the {@link IStudent} interface for managing student records
 * in a school management system. This class provides methods for performing
 * CRUD (Create, Read, Update, Delete) operations on student data, as well as
 * additional functionalities such as assigning random houses to students.
 * <p>
 * The class interacts with the database using JDBC, leveraging SQL queries
 * defined in the {@link Queries} class. It handles operations involving the
 * `Student` and `Address` entities, ensuring data consistency and proper
 * resource management.
 * </p>
 * <p>
 * Key methods include:
 * <ul>
 * <li>{@link #addStudent(Student)}: Adds a new student to the database,
 * including their address.</li>
 * <li>{@link #getStudentById(int)}: Retrieves a student's details by their ID,
 * including their address.</li>
 * <li>{@link #getAllStudents()}: Retrieves a list of all students, including
 * their addresses.</li>
 * <li>{@link #updateStudent(Student)}: Updates the details of an existing
 * student and their address.</li>
 * <li>{@link #deleteStudent(int)}: Deletes a student from the database by their
 * ID.</li>
 * <li>{@link #assignRandomHouse(int)}: Assigns a random house to a
 * student.</li>
 * </ul>
 * </p>
 * <p>
 * The implementation ensures proper handling of database connections and
 * transactions, committing changes where necessary and rolling back in case of
 * errors. It also includes exception handling to manage potential issues with
 * database operations.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class StudentImpl implements IStudent {

	/**
	 * Adds a new student to the database.
	 * <p>
	 * This method performs the following operations:
	 * <ul>
	 * <li>Inserts the student's address into the database and retrieves the
	 * generated address ID.</li>
	 * <li>Inserts the student's details into the `student` table using the
	 * retrieved address ID.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param student The {@link Student} object containing the details of the
	 *                student to be added.
	 * @throws RuntimeException If a database error occurs during the insertion
	 *                          process.
	 */
	@Override
	public void addStudent(Student student) {
		try (Connection connection = ConnectionBean.openConnection()) {
			// Insert address and get the address ID
			int addressId;
			try (PreparedStatement psAddress = connection.prepareStatement(Queries.INSERT_ADDRESS,
					Statement.RETURN_GENERATED_KEYS)) {
				Address address = student.getAddress();
				psAddress.setString(1, address.getDoorNo());
				psAddress.setString(2, address.getStreet());
				psAddress.setString(3, address.getCity());
				psAddress.setString(4, address.getDistrict());
				psAddress.setInt(5, address.getPincode());
				psAddress.setString(6, address.getState());
				psAddress.setString(7, address.getCountry());
				psAddress.executeUpdate();
				ResultSet rs = psAddress.getGeneratedKeys();
				if (rs.next()) {
					addressId = rs.getInt(1);
				} else {
					throw new SQLException("Failed to retrieve address ID.");
				}
			}

			// Insert student
			try (PreparedStatement psStudent = connection.prepareStatement(Queries.INSERT_STUDENT)) {
				psStudent.setInt(1, student.getStudentId());
				psStudent.setString(2, student.getStudentName());
				psStudent.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
				psStudent.setDate(4, new java.sql.Date(student.getDateOfJoining().getTime()));
				psStudent.setInt(5, student.getParentContact());
				psStudent.setInt(6, addressId); // Use the address ID here
				psStudent.setString(7, student.getMailId());
				psStudent.setString(8, student.getGender().getValue());
				psStudent.setString(9, student.getBloodGroup().getValue());
				psStudent.setInt(10, student.getGrade());
				psStudent.setString(11, student.getHouse());
				psStudent.executeUpdate();
				System.out.println("Student added successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a student by their ID.
	 * <p>
	 * This method fetches the details of a student from the database using the
	 * specified student ID. It also retrieves the address associated with the
	 * student.
	 * </p>
	 * 
	 * @param studentId The ID of the student to retrieve.
	 * @return The {@link Student} object with the specified ID.
	 * @throws StudentNotFoundException If no student with the specified ID is found
	 *                                  in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  retrieval process.
	 */
	@Override
	public Student getStudentById(int studentId) throws StudentNotFoundException {
		Student student = null;
		Address address = null;

		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement psStudent = connection.prepareStatement(Queries.GET_STUDENT_BY_ID);
				PreparedStatement psAddress = connection.prepareStatement(Queries.GET_ADDRESS_BY_ID)) {

			// Retrieve student data
			psStudent.setInt(1, studentId);
			ResultSet rsStudent = psStudent.executeQuery();
			if (rsStudent.next()) {
				student = new Student();
				student.setStudentId(rsStudent.getInt("student_id"));
				student.setStudentName(rsStudent.getString("student_name"));
				student.setDateOfBirth(rsStudent.getDate("date_of_birth"));
				student.setDateOfJoining(rsStudent.getDate("date_of_joining"));

				int parentContact = rsStudent.getInt("parent_contact");
				student.setParentContact(parentContact);

				int addressId = rsStudent.getInt("address_id");
				student.setMailId(rsStudent.getString("mail_id"));

				// Safe parsing of enums
				String genderStr = rsStudent.getString("gender");
				try {
					student.setGender(Gender.fromValue(genderStr));
				} catch (IllegalArgumentException e) {
					student.setGender(Gender.OTHER); // or handle accordingly
				}

				String bloodGroupStr = rsStudent.getString("blood_group");
				try {
					student.setBloodGroup(BloodGroup.fromValue(bloodGroupStr));
				} catch (IllegalArgumentException e) {
					student.setBloodGroup(BloodGroup.O_NEGATIVE); // or handle accordingly
				}

				student.setGrade(rsStudent.getInt("grade"));
				student.setHouse(rsStudent.getString("house"));

				// Retrieve address data
				psAddress.setInt(1, addressId);
				ResultSet rsAddress = psAddress.executeQuery();
				if (rsAddress.next()) {
					address = new Address.Builder().doorNo(rsAddress.getString("door_no"))
							.street(rsAddress.getString("street")).city(rsAddress.getString("city"))
							.district(rsAddress.getString("district")).pincode(rsAddress.getInt("pincode"))
							.state(rsAddress.getString("state")).country(rsAddress.getString("country")).build();
					student.setAddress(address);
				}
			} else {
				throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error retrieving student with ID: " + studentId);
		}

		return student;
	}

	/**
	 * Retrieves a list of all students.
	 * <p>
	 * This method fetches all student records from the database, including their
	 * associated addresses.
	 * </p>
	 * 
	 * @return A {@link List} of {@link Student} objects representing all students
	 *         in the database.
	 * @throws RuntimeException If a database error occurs during the retrieval
	 *                          process.
	 */
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_STUDENTS);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setDateOfBirth(rs.getDate("date_of_birth"));
				student.setDateOfJoining(rs.getDate("date_of_joining"));
				student.setParentContact(rs.getInt("parent_contact"));
				student.setMailId(rs.getString("mail_id"));

				// Safe parsing of enums
				String genderStr = rs.getString("gender");
				student.setGender(Gender.fromValue(genderStr));

				String bloodGroupStr = rs.getString("blood_group");
				student.setBloodGroup(BloodGroup.fromValue(bloodGroupStr));

				student.setGrade(rs.getInt("grade"));
				student.setHouse(rs.getString("house"));

				// Retrieve address data
				Address address = new Address.Builder().doorNo(rs.getString("door_no")).street(rs.getString("street"))
						.city(rs.getString("city")).district(rs.getString("district")).pincode(rs.getInt("pincode"))
						.state(rs.getString("state")).country(rs.getString("country")).build();
				student.setAddress(address);

				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error retrieving all students.");
		}

		return students;
	}

	/**
	 * Updates the details of an existing student.
	 * <p>
	 * This method updates the student's information in the database, including
	 * their address.
	 * </p>
	 * 
	 * @param student The {@link Student} object containing the updated details of
	 *                the student.
	 * @throws StudentNotFoundException If the student with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the update
	 *                                  process.
	 */
	@Override
	public void updateStudent(Student student) throws StudentNotFoundException {
		String updateStudentQuery = Queries.UPDATE_STUDENT;
		String updateAddressQuery = Queries.UPDATE_ADDRESS;

		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement psStudent = connection.prepareStatement(updateStudentQuery);
				PreparedStatement psAddress = connection.prepareStatement(updateAddressQuery)) {

			// Update student data
			psStudent.setString(1, student.getStudentName());
			psStudent.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
			psStudent.setDate(3, new java.sql.Date(student.getDateOfJoining().getTime()));
			psStudent.setLong(4, student.getParentContact());
			psStudent.setString(5, student.getMailId());
			psStudent.setString(6, student.getGender().getValue()); // Use getValue() for Gender enum
			psStudent.setString(7, student.getBloodGroup().getValue()); // Use getValue() for BloodGroup enum
			psStudent.setInt(8, student.getGrade());
			psStudent.setString(9, student.getHouse());
			psStudent.setInt(10, student.getStudentId()); // Updated index

			psStudent.executeUpdate();

			// Update address data
			Address address = student.getAddress();
			if (address != null) {
				psAddress.setString(1, address.getDoorNo()); // Assuming doorNo is a string
				psAddress.setString(2, address.getStreet());
				psAddress.setString(3, address.getCity());
				psAddress.setString(4, address.getDistrict());
				psAddress.setInt(5, address.getPincode());
				psAddress.setString(6, address.getState());
				psAddress.setString(7, address.getCountry());
				psAddress.setInt(8, address.getAddressId()); // Address ID to identify which address to update

				psAddress.executeUpdate();
			} else {
				System.err.println("Address is null. Unable to update address details.");
			}

			System.out.println("Student updated successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error updating student with ID: " + student.getStudentId());
		}
	}

	/**
	 * Deletes a student from the database by their ID.
	 * <p>
	 * This method removes the student record from the database. It first deletes
	 * any associated records in the `student_teacher` junction table before
	 * removing the student.
	 * </p>
	 * 
	 * @param studentId The ID of the student to be deleted.
	 * @throws StudentNotFoundException If the student with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  deletion process.
	 */
	@Override
	public void deleteStudent(int studentId) throws StudentNotFoundException {
		Connection connection = null;
		PreparedStatement psDeleteStudentTeacher = null;
		PreparedStatement psDeleteStudent = null;

		try {
			connection = ConnectionBean.openConnection();
			connection.setAutoCommit(false); // Start transaction

			// First, delete related records in student_teacher
			String deleteStudentTeacherQuery = "DELETE FROM student_teacher WHERE student_id = ?";
			psDeleteStudentTeacher = connection.prepareStatement(deleteStudentTeacherQuery);
			psDeleteStudentTeacher.setInt(1, studentId);
			psDeleteStudentTeacher.executeUpdate();

			// Then, delete the student
			String deleteStudentQuery = Queries.DELETE_STUDENT;
			psDeleteStudent = connection.prepareStatement(deleteStudentQuery);
			psDeleteStudent.setInt(1, studentId);
			int rowsAffected = psDeleteStudent.executeUpdate();

			if (rowsAffected == 0) {
				connection.rollback(); // Rollback transaction if student not found
				throw new StudentNotFoundException("Student not found with ID: " + studentId);
			}

			connection.commit(); // Commit transaction
			System.out.println("Student deleted successfully.");
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback(); // Rollback on error
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (psDeleteStudent != null) {
					psDeleteStudent.close();
				}
				if (psDeleteStudentTeacher != null) {
					psDeleteStudentTeacher.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Assigns a random house to a student.
	 * <p>
	 * This method randomly selects a house from a predefined list and assigns it to
	 * the student with the specified ID.
	 * </p>
	 * 
	 * @param studentId The ID of the student to whom a house is to be assigned.
	 * @throws StudentNotFoundException If the student with the specified ID is not
	 *                                  found in the database.
	 * @throws RuntimeException         If a database error occurs during the
	 *                                  assignment process.
	 */
	@Override
	public void assignRandomHouse(int studentId) throws StudentNotFoundException {
		String[] houses = { "Red", "Blue", "Green", "Yellow" };
		Random random = new Random();
		String assignedHouse = houses[random.nextInt(houses.length)];

		try (Connection connection = ConnectionBean.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_STUDENT_HOUSE)) {
			ps.setString(1, assignedHouse);
			ps.setInt(2, studentId);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected == 0) {
				throw new StudentNotFoundException("Student not found with ID: " + studentId);
			}
			System.out.println("House assigned successfully: " + assignedHouse);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
