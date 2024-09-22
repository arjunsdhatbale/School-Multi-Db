package com.main.MySQLdb2.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parents")
public class PersonController {

	@Autowired
	public  PersonService  personService; 
	
	@PutMapping("/saveparents")
	public ResponseEntity<Person> saveParents(@RequestBody Person parents){
		Person parents2 = this.personService.savePerson(parents);
		return new ResponseEntity<Person>(parents2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getallparents")
	public ResponseEntity<List<Person>> getAllParents(){
		List<Person> plist = this.personService.getAllParents();
		return new ResponseEntity<>(plist,HttpStatus.OK);
	}
	
	@GetMapping("/getpersonById/{personId}")
	public ResponseEntity<Person> getPerson(@PathVariable("personId") Integer personId){
		
		Optional<Person> pOptional = this.personService.findById(personId);
		return new ResponseEntity<>(pOptional.get(),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePersonbyId/{personId}")
	public ResponseEntity<Person> updatePerson(@PathVariable("pesonId") Integer personId,@RequestBody Person person){
		Optional<Person> operson = this.personService.findById(personId);
		if(!operson.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Person existingPerson = operson.get();
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setAge(person.getAge());
		existingPerson.setGender(person.getGender());
		existingPerson.setMiddleName(person.getMiddleName());
		existingPerson.setRelation(person.getRelation());
		existingPerson.setAlive(person.getAlive());
		
		Person updatedPerson = this.personService.savePerson(person);
		return new ResponseEntity<Person>(updatedPerson,HttpStatus.OK);
 	}
	 
	@DeleteMapping("/deletePerson/{personId}")
	public ResponseEntity<?> deletePerson(@PathVariable("personId") Integer personId){
		Optional<Person> optionalperson = this.personService.findById(personId);
		if(!optionalperson.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			this.personService.deletePerson(personId);
			return new ResponseEntity<>("person Deleted successfully...",HttpStatus.OK);
		}
	}
	 
	
	
}
