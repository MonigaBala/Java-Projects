package com.smsapp.util;

public class Queries {

	public static final String SELECT_QUERY_STUDENT = "SELECT * FROM student";

	public static final String SELECT_OUERY_STUDENT_GRADE = "SELECT * FROM student WHERE grade =?";

	public static final String SELECT_OUERY_STUDENT_ID = "SELECT * FROM student WHERE studentId =?";

	public static final String INSERT_QUERY_STUDENT = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	public static final String UPDATE_QUERY_STUDENT = "UPDATE student SET grade=? WHERE studentId=?";

	public static final String DELETE_QUERY_STUDENT = "DELETE FROM student WHERE studentId= ?";

	public static final String SELECT_QUERY_TEACHER = "SELECT * FROM teacher";

	public static final String SELECT_OUERY_TEACHER_ID = "SELECT * FROM teacher WHERE teacherId= ? ";

	public static final String SELECT_OUERY_TEACHER_DEPARTMENT = "SELECT * FROM teacher WHERE department= ? ";

	public static final String INSERT_QUERY_TEACHER = "INSERT INTO teacher VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

	public static final String UPDATE_QUERY_TEACHER = "UPDATE teacher SET salary = ? WHERE teacher=?";

	public static final String DELETE_QUERY_TEACHER = "DELETE FROM teacher WHERE teacherId =? ";

	public static final String SELECT_OUERY_TEACHER_SUBJECT = "SELECT * FROM teacher WHERE subject= ? ";

	public static final String SELECT_OUERY_TEACHER_EXPERIENCE = "SELECT * FROM teacher WHERE experience= ? ";

	public static final String SELECT_QUERY_EXAM = "SELECT * FROM exam";

	public static final String SELECT_QUERY_EXAM_EXAMID = "SELECT * FROM exam WHERE examId= ?";

	public static final String SELECT_QUERY_EXAM_STUDENTID = "SELECT * FROM exam WHERE studentId =?";

	public static final String SELECT_QUERY_EXAM_SUBJECT = "SELECT * FROM exam WHERE subject =? ";

	public static final String UPDATE_QUERY_EXAM = "UPDATE exam SET exam =? WHERE examId=?";

	public static final String DELETE_QUERY_EXAM = "DELETE FROM exam WHERE examId =? ";

}
