package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.main.MySQLdb1.teacher.Teacher;
import com.main.MySQLdb1.teacher.TeacherRepo;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
public class TeacherRepoTest {

	@Autowired
	private TeacherRepo teacherRepo;
	
	void setUp() {
		Teacher teacher = new Teacher(null,"Ganesh","Khedkar");
		this.teacherRepo.save(teacher);
	}
	
}
 