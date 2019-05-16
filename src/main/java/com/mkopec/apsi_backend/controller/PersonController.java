package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.mapper.PersonMapper;
import com.mkopec.apsi_backend.service.PermissionService;
import com.mkopec.apsi_backend.service.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    private AuthenticationController authenticationController;

    @Autowired
    private PermissionService permissionService;

    private PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @GetMapping("/{id}")
    public PersonDTO getSinglePerson(@RequestHeader(value = "Token") String token, @PathVariable Integer id) {

        Long userId = null;
        try {
            userId = authenticationController.getUserID(token);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (permissionService.hasPermission(userId, "endpoint")) {

            Person person = personService.getSinglePerson(id);
            return mapper.toPersonDTO(person);
        }
        else {
            // error 401
        }

        return null;
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
