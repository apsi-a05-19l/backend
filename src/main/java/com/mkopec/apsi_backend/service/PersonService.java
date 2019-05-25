package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person getSinglePerson(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }
}
