package com.smsapp.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.smsapp.exceptions.ExamNotFoundException;
import com.smsapp.exceptions.StudentNotFoundException;
import com.smsapp.exceptions.TeacherNotFoundException;
import com.smsapp.model.Address;
import com.smsapp.model.BloodGroup;
import com.smsapp.model.Department;
import com.smsapp.model.Exam;
import com.smsapp.model.Gender;
import com.smsapp.model.Student;
import com.smsapp.model.Subject;
import com.smsapp.model.Teacher;
import com.smsapp.services.implementations.ExamImpl;
import com.smsapp.services.implementations.StudentImpl;
import com.smsapp.services.implementations.TeacherImpl;
import com.smsapp.services.interfaces.IExam;

/**
 * The {@code Test} class is the main entry point for the School Management
 * System application. It provides a console-based user interface for
 * interacting with student, teacher, and exam records. This class includes
 * operations for adding, retrieving, updating, deleting, and managing students,
 * teachers, and exams, as well as assigning students and teachers to exams.
 * 
 * <p>
 * Usage: The user can select various options from a menu to perform different
 * operations. Each operation prompts the user for input and then invokes the
 * corresponding service methods.
 * 
 * @author MonigaBalasubramanian
 */
public class Test {
	// Service instances for handling student, teacher, and exam operations
	private static final StudentImpl studentService = new StudentImpl();
	private static final TeacherImpl teacherService = new TeacherImpl();
	private static final IExam examService = new ExamImpl();

