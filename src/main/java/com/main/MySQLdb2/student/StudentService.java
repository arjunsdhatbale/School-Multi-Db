package com.main.MySQLdb2.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> findAllStudents();

	Optional<Student> findById(Integer studentId);

	void deleteById(Integer studentId);

	 
}
