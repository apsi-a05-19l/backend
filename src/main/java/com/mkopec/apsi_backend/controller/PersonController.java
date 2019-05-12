package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.mapper.PersonMapper;
import com.mkopec.apsi_backend.service.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    private PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @GetMapping("/{id}")
    public PersonDTO getSinglePerson(@PathVariable Integer id) {
        Person person = personService.getSinglePerson(id);
        return mapper.toPersonDTO(person);
    }

    @GetMapping("/all")
    public List<PersonDTO> getAllPersons() {
        List<Person> personList = personService.getAllPersons();
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (Person p : personList) {
            personDTOList.add(mapper.toPersonDTO(p));
        }
        return personDTOList;
    }
}
