package com.application.modul3.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.car.Car;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(Person person) {
		return personRepository.saveAndFlush(person);
	}
	
	public Person getPersonById(Integer id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) 
		{
			return optionalPerson.get();
		}
		return null;
	}
	
	public Person updatePerson(Person person, Integer personId) {
		Person updatePerson = getPersonById(personId);
		updatePerson.setLastName(person.getLastName());
		updatePerson.setFirstName(person.getFirstName());
		updatePerson.setAge(person.getAge());
		personRepository.flush();
		return updatePerson;
	}
	
	public List<Person> getAllPerson()
	{
		return personRepository.findAll();
	}
	
	public void deletePersonById(Integer personId) {
		personRepository.deleteById(personId);
	}
	
	public void deleteCarIdFromPerson(Integer personId, Integer carId) {
		Person person = getPersonById(personId);
		person.getCars();
		Car car = person.getCarByIdForPerson(carId);
		person.removeCar(car);
		personRepository.flush();
	}
	
	
	

}
