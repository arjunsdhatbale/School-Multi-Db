package com.main.MySQLdb1.teacher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepo teacherRepo;

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		Teacher teacher2 = this.teacherRepo.save(teacher);
		return teacher2;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> list = this.teacherRepo.findAll();
 		return list;
	}

	@Override
	public Optional<Teacher> findById(Integer teacherId) {
		Optional<Teacher> optional = this.teacherRepo.findById(teacherId);
 		return optional;
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		this.teacherRepo.deleteById(teacherId);
	} 
}
