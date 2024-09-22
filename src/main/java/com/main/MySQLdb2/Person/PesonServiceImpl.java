package com.main.MySQLdb2.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PesonServiceImpl implements PersonService{

	@Autowired
	private PersonRepo parentRepo;

	@Override
	public Person savePerson(Person parents) {
		Person parents2 = this.parentRepo.save(parents);
		
 		return parents2;
	}

	@Override
	public List<Person> getAllParents() {
		List<Person> plist = this.parentRepo.findAll();
 		return plist;
	}

	@Override
	public Optional<Person> findById(Integer personId) {
		Optional<Person>  pOptoinal = this.parentRepo.findById(personId);
		return pOptoinal;
	}

	@Override
	public void deletePerson(Integer personId) {
 		this.parentRepo.deleteById(personId);
	} 
}
