package com.main.MySQLdb1.teacher;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.log4j.Logger;
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

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.tags.Tags;

//@Tag(name = "Teacher Api",description = "This is Teacher Apies....")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private Logger log = Logger.getLogger(TeacherController.class);

	@Autowired
	private TeacherService teacherService;
	
//	@Operation(
//			summary = "Save Teacher",
//			description  ="This is Save method for save the Teachers...",
//			tags= {"Teacher","Post"}
//			)
	@PostMapping("/saveteacher")
	public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
		log.info("Request received to Create New Teacher ... !");
		Teacher teacher2  = this.teacherService.saveTeacher(teacher);
		log.info("Teacher Saved Successfully....");
		return new ResponseEntity<Teacher>(teacher2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTeachers")
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		log.info("Request received to Fetch All Teachers ...");
		List<Teacher> list = this.teacherService.getAllTeachers();
		if(list.size() == 0) {
			log.error("Teachers is present ...");
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Teacher>>(list,HttpStatus.OK);
	}
	@GetMapping("/getTeacherByid/{teacherId}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("teacherId") Integer teacherId){
		 Teacher teacher = this.teacherService.findById(teacherId).orElseThrow(() -> new NoSuchElementException("Teacher not found by id : " + teacherId));
		 return new ResponseEntity<Teacher>(teacher,HttpStatus.OK);
	}
	
	@PatchMapping("/updateTeacherById/{teacherId}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable("teacherId") Integer teacherid,@RequestBody Teacher teacher){
		Optional<Teacher> oteacher = this.teacherService.findById(teacherid);
		if(!oteacher.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Teacher existingTeacher = oteacher.get();
			existingTeacher.setFirstName(teacher.getFirstName());
			existingTeacher.setLastName(teacher.getLastName());
			 
			Teacher updatedTeacher = this.teacherService.saveTeacher(existingTeacher);
			return new ResponseEntity<Teacher>(updatedTeacher,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteTeacherById/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("teacherId") Integer teacherId){
		log.info("Request receive to Delete Teacher...");
		Optional<Teacher> oteacher = this.teacherService.findById(teacherId);
		if(!oteacher.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		this.teacherService.deleteTeacher(teacherId);
		return new ResponseEntity<String>("Teacher Deleted Successfully....",HttpStatus.OK);
	}
	
}





















