package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.repository.PersonRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person getSinglePerson(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person", "id", id));
    }
}
