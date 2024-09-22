package com.main.MySQLdb2.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

	Person savePerson(Person parents);

	List<Person> getAllParents();

	Optional<Person> findById(Integer personId);

	void deletePerson(Integer personId);

}