	// Scanner for reading user input
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * The main method that displays the menu and handles user input. It
	 * continuously prompts the user for choices and performs the corresponding
	 * actions. The menu includes options for managing students, teachers, exams,
	 * and their associations.
	 *
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("\n--- School Management System ---");
			System.out.println("1. Add Student");
			System.out.println("2. Get Student by ID");
			System.out.println("3. Get All Students");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Assign Random House");
			System.out.println("7. Add Teacher");
			System.out.println("8. Get Teacher by ID");
			System.out.println("9. Get All Teachers");
			System.out.println("10. Update Teacher");
			System.out.println("11. Delete Teacher");
			System.out.println("12. Assign Students to Teacher");
			System.out.println("13. Add Exam");
			System.out.println("14. Update Exam");
			System.out.println("15. Delete Exam");
			System.out.println("16. Assign Students to Exam");
			System.out.println("17. Assign Teachers to Exam");
			System.out.println("18. Get Exam by ID");
			System.out.println("19. Get Students by Exam ID");
			System.out.println("20. Get Teachers by Exam ID");
			System.out.println("21. Delete Exam Relations");
			System.out.println("22. Get Exams by Student ID");
			System.out.println("23. Get Exams by Date");
			System.out.println("24. Calculate Total Exam Marks for Student");
			System.out.println("25. Get All Exams");
			System.out.println("26. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				getStudentById();
				break;
			case 3:
				getAllStudents();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				assignRandomHouse();
				break;
			case 7:
				addTeacher();
				break;
			case 8:
				getTeacherById();
				break;
			case 9:
				getAllTeachers();
				break;
			case 10:
				updateTeacher();
				break;
			case 11:
				deleteTeacher();
				break;
			case 12:
				assignStudentsToTeacher();
				break;
			case 13:
				addExam();
				break;
			case 14:
				updateExam();
				break;
			case 15:
				deleteExam();
				break;
			case 16:
				assignStudentsToExam();
				break;
			case 17:
				assignTeachersToExam();
				break;
			case 18:
				getExamById();
				break;
			case 19:
				getStudentsByExamId();
				break;
			case 20:
				getTeachersByExamId();
				break;
			case 21:
				deleteExamRelations();
				break;
			case 22:
				getExamsByStudentId();
				break;
			case 23:
				getExamsByDate();
				break;
			case 24:
				calculateTotalExamMarksForStudent();
				break;
			case 25:
				getAllExams();
			case 26:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choice != 26);
	}

	/**
	 * Prompts the user for student details and adds a new student using the
	 * {@link StudentImpl} service. Handles input validation and errors.
	 */
	private static void addStudent() {
		try {
			System.out.print("Enter Student ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Student Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
			Date dob = Date.valueOf(scanner.nextLine());

			System.out.print("Enter Date of Joining (yyyy-mm-dd): ");
			Date doj = Date.valueOf(scanner.nextLine());

			System.out.print("Enter Parent Contact: ");
			int parentContact = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Mail ID: ");
			String mailId = scanner.nextLine();

			System.out.print("Enter Gender (MALE/FEMALE/OTHER): ");
			Gender gender = Gender.fromValue(scanner.nextLine().toUpperCase());

			System.out.print("Enter Blood Group (B+ve/A+ve/O-ve/...): ");
			BloodGroup bloodGroup = BloodGroup.fromValue(scanner.nextLine());

			System.out.print("Enter Grade: ");
			int grade = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter House: ");
			String house = scanner.nextLine();

			System.out.print("Enter Address Door No: ");
			String doorNo = scanner.nextLine();

			System.out.print("Enter Address Street: ");
			String street = scanner.nextLine();

			System.out.print("Enter Address City: ");
			String city = scanner.nextLine();

			System.out.print("Enter Address District: ");
			String district = scanner.nextLine();

			System.out.print("Enter Address Pincode: ");
			int pincode = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			System.out.print("Enter Address State: ");
			String state = scanner.nextLine();

			System.out.print("Enter Address Country: ");
			String country = scanner.nextLine();

			List<Teacher> teachers = new ArrayList<>();
			List<Exam> exams = new ArrayList<>();

			Address address = new Address.Builder().doorNo(doorNo).street(street).city(city).district(district)
					.pincode(pincode).state(state).country(country).build();

			Student student = new Student(id, name, dob, doj, parentContact, address, mailId, gender, bloodGroup, grade,
					house, teachers, exams);
			studentService.addStudent(student);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data types.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for a student ID and retrieves the student details using the
	 * {@link StudentImpl} service. Displays the student information.
	 */
	private static void getStudentById() {
		try {
			System.out.print("Enter Student ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			Student student = studentService.getStudentById(id);
			System.out.println(student);
		} catch (StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data types.");
			scanner.nextLine();
		}
	}

	/**
	 * Retrieves and displays all students using the {@link StudentImpl} service.
	 */
	private static void getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}

	/**
	 * Prompts the user for student details and updates the existing student using
	 * the {@link StudentImpl} service. Handles input validation and errors.
	 */
	private static void updateStudent() {
		try {
			System.out.print("Enter Student ID to Update: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Student Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
			Date dob = Date.valueOf(scanner.nextLine());

			System.out.print("Enter Date of Joining (yyyy-mm-dd): ");
			Date doj = Date.valueOf(scanner.nextLine());

			System.out.print("Enter Parent Contact: ");
			int parentContact = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Mail ID: ");
			String mailId = scanner.nextLine();

			System.out.print("Enter Gender (MALE/FEMALE/OTHER): ");
			Gender gender = Gender.fromValue(scanner.nextLine().toUpperCase());

			System.out.print("Enter Blood Group (B+ve/A+ve/O-ve/...): ");
			BloodGroup bloodGroup = BloodGroup.fromValue(scanner.nextLine());

			System.out.print("Enter Grade: ");
			int grade = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter House: ");
			String house = scanner.nextLine();

			System.out.print("Enter Address Door No: ");
			String doorNo = scanner.nextLine();

			System.out.print("Enter Address Street: ");
			String street = scanner.nextLine();

			System.out.print("Enter Address City: ");
			String city = scanner.nextLine();

			System.out.print("Enter Address District: ");
			String district = scanner.nextLine();

			System.out.print("Enter Address Pincode: ");
			int pincode = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Address State: ");
			String state = scanner.nextLine();

			System.out.print("Enter Address Country: ");
			String country = scanner.nextLine();

			Address address = new Address.Builder().doorNo(doorNo).street(street).city(city).district(district)
					.pincode(pincode).state(state).country(country).build();

			List<Teacher> teachers = new ArrayList<>();
			List<Exam> exams = new ArrayList<>();

			Student student = new Student(id, name, dob, doj, parentContact, address, mailId, gender, bloodGroup, grade,
					house, teachers, exams);
			studentService.updateStudent(student);
		} catch (StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data types.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for a student ID and deletes the student using the
	 * {@link StudentImpl} service. Handles input validation and errors.
	 */
	private static void deleteStudent() {
		try {
			System.out.print("Enter Student ID to Delete: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			studentService.deleteStudent(id);
		} catch (StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data types.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for a student ID and assigns a random house to the student
	 * using the {@link StudentImpl} service. Handles input validation and errors.
	 */
	private static void assignRandomHouse() {
		try {
			System.out.print("Enter Student ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			studentService.assignRandomHouse(id);
			System.out.println("Random house assigned successfully.");
		} catch (StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data types.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for teacher details and adds a new teacher using the
	 * {@link TeacherImpl} service. Handles input validation and errors.
	 */
	private static void addTeacher() {
		System.out.print("Enter Teacher ID: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter Teacher Name: ");
		String teacherName = scanner.nextLine();

		System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
		Date dateOfBirth = Date.valueOf(scanner.nextLine());

		System.out.print("Enter Date of Joining (YYYY-MM-DD): ");
		Date dateOfJoining = Date.valueOf(scanner.nextLine());

		System.out.print("Enter Contact Number: ");
		long contact = scanner.nextLong();
		scanner.nextLine();

		System.out.print("Enter Email ID: ");
		String mailId = scanner.nextLine();

		System.out.print("Enter Gender (MALE, FEMALE, OTHER): ");
		Gender gender = Gender.fromValue(scanner.nextLine().toUpperCase());

		System.out.print("Enter Blood Group (B+ve, A+ve, O+ve, etc.): ");
		BloodGroup bloodGroup = BloodGroup.fromValue(scanner.nextLine().toUpperCase());

		System.out.print("Enter Experience (in years): ");
		int experience = scanner.nextInt();

		System.out.print("Enter Salary: ");
		double salary = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Enter Department (MATHEMATICS, SCIENCE, etc.): ");
		Department department = Department.fromValue(scanner.nextLine().toUpperCase());

		System.out.print("Enter Subject Start (MATHEMATICS, SCIENCE, etc.): ");
		Subject subjectStart = Subject.fromValue(scanner.nextLine().toUpperCase());

		System.out.print("Enter Door Number: ");
		String doorNo = scanner.nextLine();

		System.out.print("Enter Street: ");
		String street = scanner.nextLine();

		System.out.print("Enter City: ");
		String city = scanner.nextLine();

		System.out.print("Enter District: ");
		String district = scanner.nextLine();

		System.out.print("Enter Pincode: ");
		int pincode = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter State: ");
		String state = scanner.nextLine();

		System.out.print("Enter Country: ");
		String country = scanner.nextLine();

		Address address = new Address.Builder().doorNo(doorNo).street(street).city(city).district(district)
				.pincode(pincode).state(state).country(country).build();
		List<Student> students = new ArrayList<Student>();

		Teacher teacher = new Teacher(teacherId, teacherName, dateOfBirth, dateOfJoining, contact, address, mailId,
				gender, bloodGroup, experience, salary, department, students, subjectStart);

		try {
			teacherService.addTeacher(teacher);
		} catch (Exception e) {
			System.out.println("Error adding teacher: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for a teacher ID and retrieves the teacher details using the
	 * {@link TeacherImpl} service. Displays the teacher information.
	 */
	private static void getTeacherById() {
		System.out.print("Enter Teacher ID: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine();

		try {
			Teacher teacher = teacherService.getTeacherById(teacherId);
			System.out.println("Teacher Details: " + teacher);
		} catch (TeacherNotFoundException e) {
			System.out.println("Teacher not found: " + e.getMessage());
		}
	}

	/**
	 * Retrieves and displays all teachers using the {@link TeacherImpl} service.
	 */
	private static void getAllTeachers() {
		try {
			List<Teacher> teachers = teacherService.getAllTeachers();
			for (Teacher teacher : teachers) {
				System.out.println(teacher);
			}
		} catch (Exception e) {
			System.out.println("Error retrieving teachers: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for teacher details and updates the existing teacher using
	 * the {@link TeacherImpl} service. Handles input validation and errors.
	 */
	private static void updateTeacher() {
		System.out.print("Enter Teacher ID to Update: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine();

		try {
			Teacher teacher = teacherService.getTeacherById(teacherId);

			System.out.print("Enter new Teacher Name: ");
			teacher.setTeacherName(scanner.nextLine());

			System.out.print("Enter new Date of Birth (YYYY-MM-DD): ");
			teacher.setDateOfBirth(java.sql.Date.valueOf(scanner.nextLine()));

			System.out.print("Enter new Date of Joining (YYYY-MM-DD): ");
			teacher.setDateOfJoining(java.sql.Date.valueOf(scanner.nextLine()));

			System.out.print("Enter new Contact Number: ");
			teacher.setContact(scanner.nextLong());
			scanner.nextLine();

			System.out.print("Enter new Email ID: ");
			teacher.setMailId(scanner.nextLine());

			System.out.print("Enter new Gender (MALE, FEMALE, OTHER): ");
			teacher.setGender(Gender.fromValue(scanner.nextLine().toUpperCase()));

			System.out.print("Enter new Blood Group (B+ve, A+ve, O+ve, etc.): ");
			teacher.setBloodGroup(BloodGroup.fromValue(scanner.nextLine().toUpperCase()));

			System.out.print("Enter new Experience (in years): ");
			teacher.setExperience(scanner.nextInt());

			System.out.print("Enter new Salary: ");
			teacher.setSalary(scanner.nextDouble());
			scanner.nextLine();

			System.out.print("Enter new Department (MATHEMATICS, SCIENCE, etc.): ");
			teacher.setDepartment(Department.fromValue(scanner.nextLine().toUpperCase()));

			System.out.print("Enter new Subject Start (MATHEMATICS, SCIENCE, etc.): ");
			teacher.setSubjectStart(Subject.fromValue(scanner.nextLine().toUpperCase()));

			System.out.print("Enter Address Door No: ");
			String doorNo = scanner.nextLine();

			System.out.print("Enter Address Street: ");
			String street = scanner.nextLine();

			System.out.print("Enter Address City: ");
			String city = scanner.nextLine();

			System.out.print("Enter Address District: ");
			String district = scanner.nextLine();

			System.out.print("Enter Address Pincode: ");
			int pincode = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Address State: ");
			String state = scanner.nextLine();

			System.out.print("Enter Address Country: ");
			String country = scanner.nextLine();

			Address address = new Address.Builder().doorNo(doorNo).street(street).city(city).district(district)
					.pincode(pincode).state(state).country(country).build();
			teacher.setAddress(address);
			List<Student> students = new ArrayList<Student>();
			teacher.setStudents(students);
			teacherService.updateTeacher(teacher);
		} catch (TeacherNotFoundException e) {
			System.out.println("Teacher not found: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for a teacher ID and deletes the teacher using the
	 * {@link TeacherImpl} service. Handles input validation and errors.
	 */
	private static void deleteTeacher() {
		System.out.print("Enter Teacher ID to Delete: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine();

		try {
			teacherService.deleteTeacher(teacherId);
		} catch (TeacherNotFoundException e) {
			System.out.println("Teacher not found: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for student IDs and assigns them to a teacher using the
	 * {@link TeacherImpl} service. Handles input validation and errors.
	 */
	private static void assignStudentsToTeacher() {
		System.out.print("Enter Teacher ID: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter Student IDs (comma separated): ");
		String[] studentIdsStr = scanner.nextLine().split(",");
		List<Integer> studentIds = new ArrayList<>();
		for (String idStr : studentIdsStr) {
			studentIds.add(Integer.parseInt(idStr.trim()));
		}

		try {
			teacherService.assignStudentsToTeacher(teacherId, studentIds);
		} catch (TeacherNotFoundException e) {
			System.out.println("Teacher not found: " + e.getMessage());
		}
	}

	/**
	 * Prompts the user for exam details and adds a new exam using the
	 * {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void addExam() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Exam Name:");
		String examName = scanner.nextLine();
		System.out.println("Enter Exam Date (yyyy-mm-dd):");
		Date examDate = Date.valueOf(scanner.nextLine());
		System.out.println("Enter Subject:");
		Subject subject = Subject.fromValue(scanner.nextLine().toUpperCase());

		List<Student> students = new ArrayList<Student>();
		List<Teacher> teachers = new ArrayList<Teacher>();
		Exam exam = new Exam(examId, examName, examDate, subject, students, teachers);
		examService.addExam(exam);
	}

	/**
	 * Prompts the user for exam details and updates the existing exam using the
	 * {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void updateExam() {
		System.out.println("Enter Exam ID to update:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			Exam exam = examService.getExamById(examId);
			System.out.println("Enter new Exam Name:");
			String examName = scanner.nextLine();
			System.out.println("Enter new Exam Date (yyyy-mm-dd):");
			Date examDate = Date.valueOf(scanner.nextLine());
			System.out.println("Enter new Subject:");
			Subject subject = Subject.fromValue(scanner.nextLine().toUpperCase());

			exam.setExamName(examName);
			exam.setExamDate(examDate);
			exam.setSubject(subject);

			examService.updateExam(exam);
			System.out.println("Exam updated successfully.");
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for an exam ID and deletes the exam using the
	 * {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void deleteExam() {
		System.out.println("Enter Exam ID to delete:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			examService.deleteExam(examId);
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for student IDs and assigns them to an exam using the
	 * {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void assignStudentsToExam() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Student IDs (comma separated):");
		String[] studentIds = scanner.nextLine().split(",");
		List<Integer> studentIdList = new ArrayList<>();
		for (String id : studentIds) {
			studentIdList.add(Integer.parseInt(id.trim()));
		}

		try {
			examService.assignStudentsToExam(examId, studentIdList);
			System.out.println("Students assigned to exam successfully.");
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for teacher IDs and assigns them to an exam using the
	 * {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void assignTeachersToExam() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Teacher IDs (comma separated):");
		String[] teacherIds = scanner.nextLine().split(",");
		List<Integer> teacherIdList = new ArrayList<>();
		for (String id : teacherIds) {
			teacherIdList.add(Integer.parseInt(id.trim()));
		}

		try {
			examService.assignTeachersToExam(examId, teacherIdList);
			System.out.println("Teachers assigned to exam successfully.");
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for an exam ID and retrieves the exam details using the
	 * {@link ExamImpl} service. Displays the exam information.
	 */
	private static void getExamById() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			Exam exam = examService.getExamById(examId);
			System.out.println("Exam Details: " + exam);
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for an exam ID and retrieves the students associated with
	 * the exam using the {@link ExamImpl} service. Displays the student
	 * information.
	 */
	private static void getStudentsByExamId() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			List<Student> students = examService.getStudentsByExamId(examId);
			System.out.println("Students in Exam: " + students);
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for an exam ID and retrieves the teachers associated with
	 * the exam using the {@link ExamImpl} service. Displays the teacher
	 * information.
	 */
	private static void getTeachersByExamId() {
		System.out.println("Enter Exam ID:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			List<Teacher> teachers = examService.getTeachersByExamId(examId);
			System.out.println("Teachers in Exam: " + teachers);
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for an exam ID and deletes the relations of the exam using
	 * the {@link ExamImpl} service. Handles input validation and errors.
	 */
	private static void deleteExamRelations() {
		System.out.println("Enter Exam ID to delete relations:");
		int examId = scanner.nextInt();
		scanner.nextLine();

		try {
			examService.deleteExamRelations(examId);
			System.out.println("Exam relations deleted successfully.");
		} catch (ExamNotFoundException e) {
			System.out.println("Exam not found.");
		}
	}

	/**
	 * Prompts the user for a student ID and retrieves the exams associated with the
	 * student using the {@link ExamImpl} service. Displays the exam information.
	 */
	private static void getExamsByStudentId() {
		System.out.println("Enter Student ID:");
		int studentId = scanner.nextInt();
		scanner.nextLine();

		List<Exam> exams = examService.getExamsByStudentId(studentId);
		System.out.println("Exams for Student: " + exams);
	}

	/**
	 * Prompts the user for a date and retrieves the exams occurring on that date
	 * using the {@link ExamImpl} service. Displays the exam information.
	 */
	private static void getExamsByDate() {
		System.out.println("Enter Exam Date (yyyy-mm-dd):");
		Date examDate = Date.valueOf(scanner.nextLine());

		List<Exam> exams = examService.getExamsByDate(examDate);
		System.out.println("Exams on Date: " + exams);
	}

	/**
	 * Prompts the user for a student ID and calculates the total exam marks for the
	 * student using the {@link ExamImpl} service. Displays the total marks.
	 */
	private static void calculateTotalExamMarksForStudent() {
		System.out.println("Enter Student ID:");
		int studentId = scanner.nextInt();
		scanner.nextLine();

		double totalMarks = examService.calculateTotalExamMarksForStudent(studentId);
		System.out.println("Total Exam Marks for Student: " + totalMarks);
	}

	/**
	 * Retrieves and displays all exams using the {@link ExamImpl} service.
	 */

	private static void getAllExams() {
		List<Exam> exams = examService.getAllExams();
		System.out.println("All Exams:");
		for (Exam exam : exams) {
			System.out.println(exam);
		}
	}

}
