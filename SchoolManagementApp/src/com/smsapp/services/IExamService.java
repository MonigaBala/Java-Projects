package com.smsapp.services;

import java.util.List;

import com.smsapp.model.Exam;

public interface IExamService {

	void addExam(Exam exam);

	List<Exam> getAllExams();

	Exam getExamByExamId(int examId);

	List<Exam> getExamsByStudentId(int studentId);

	List<Exam> getExamsBySubject(String subject);

	List<Exam> getTotalExamMarks(int... mark);

	void updateExam(Exam exam, Exam examId);

	void deleteExam(int examId);

}
