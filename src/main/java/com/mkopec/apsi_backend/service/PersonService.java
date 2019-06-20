package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.PersonsProjects;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.enums.RoleType;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final RoleRepository roleRepository;
    private final PostRepository postRepository;
    private final PersonsProjectsRepository personsProjectsRepository;
    private final ProjectRepository projectRepository;

    public Person getSinglePerson(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Transactional
    public Person savePerson(Person person) {
        person.setDateFrom(Calendar.getInstance());
        person.setPoints(0);
        return repository.save(person);
    }

    @Transactional
    public Person updatePerson(Person newOne) {
        Person old = repository.getOne(newOne.getId());
        old.setName(newOne.getName());
        old.setSurname(newOne.getSurname());
        old.setPhone_number(newOne.getPhone_number());
        old.setEmail(newOne.getEmail());
        old.setRoleInClub(roleRepository.getOne(newOne.getRoleInClub().getId()));
        return repository.save(old);
    }

    @Transactional
    public void deleteByID(Integer memberID) {
        if (projectRepository.existsProjectByProjectLeaderId(memberID)) {
            throw new IllegalArgumentException("Project leader can not be removed. First change project leader to another member");
        }

        personsProjectsRepository.deleteAllByPersonID(memberID);
        repository.deleteById(memberID);
    }

    @Transactional
    public Person archivePerson(Integer memberID) {
        Person person = repository.getOne(memberID);
        person.setRoleInClub(roleRepository.findByName(RoleType.FORMER_MEMBER));
        return repository.save(person);
    }
}
