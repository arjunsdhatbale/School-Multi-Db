package com.main.MySQLdb1.teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService  {

	Teacher saveTeacher(Teacher teacher);

	List<Teacher> getAllTeachers();

	Optional<Teacher> findById(Integer teacherId);

	void deleteTeacher(Integer teacherId);
	

	
}
