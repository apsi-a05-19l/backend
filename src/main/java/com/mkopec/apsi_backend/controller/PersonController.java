package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.dtos.PersonPostDTO;
import com.mkopec.apsi_backend.dtos.ShortPersonDTO;
import com.mkopec.apsi_backend.mapper.PersonMapper;
import com.mkopec.apsi_backend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public PersonPostDTO addMember(@RequestBody PersonPostDTO dto) {
        Person person = mapper.toPersonDTO(dto);
        return mapper.toPersonPostDTO(personService.savePerson(person));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public PersonPostDTO updateMember(@RequestBody PersonPostDTO dto) {
        Person person = mapper.toPersonDTO(dto);
        return mapper.toPersonPostDTO(personService.updatePerson(person));
    }

    @PutMapping("/{memberID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public PersonPostDTO archiveMember(@PathVariable Integer memberID) {
        return mapper.toPersonPostDTO(personService.archivePerson(memberID));
    }
}
