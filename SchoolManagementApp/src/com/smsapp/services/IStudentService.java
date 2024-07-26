package com.smsapp.services;

import java.util.List;

import com.smsapp.model.Student;
import com.smsapp.model.Teacher;

public interface IStudentService {

	void admitStudent(Student student);

	List<Student> getAllStudents();

	List<Student> getStudentsByGrade(int grade);

	Student getStudentById(int studentId);

	List<Teacher> getTeachersAssigned(int studentId);

	void assignRandomHouses();

	void updateStudent(int grade, int studentId);

	void deleteStudent(int studentId);

}
