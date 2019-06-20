package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.FullProjectDTO;
import com.mkopec.apsi_backend.dtos.ProjectPersonPutDTO;
import com.mkopec.apsi_backend.dtos.ProjectPostDTO;
import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import com.mkopec.apsi_backend.mapper.ProjectMapper;
import com.mkopec.apsi_backend.service.PersonService;
import com.mkopec.apsi_backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final PersonService personService;
    private final ProjectMapper projectMapper;

    @GetMapping
    public List<ShortProjectDTO> getAllProjects() {
        return projectMapper.toShortProjectDTOs(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public FullProjectDTO getProjectDetails(@PathVariable Integer id) {
        return projectMapper.toFullProjectDTO(projectService.getSingleProject(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShortProjectDTO saveProject(@RequestBody ProjectPostDTO projectPostDTO) {
        Person leader = personService.getSinglePerson(projectPostDTO.getLeaderId());

        Project project = projectMapper.toProject(projectPostDTO);
        project.setDate(Calendar.getInstance());
        project.setProjectLeader(leader);
        project.setIsArchived(false);
        project.getPersons().add(leader);

        return projectMapper.toShortProjectDTO(projectService.saveProject(project));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShortProjectDTO updateProject(@RequestBody ShortProjectDTO dto) {
        Project project = projectService.getSingleProject(dto.getId());
        project.setIsArchived(dto.getIsArchived());
        project.setName(dto.getName());
        return projectMapper.toShortProjectDTO(projectService.saveProject(project));
    }

    @PutMapping("/addMember/{projectID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FullProjectDTO addMemberToProject(@RequestBody ProjectPersonPutDTO personDTO, @PathVariable Integer projectID) {
        Project project = projectService.getSingleProject(projectID);
        Person person = personService.getSinglePerson(personDTO.getId());
        if (!project.getPersons().contains(person)) {
            project.getPersons().add(person);
            project = projectService.saveProject(project);
        }
        return projectMapper.toFullProjectDTO(project);
    }

    @PutMapping("/removeMember/{projectID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FullProjectDTO removeMemberFromProject(@RequestBody ProjectPersonPutDTO personDTO, @PathVariable Integer projectID) {
        Project project = projectService.getSingleProject(projectID);
        Person person = personService.getSinglePerson(personDTO.getId());
        if (!project.getPersons().contains(person) && !project.getProjectLeader().equals(person)) {
            project.getPersons().add(person);
            person.getProjects().add(project);
            project = projectService.saveProject(project);
        }
        return projectMapper.toFullProjectDTO(project);
    }
}
