package com.main.MySQLdb2.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
 
 
@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personId")
	private Integer personId;
	
	@Column(name = "relation")
	private String relation; 
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	
	@Size(min = 19, max = 30, message = "Age between 19 and 30")
	@Column(name = "age")
	private Short age;
	
	@Column(name = "alive")
	private Boolean Alive;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Integer personId, String relation, String gender, String firstName, String middleName,
			String lastName, Short age, Boolean alive) {
		super();
		this.personId = personId;
		this.relation = relation;
		this.gender = gender;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		Alive = alive;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public Boolean getAlive() {
		return Alive;
	}
	public void setAlive(Boolean alive) {
		Alive = alive;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", relation=" + relation + ", gender=" + gender + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + ", Alive="
				+ Alive + "]";
	}
	
	
	
	
	 
	
	
}
