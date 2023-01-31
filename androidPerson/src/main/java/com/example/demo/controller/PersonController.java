package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	@GetMapping("/list")
	public List<Person>list(){
		return personService.list();
	}
	
	@PostMapping("/insert")
	public Person insert(@RequestBody Person person) {
		return personService.insert(person);
	}
	
	@ResponseBody
	@PutMapping("/update/{id}")
	public Person update(@PathVariable Long id, @RequestBody Person person) {
		return personService.update(id, person);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
}
