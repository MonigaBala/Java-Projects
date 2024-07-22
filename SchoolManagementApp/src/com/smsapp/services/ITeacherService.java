package com.smsapp.services;

import java.util.List;

import com.smsapp.model.Teacher;

public interface ITeacherService {
	
	void joinTeacher(Teacher teacher);
	
	Teacher retrieveTeacherById(int teacherId);
	
	List<Teacher> retrieveTeachersByDepartment(String department);
	
	void updateTeacher(int teacherId);
	
	void deleteTeacher(int teacherId);
	

}
