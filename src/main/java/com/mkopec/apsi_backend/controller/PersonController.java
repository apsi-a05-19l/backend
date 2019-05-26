package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.dtos.ShortPersonDTO;
import com.mkopec.apsi_backend.mapper.PersonMapper;
import com.mkopec.apsi_backend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final PersonMapper mapper;

    @GetMapping("/{id}")
    public PersonDTO getSinglePerson(@PathVariable Integer id) {
        return mapper.toPersonDTO(personService.getSinglePerson(id));
    }

    @GetMapping
    public List<ShortPersonDTO> getAllPersons() {
        return mapper.toShortPersonDTOs(personService.getAllPersons());
    }
}
