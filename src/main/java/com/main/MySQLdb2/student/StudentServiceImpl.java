package com.main.MySQLdb2.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		Student student2 = this.studentRepo.save(student);
 		return student2;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> list = this.studentRepo.findAll();
 		return  list;
	}

	@Override
	public Optional<Student> findById(Integer studentId) {
		Optional<Student> optional = this.studentRepo.findById(studentId);
 		return optional;
	}

	@Override
	public void deleteById(Integer studentId) {
 		this.studentRepo.deleteById(studentId);
	}

	 
}
