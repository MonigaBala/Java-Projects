package com.smsapp.model;

import java.util.Date;
import java.util.List;

public class Student {

	private int studentId;
	private String studentName;
	private Date dateOfBirth;
	private int parentContact;
	private String mailId;
	private Address address;
	private BloodGroup bloodGroup;
	private int grade;
	private Date dateOfJoining;
	private Teacher mentor;
	private List<Teacher> teachersAssigned;
	private boolean isHosteller;
	private Gender gender;
	private String previousSchool;
	private String medicalConditions;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, Date dateOfBirth, int parentContact, String mailId,
			Address address, BloodGroup bloodGroup, int grade, Date dateOfJoining, Teacher mentor,
			List<Teacher> teachersAssigned, boolean isHosteller, Gender gender, String previousSchool,
			String medicalConditions) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.parentContact = parentContact;
		this.mailId = mailId;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.grade = grade;
		this.dateOfJoining = dateOfJoining;
		this.mentor = mentor;
		this.teachersAssigned = teachersAssigned;
		this.isHosteller = isHosteller;
		this.gender = gender;
		this.previousSchool = previousSchool;
		this.medicalConditions = medicalConditions;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getParentContact() {
		return parentContact;
	}

	public void setParentContact(int parentContact) {
		this.parentContact = parentContact;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Teacher getMentor() {
		return mentor;
	}

	public void setMentor(Teacher mentor) {
		this.mentor = mentor;
	}

	public List<Teacher> getTeachersAssigned() {
		return teachersAssigned;
	}

	public void setTeachersAssigned(List<Teacher> teachersAssigned) {
		this.teachersAssigned = teachersAssigned;
	}

	public boolean isHosteller() {
		return isHosteller;
	}

	public void setHosteller(boolean isHosteller) {
		this.isHosteller = isHosteller;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getMedicalConditions() {
		return medicalConditions;
	}

	public void setMedicalConditions(String medicalConditions) {
		this.medicalConditions = medicalConditions;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth
				+ ", parentContact=" + parentContact + ", mailId=" + mailId + ", address=" + address + ", bloodGroup="
				+ bloodGroup + ", grade=" + grade + ", dateOfJoining=" + dateOfJoining + ", mentor=" + mentor
				+ ", teachersAssigned=" + teachersAssigned + ", isHosteller=" + isHosteller + ", gender=" + gender
				+ ", previousSchool=" + previousSchool + ", medicalConditions=" + medicalConditions + "]";
	}

}
