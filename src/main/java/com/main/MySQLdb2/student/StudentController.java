package com.main.MySQLdb2.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.MySQLdb1.teacher.Teacher;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/savestudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student student2 = this.studentService.saveStudent(student);
		return new ResponseEntity<Student>(student2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list = this.studentService.findAllStudents();
		if(list.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	public ResponseEntity<Student> getStudent (@PathVariable("studentId") Integer studentId){
		Optional<Student> optional = this.studentService.findById(studentId);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return new ResponseEntity<Student>(optional.get(),HttpStatus.OK);
		}
	}
	
	@PatchMapping("/updateStudentByid/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("studentId")Integer studentId,@RequestBody Student student){
		Optional<Student> ostudent = this.studentService.findById(studentId);
		if(!ostudent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Student existingStudnet = ostudent.get();
		existingStudnet.setFirstName(student.getFirstName());
		existingStudnet.setLastName(student.getLastName());
		
		Student updatedStudent = this.studentService.saveStudent(existingStudnet);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudentById/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer studentId){
		Optional<Student> ostOptional = this.studentService.findById(studentId);
		if(!ostOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			this.studentService.deleteById(studentId);
			return new ResponseEntity<String>("Student Deleted successfully...",HttpStatus.OK);
		}
	}
}

















