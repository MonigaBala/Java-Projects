package com.smsapp.services;

import java.util.List;

import com.smsapp.model.Student;
import com.smsapp.model.Teacher;

public interface IStudentService {

	void admitStudent(Student student);
	
	List<Student> retrieveStudentsByGrade(int grade);
	
	Student retrieveStudentById(int studentId);
	
	List<Teacher> retrieveTeachersAssigned(int studentId);
	
	void assignRandomHouses();
	
	void updateStudent(int studentId);
	
	void deleteStudent(int studentId);
	

}
