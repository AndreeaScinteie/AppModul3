package com.application.modul3.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;
import com.application.modul3.person.mapper.PersonMapper;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	@PostMapping
	public PersonDTO createPerson(@RequestBody PersonCreateDTO personCreateDTO) {
		Person person = personService.createPerson(personMapper.personCreateDTO2person(personCreateDTO));
		return personMapper.person2PersonDTO(person);
	}
	
	@PutMapping("/person/{id}")
	public PersonDTO updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Integer id) {
		Person person = personService.updatePerson(personMapper.personDTO2Person(personDTO), id);
		return personMapper.person2PersonDTO(person);
	}
	
	@GetMapping("/list")
	public List<PersonDTO> getAllPerson() {
		return personMapper.personList2PersonListDTO(personService.getAllPerson());
	}
	
	@GetMapping("/get/{id}")
	public PersonDTO getPersonById(@PathVariable Integer id) {
		return personMapper.person2PersonDTO(personService.getPersonById(id)) ;
	}
	
	@DeleteMapping("/person/{pid}")
	public void deletePersonById(@PathVariable Integer id) {
		personService.deletePersonById(id);
	}
	
	@DeleteMapping("/person/remove-from-user/{personId}/{carId}")
	public void deleteCarIdFromPerson(@PathVariable Integer personId, @PathVariable Integer carId) {
		personService.deleteCarIdFromPerson(personId, carId);
	}

}
