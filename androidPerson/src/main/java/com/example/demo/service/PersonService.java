package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
@Autowired
PersonRepository personRepository;
//전체보기
public List<Person> list(){
	return personRepository.findAll();
}
//추가
public Person insert(Person person) {
	return personRepository.save(person);
}
//수정
public Person update(Long id, Person person) {
	Person p = personRepository.findById(id).get();
	p.setName(person.getName());
	p.setPhone(person.getPhone());
	return p;
}
//삭제
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
}
