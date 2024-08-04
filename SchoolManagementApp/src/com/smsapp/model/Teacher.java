package com.smsapp.model;

import java.util.Date;
import java.util.List;

/**
 * Represents a teacher in the school management system.
 * <p>
 * This class encapsulates details about a teacher, including personal
 * information, contact details, employment details, and associations with
 * students and subjects.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class Teacher {

	private int teacherId;
	private String teacherName;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private long contact;
	private Address address;
	private String mailId;
	private Gender gender;
	private BloodGroup bloodGroup;
	private int experience;
	private double salary;
	private Department department;
	private List<Student> students;
	private Subject subjectStart;

	/**
	 * Default constructor.
	 */
	public Teacher() {
		super();
	}

	/**
	 * Parameterized constructor to initialize a Teacher instance with the provided
	 * values.
	 * 
	 * @param teacherId     the unique ID of the teacher
	 * @param teacherName   the name of the teacher
	 * @param dateOfBirth   the date of birth of the teacher
	 * @param dateOfJoining the date the teacher joined
	 * @param contact       the contact number of the teacher
	 * @param address       the address of the teacher
	 * @param mailId        the email ID of the teacher
	 * @param gender        the gender of the teacher
	 * @param bloodGroup    the blood group of the teacher
	 * @param experience    the experience of the teacher in years
	 * @param salary        the salary of the teacher
	 * @param department    the department of the teacher
	 * @param students      the list of students assigned to the teacher
	 * @param subjectStart  the main subject taught by the teacher
	 */
	public Teacher(int teacherId, String teacherName, Date dateOfBirth, Date dateOfJoining, long contact,
			Address address, String mailId, Gender gender, BloodGroup bloodGroup, int experience, double salary,
			Department department, List<Student> students, Subject subjectStart) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.contact = contact;
		this.address = address;
		this.mailId = mailId;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.experience = experience;
		this.salary = salary;
		this.department = department;
		this.students = students;
		this.subjectStart = subjectStart;
	}

	/**
	 * Gets the unique ID of the teacher.
	 * 
	 * @return the unique ID of the teacher
	 */
	public int getTeacherId() {
		return teacherId;
	}

	/**
	 * Sets the unique ID of the teacher.
	 * 
	 * @param teacherId the unique ID of the teacher
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * Gets the name of the teacher.
	 * 
	 * @return the name of the teacher
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * Sets the name of the teacher.
	 * 
	 * @param teacherName the name of the teacher
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * Gets the date of birth of the teacher.
	 * 
	 * @return the date of birth of the teacher
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth of the teacher.
	 * 
	 * @param dateOfBirth the date of birth of the teacher
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the date the teacher joined.
	 * 
	 * @return the date the teacher joined
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Sets the date the teacher joined.
	 * 
	 * @param dateOfJoining the date the teacher joined
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the contact number of the teacher.
	 * 
	 * @return the contact number of the teacher
	 */
	public long getContact() {
		return contact;
	}

	/**
	 * Sets the contact number of the teacher.
	 * 
	 * @param contact the contact number of the teacher
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}

	/**
	 * Gets the address of the teacher.
	 * 
	 * @return the address of the teacher
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address of the teacher.
	 * 
	 * @param address the address of the teacher
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the email ID of the teacher.
	 * 
	 * @return the email ID of the teacher
	 */
	public String getMailId() {
		return mailId;
	}

	/**
	 * Sets the email ID of the teacher.
	 * 
	 * @param mailId the email ID of the teacher
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	/**
	 * Gets the gender of the teacher.
	 * 
	 * @return the gender of the teacher
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the teacher.
	 * 
	 * @param gender the gender of the teacher
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the blood group of the teacher.
	 * 
	 * @return the blood group of the teacher
	 */
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group of the teacher.
	 * 
	 * @param bloodGroup the blood group of the teacher
	 */
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Gets the experience of the teacher in years.
	 * 
	 * @return the experience of the teacher in years
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the experience of the teacher in years.
	 * 
	 * @param experience the experience of the teacher in years
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets the salary of the teacher.
	 * 
	 * @return the salary of the teacher
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary of the teacher.
	 * 
	 * @param salary the salary of the teacher
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * Gets the department of the teacher.
	 * 
	 * @return the department of the teacher
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets the department of the teacher.
	 * 
	 * @param department the department of the teacher
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Gets the list of students assigned to the teacher.
	 * 
	 * @return the list of students assigned to the teacher
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Sets the list of students assigned to the teacher.
	 * 
	 * @param students the list of students assigned to the teacher
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Gets the main subject taught by the teacher.
	 * 
	 * @return the main subject taught by the teacher
	 */
	public Subject getSubjectStart() {
		return subjectStart;
	}

	/**
	 * Sets the main subject taught by the teacher.
	 * 
	 * @param subjectStart the main subject taught by the teacher
	 */
	public void setSubjectStart(Subject subjectStart) {
		this.subjectStart = subjectStart;
	}

	/**
	 * Returns a string representation of the Teacher object.
	 * 
	 * @return a string representation of the Teacher object
	 */
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", contact=" + contact + ", address=" + address + ", mailId="
				+ mailId + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", experience=" + experience
				+ ", salary=" + salary + ", department=" + department + ", students=" + students + ", subjectStart="
				+ subjectStart + "]";
	}

}
