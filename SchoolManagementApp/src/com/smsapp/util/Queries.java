package com.smsapp.util;

/**
 * Contains SQL query strings used in the School Management System application.
 * 
 * <p>
 * This class provides a collection of {@code String} constants that represent
 * SQL queries for various operations in the school management system. These
 * queries cover CRUD operations for entities such as students, teachers, exams,
 * and addresses, as well as queries for managing relationships between these
 * entities.
 * </p>
 * 
 * <p>
 * The queries include operations for:
 * <ul>
 * <li>Inserting, updating, and deleting records in the {@code student},
 * {@code teacher}, {@code address}, and {@code exam} tables.</li>
 * <li>Retrieving records from the {@code student}, {@code teacher},
 * {@code address}, and {@code exam} tables by ID and other criteria.</li>
 * <li>Managing many-to-many relationships between {@code student},
 * {@code teacher}, and {@code exam} entities.</li>
 * <li>Calculating total marks for students based on exam records.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * The SQL queries are designed to be used with {@code PreparedStatement}
 * objects, where parameters are represented by placeholders (question marks
 * {@code ?}). They are organized as public static final {@code String} fields
 * for easy access throughout the application.
 * </p>
 * 
 * <p>
 * The fields in this class include:
 * <ul>
 * <li>{@link #INSERT_ADDRESS}</li>
 * <li>{@link #INSERT_STUDENT}</li>
 * <li>{@link #GET_STUDENT_BY_ID}</li>
 * <li>{@link #GET_ADDRESS_BY_ID}</li>
 * <li>{@link #GET_ALL_STUDENTS}</li>
 * <li>{@link #UPDATE_STUDENT}</li>
 * <li>{@link #UPDATE_ADDRESS}</li>
 * <li>{@link #DELETE_STUDENT}</li>
 * <li>{@link #UPDATE_STUDENT_HOUSE}</li>
 * <li>{@link #INSERT_TEACHER}</li>
 * <li>{@link #GET_TEACHER_BY_ID}</li>
 * <li>{@link #GET_STUDENTS_BY_TEACHER_ID}</li>
 * <li>{@link #GET_ALL_TEACHERS}</li>
 * <li>{@link #UPDATE_TEACHER}</li>
 * <li>{@link #DELETE_TEACHER}</li>
 * <li>{@link #DELETE_ADDRESS}</li>
 * <li>{@link #ASSIGN_STUDENTS_TO_TEACHER}</li>
 * <li>{@link #INSERT_EXAM}</li>
 * <li>{@link #SELECT_EXAM_BY_ID}</li>
 * <li>{@link #SELECT_ALL_EXAMS}</li>
 * <li>{@link #UPDATE_EXAM}</li>
 * <li>{@link #DELETE_EXAM}</li>
 * <li>{@link #DELETE_STUDENT_EXAM_RELATIONS}</li>
 * <li>{@link #INSERT_STUDENT_EXAM_RELATION}</li>
 * <li>{@link #DELETE_TEACHER_EXAM_RELATIONS}</li>
 * <li>{@link #INSERT_TEACHER_EXAM_RELATION}</li>
 * <li>{@link #GET_STUDENTS_BY_EXAM_ID}</li>
 * <li>{@link #GET_TEACHERS_BY_EXAM_ID}</li>
 * <li>{@link #SELECT_EXAMS_BY_STUDENT_ID}</li>
 * <li>{@link #SELECT_EXAMS_BY_DATE}</li>
 * <li>{@link #CALCULATE_TOTAL_MARKS_BY_STUDENT_ID}</li>
 * </ul>
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class Queries {
	public static final String INSERT_ADDRESS = "INSERT INTO address (door_no, street, city, district, pincode, state, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_STUDENT = "INSERT INTO student (student_id, student_name, date_of_birth, date_of_joining, parent_contact, address_id, mail_id, gender, blood_group, grade, house) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_STUDENT_BY_ID = "SELECT student.student_id, student.student_name, student.date_of_birth, student.date_of_joining, student.parent_contact, student.mail_id, student.gender, student.blood_group, student.grade, student.house, student.address_id, "
			+ "address.door_no, address.street, address.city, address.district, address.pincode, address.state, address.country "
			+ "FROM student " + "JOIN address ON student.address_id = address.address_id "
			+ "WHERE student.student_id = ?";

	public static final String GET_ADDRESS_BY_ID = "SELECT door_no, street, city, district, pincode, state, country "
			+ "FROM address " + "WHERE address_id = ?";

	public static final String GET_ALL_STUDENTS = "SELECT student.student_id, student.student_name, student.date_of_birth, student.date_of_joining, student.parent_contact, student.mail_id, student.gender, student.blood_group, student.grade, student.house, address.door_no, address.street, address.city, address.district, address.pincode, address.state, address.country "
			+ "FROM student " + "JOIN address ON student.address_id = address.address_id";

	public static final String UPDATE_STUDENT = "UPDATE student SET " + "student_name = ?, " + "date_of_birth = ?, "
			+ "date_of_joining = ?, " + "parent_contact = ?, " + "mail_id = ?, " + "gender = ?, " + "blood_group = ?, "
			+ "grade = ?, " + "house = ? " + "WHERE student_id = ?";

	public static final String UPDATE_ADDRESS = "UPDATE address SET door_no = ?, street = ?, city = ?, district = ?, pincode = ?, state = ?, country = ? WHERE address_id = ?";
	public static final String DELETE_STUDENT = "DELETE FROM student WHERE student_id = ?";

	public static final String UPDATE_STUDENT_HOUSE = "UPDATE student SET house = ? WHERE student_id = ?";
	public static final String INSERT_TEACHER = "INSERT INTO teacher (teacher_id, teacher_name, date_of_birth, date_of_joining, contact, address_id, mail_id, gender, blood_group, experience, salary, department, subject_start) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_TEACHER_BY_ID = "SELECT t.teacher_id, t.teacher_name, t.date_of_birth, t.date_of_joining, "
			+ "t.contact, a.door_no, a.street, a.city, a.district, a.pincode, a.state, a.country, "
			+ "t.mail_id, t.gender, t.blood_group, t.experience, t.salary, t.department, t.subject_start "
			+ "FROM teacher t JOIN address a ON t.address_id = a.address_id " + "WHERE t.teacher_id = ?";
	public static final String GET_STUDENTS_BY_TEACHER_ID = "SELECT s.student_id, s.student_name, s.date_of_birth, s.date_of_joining, "
			+ "s.parent_contact, a.door_no, a.street, a.city, a.district, a.pincode, a.state, a.country, "
			+ "s.mail_id, s.gender, s.blood_group, s.grade, s.house "
			+ "FROM student s JOIN address a ON s.address_id = a.address_id "
			+ "JOIN student_teacher st ON s.student_id = st.student_id " + "WHERE st.teacher_id = ?";

	// Query to get all teachers
	public static final String GET_ALL_TEACHERS = "SELECT t.teacher_id, t.teacher_name, t.date_of_birth, t.date_of_joining, t.contact, a.door_no, a.street, a.city, a.district, a.pincode, a.state, a.country, t.mail_id, t.gender, t.blood_group, t.experience, t.salary, t.department, t.subject_start "
			+ "FROM teacher t JOIN address a ON t.address_id = a.address_id";
	public static final String UPDATE_TEACHER = "UPDATE teacher SET teacher_name = ?, date_of_birth = ?, date_of_joining = ?, contact = ?, mail_id = ?, gender = ?, blood_group = ?, experience = ?, salary = ?, department = ?, subject_start = ?, address_id = ? WHERE teacher_id = ?";
	public static final String DELETE_TEACHER = "DELETE FROM teacher WHERE teacher_id = ?";

	public static final String DELETE_ADDRESS = "DELETE FROM address WHERE address_id = (SELECT address_id FROM teacher WHERE teacher_id = ?)"; // Adjust
																																				// according
	public static final String ASSIGN_STUDENTS_TO_TEACHER = "INSERT INTO student_teacher (teacher_id, student_id) VALUES (?, ?)";
	public static final String INSERT_EXAM = "INSERT INTO Exam (exam_name, exam_date, subject) VALUES (?, ?, ?)";
	public static final String SELECT_EXAM_BY_ID = "SELECT exam_id, exam_name, exam_date, subject FROM exam WHERE exam_id = ?";
	public static final String SELECT_ALL_EXAMS = "SELECT exam_id, exam_name, exam_date, subject FROM exam";
	public static final String UPDATE_EXAM = "UPDATE exam SET exam_name = ?, exam_date = ?, subject = ? WHERE exam_id = ?";
	public static final String DELETE_EXAM = "DELETE FROM exam WHERE exam_id = ?";
	public static final String DELETE_STUDENT_EXAM_RELATIONS = "DELETE FROM student_exam WHERE exam_id = ?";

	public static final String INSERT_STUDENT_EXAM_RELATION = "INSERT INTO student_exam (exam_id, student_id) VALUES (?, ?)";
	public static final String DELETE_TEACHER_EXAM_RELATIONS = "DELETE FROM teacher_exam WHERE exam_id = ?";

	public static final String INSERT_TEACHER_EXAM_RELATION = "INSERT INTO teacher_exam (exam_id, teacher_id) VALUES (?, ?)";
	public static final String GET_STUDENTS_BY_EXAM_ID = "SELECT s.student_id, s.student_name, s.date_of_birth, s.date_of_joining, "
			+ "s.parent_contact, a.door_no, a.street, a.city, a.district, a.pincode, "
			+ "a.state, a.country, s.gender, s.blood_group " + "FROM student s "
			+ "JOIN student_exam se ON s.student_id = se.student_id " + "JOIN address a ON s.address_id = a.address_id "
			+ "WHERE se.exam_id = ?";
	public static final String GET_TEACHERS_BY_EXAM_ID = "SELECT t.teacher_id, t.teacher_name, t.date_of_birth, t.date_of_joining, "
			+ "t.contact, a.door_no, a.street, a.city, a.district, a.pincode, "
			+ "a.state, a.country, t.gender, t.blood_group, t.subject " + "FROM teacher t "
			+ "JOIN teacher_exam te ON t.teacher_ids = te.teacher_id "
			+ "JOIN address a ON t.address_id = a.address_id " + "WHERE te.exam_id = ?";
	public static final String SELECT_EXAMS_BY_STUDENT_ID = "SELECT e.exam_id, e.exam_name, e.exam_date, e.subject "
			+ "FROM exam e " + "JOIN student_exam se ON e.exam_id = se.exam_id " + "WHERE se.student_id = ?";
	public static final String SELECT_EXAMS_BY_DATE = "SELECT exam_id, exam_name, exam_date, subject " + "FROM exam "
			+ "WHERE exam_date = ?";
	public static final String CALCULATE_TOTAL_MARKS_BY_STUDENT_ID = "SELECT SUM(marks) AS total_marks "
			+ "FROM student_exam " + "WHERE student_id = ?";
}
