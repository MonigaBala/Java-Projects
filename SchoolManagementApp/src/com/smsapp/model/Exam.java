package com.smsapp.model;

import java.util.Date;
import java.util.List;

public class Exam {

	private int studentId;
	private String evaluatedBy;
	private int examId;
	private String subject;
	private Date examDate;
	private String examType;
	private int duration;
	private String instructor;
	private List<Subject> subjects;
	private String locationOfExam;
	public static final int MAX_MARKS = 100;
	private int marks;

	public Exam() {
		super();
	}

	public Exam(int studentId, String evaluatedBy, int examId, String subject, Date examDate, String examType,
			int duration, String instructor, List<Subject> subjects, String locationOfExam, int marks) {
		super();
		this.studentId = studentId;
		this.evaluatedBy = evaluatedBy;
		this.examId = examId;
		this.subject = subject;
		this.examDate = examDate;
		this.examType = examType;
		this.duration = duration;
		this.instructor = instructor;
		this.subjects = subjects;
		this.locationOfExam = locationOfExam;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getEvaluatedBy() {
		return evaluatedBy;
	}

	public void setEvaluatedBy(String evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getLocationOfExam() {
		return locationOfExam;
	}

	public void setLocationOfExam(String locationOfExam) {
		this.locationOfExam = locationOfExam;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public static int getMaxMarks() {
		return MAX_MARKS;
	}

	@Override
	public String toString() {
		return "Exam [studentId=" + studentId + ", evaluatedBy=" + evaluatedBy + ", examId=" + examId + ", subject="
				+ subject + ", examDate=" + examDate + ", examType=" + examType + ", duration=" + duration
				+ ", instructor=" + instructor + ", subjects=" + subjects + ", locationOfExam=" + locationOfExam
				+ ", marks=" + marks + "]";
	}

}
