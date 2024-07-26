package com.smsapp.model;

import java.util.Date;
import java.util.List;

public class Teacher {

	private int teacherId;
	private String teacherName;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private int contact;
	private Address address;
	private String mailId;
	private Gender gender;
	private int yearsOfExperience;
	private double salary;
	List<Student> studentsAssigned;
	List<String> degree;
	List<String> certifications;
	List<String> languagesSpoken;
	Subject subjectStart;

	public Teacher() {
		super();
	}

	public Teacher(int teacherId, String teacherName, Date dateOfBirth, Date dateOfJoining, int contact,
			Address address, String mailId, Gender gender, int yearsOfExperience, double salary,
			List<Student> studentsAssigned, List<String> degree, List<String> certifications,
			List<String> languagesSpoken, Subject subjectStart) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.contact = contact;
		this.address = address;
		this.mailId = mailId;
		this.gender = gender;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
		this.studentsAssigned = studentsAssigned;
		this.degree = degree;
		this.certifications = certifications;
		this.languagesSpoken = languagesSpoken;
		this.subjectStart = subjectStart;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Student> getStudentsAssigned() {
		return studentsAssigned;
	}

	public void setStudentsAssigned(List<Student> studentsAssigned) {
		this.studentsAssigned = studentsAssigned;
	}

	public List<String> getDegree() {
		return degree;
	}

	public void setDegree(List<String> degree) {
		this.degree = degree;
	}

	public List<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}

	public List<String> getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(List<String> languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	public Subject getSubjectStart() {
		return subjectStart;
	}

	public void setSubjectStart(Subject subjectStart) {
		this.subjectStart = subjectStart;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", contact=" + contact + ", address=" + address + ", mailId="
				+ mailId + ", gender=" + gender + ", yearsOfExperience=" + yearsOfExperience + ", salary=" + salary
				+ ", studentsAssigned=" + studentsAssigned + ", degree=" + degree + ", certifications=" + certifications
				+ ", languagesSpoken=" + languagesSpoken + ", subjectStart=" + subjectStart + "]";
	}

}
