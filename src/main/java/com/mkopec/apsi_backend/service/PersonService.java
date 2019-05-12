package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person getSinglePerson(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person", "id", id));
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }
}
