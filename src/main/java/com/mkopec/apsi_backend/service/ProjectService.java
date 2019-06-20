package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.PersonsProjects;
import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.ProjectPostDTO;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PersonRepository;
import com.mkopec.apsi_backend.repository.PersonsProjectsRepository;
import com.mkopec.apsi_backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;
    private final PersonsProjectsRepository personsProjectsRepository;
    private final PersonRepository personRepository;

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project getSingleProject(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    }

    @Transactional
    public Project saveProject(Project project) {
        project.setDate(Calendar.getInstance());
        project.setIsArchived(false);
        project.setPersons(new ArrayList<>());
        Project savedProject = repository.save(project);

        addMemberToProject(savedProject.getId(), project.getProjectLeader().getId());

        return savedProject;
    }

    @Transactional
    public void deleteProject(Integer id) {
        personsProjectsRepository.deleteAllByProjectID(id);
        repository.deleteById(id);
    }

    @Transactional
    public Project addMemberToProject(Integer projectID, Integer memberID) {
        Project old = getSingleProject(projectID);
        if (old.getPersons().stream().anyMatch(person -> person.getId().equals(memberID))) {
            throw new IllegalArgumentException("Member with id: " + memberID + " is already member of the project!");
        }
        PersonsProjects newOne = PersonsProjects.builder()
                .projectID(projectID)
                .personID(memberID)
                .dateFrom(Calendar.getInstance())
                .build();
        personsProjectsRepository.save(newOne);
        return getSingleProject(projectID);
    }

    @Transactional
    public Project removeMemberFromProject(Integer projectID, Integer memberID) {
        Project project = getSingleProject(projectID);
        if (project.getProjectLeader().getId().equals(memberID)) {
            throw new IllegalArgumentException("Project leader can not be removed");
        }
        personsProjectsRepository.deleteByProjectIDAndPersonID(projectID, memberID);
        return getSingleProject(projectID);
    }

    @Transactional
    public Project archiveProject(Integer projectID) {
        Project project = getSingleProject(projectID);
        project.setIsArchived(true);
        return repository.save(project);
    }

    @Transactional
    public Project updateProject(ProjectPostDTO dto) {
        Person newLeader = personRepository.getOne(dto.getLeaderId());
        Project project = repository.getOne(dto.getId());
        project.setProjectLeader(newLeader);
        project.setName(dto.getName());

        return repository.save(project);
    }
}
