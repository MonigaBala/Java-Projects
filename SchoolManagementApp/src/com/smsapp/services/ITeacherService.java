package com.smsapp.services;

import java.util.List;

import com.smsapp.model.Department;
import com.smsapp.model.Teacher;

public interface ITeacherService {

	void joinTeacher(Teacher teacher);

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(int teacherId);

	List<Teacher> getTeachersByDepartment(Department department);

	List<Teacher> getTeachersBySubject(String subject);

	List<Teacher> getTeachersByExperience(int yearsOfExperience);

	void updateTeacher(double salary, int teacherId);

	void deleteTeacher(int teacherId);
}
