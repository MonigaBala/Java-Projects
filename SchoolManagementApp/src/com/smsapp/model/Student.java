package com.smsapp.model;

import java.sql.Date;
import java.util.List;

/**
 * Represents a student in the School Management System.
 * <p>
 * This class provides the necessary fields and methods to manage student
 * information, including personal details, contact information, assigned
 * teachers, and enrolled exams.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class Student {
	private int studentId;
	private String studentName;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private int parentContact;
	private Address address;
	private String mailId;
	private Gender gender;
	private BloodGroup bloodGroup;
	private int grade;
	private String house;
	private List<Teacher> teachersAssigned;
	private List<Exam> exams;

	/**
	 * Default constructor.
	 */
	public Student() {
		super();
	}

	/**
	 * Parameterized constructor to initialize a student object with the provided
	 * values.
	 * 
	 * @param studentId        the unique ID of the student
	 * @param studentName      the name of the student
	 * @param dateOfBirth      the birth date of the student
	 * @param dateOfJoining    the joining date of the student
	 * @param parentContact    the contact number of the student's parent
	 * @param address          the address of the student
	 * @param mailId           the email ID of the student
	 * @param gender           the gender of the student
	 * @param bloodGroup       the blood group of the student
	 * @param grade            the grade/class of the student
	 * @param house            the house assigned to the student
	 * @param teachersAssigned the list of teachers assigned to the student
	 * @param exams            the list of exams the student is enrolled in
	 */
	public Student(int studentId, String studentName, Date dateOfBirth, Date dateOfJoining, int parentContact,
			Address address, String mailId, Gender gender, BloodGroup bloodGroup, int grade, String house,
			List<Teacher> teachersAssigned, List<Exam> exams) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.parentContact = parentContact;
		this.address = address;
		this.mailId = mailId;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.grade = grade;
		this.house = house;
		this.teachersAssigned = teachersAssigned;
		this.exams = exams;
	}

	/**
	 * Gets the student ID.
	 * 
	 * @return the student ID
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student ID.
	 * 
	 * @param studentId the new student ID
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the student name.
	 * 
	 * @return the student name
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Sets the student name.
	 * 
	 * @param studentName the new student name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Gets the date of birth.
	 * 
	 * @return the date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 * 
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the date of joining.
	 * 
	 * @return the date of joining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Sets the date of joining.
	 * 
	 * @param dateOfJoining the new date of joining
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the parent contact number.
	 * 
	 * @return the parent contact number
	 */
	public int getParentContact() {
		return parentContact;
	}

	/**
	 * Sets the parent contact number.
	 * 
	 * @param parentContact the new parent contact number
	 */
	public void setParentContact(int parentContact) {
		this.parentContact = parentContact;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the email ID.
	 * 
	 * @return the email ID
	 */
	public String getMailId() {
		return mailId;
	}

	/**
	 * Sets the email ID.
	 * 
	 * @param mailId the new email ID
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the blood group.
	 * 
	 * @return the blood group
	 */
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group.
	 * 
	 * @param bloodGroup the new blood group
	 */
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Gets the grade.
	 * 
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 * 
	 * @param grade the new grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * Gets the house.
	 * 
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * Sets the house.
	 * 
	 * @param house the new house
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * Gets the list of teachers assigned to the student.
	 * 
	 * @return the list of assigned teachers
	 */
	public List<Teacher> getTeachersAssigned() {
		return teachersAssigned;
	}

	/**
	 * Sets the list of teachers assigned to the student.
	 * 
	 * @param teachers the new list of assigned teachers
	 */
	public void setTeachersAssigned(List<Teacher> teachers) {
		this.teachersAssigned = teachers;
	}

	/**
	 * Gets the list of exams the student is enrolled in.
	 * 
	 * @return the list of exams
	 */
	public List<Exam> getExams() {
		return exams;
	}

	/**
	 * Sets the list of exams the student is enrolled in.
	 * 
	 * @param exams the new list of exams
	 */
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	/**
	 * Returns a string representation of the student object.
	 * 
	 * @return a string representation of the student object
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", parentContact=" + parentContact + ", address=" + address
				+ ", mailId=" + mailId + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", grade=" + grade
				+ ", house=" + house + ", teachersAssigned=" + teachersAssigned + ", exams=" + exams + "]";
	}
}
