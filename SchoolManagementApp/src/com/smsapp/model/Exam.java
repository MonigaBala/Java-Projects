package com.smsapp.model;

import java.sql.Date;
import java.util.List;

/**
 * Represents an exam in the School Management System.
 * <p>
 * This class includes details about the exam such as the exam ID, name, date,
 * subject, and the list of students and teachers associated with the exam.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class Exam {
	private int examId;
	private String examName;
	private Date examDate;
	private Subject subject;
	private List<Student> students;
	private List<Teacher> teachers;

	/**
	 * Default constructor.
	 */
	public Exam() {
		super();
	}

	/**
	 * Parameterized constructor to initialize an Exam with all fields.
	 * 
	 * @param examId   the ID of the exam
	 * @param examName the name of the exam
	 * @param examDate the date of the exam
	 * @param subject  the subject of the exam
	 * @param students the list of students associated with the exam
	 * @param teachers the list of teachers associated with the exam
	 */
	public Exam(int examId, String examName, Date examDate, Subject subject, List<Student> students,
			List<Teacher> teachers) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDate = examDate;
		this.subject = subject;
		this.students = students;
		this.teachers = teachers;
	}

	/**
	 * Gets the ID of the exam.
	 * 
	 * @return the exam ID
	 */
	public int getExamId() {
		return examId;
	}

	/**
	 * Sets the ID of the exam.
	 * 
	 * @param examId the exam ID to set
	 */
	public void setExamId(int examId) {
		this.examId = examId;
	}

	/**
	 * Gets the name of the exam.
	 * 
	 * @return the exam name
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * Sets the name of the exam.
	 * 
	 * @param examName the exam name to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}

	/**
	 * Gets the date of the exam.
	 * 
	 * @return the exam date
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * Sets the date of the exam.
	 * 
	 * @param examDate the exam date to set
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	/**
	 * Gets the subject of the exam.
	 * 
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the subject of the exam.
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Gets the list of students associated with the exam.
	 * 
	 * @return the list of students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Sets the list of students associated with the exam.
	 * 
	 * @param students the list of students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Gets the list of teachers associated with the exam.
	 * 
	 * @return the list of teachers
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}

	/**
	 * Sets the list of teachers associated with the exam.
	 * 
	 * @param teachers the list of teachers to set
	 */
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * Returns a string representation of the exam.
	 * 
	 * @return a string representation of the exam
	 */
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", examDate=" + examDate + ", subject=" + subject
				+ ", students=" + students + ", teachers=" + teachers + "]";
	}
}
