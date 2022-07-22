package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPersonData(Person person) {
        return personRepository.save(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personRepository.findAll();
    }



    public void deletePersonUsingId(String id) {
        personRepository.findById(id);
    }

}
