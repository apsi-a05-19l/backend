package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.FullProjectDTO;
import com.mkopec.apsi_backend.dtos.ProjectPostDTO;
import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import com.mkopec.apsi_backend.mapper.ProjectMapper;
import com.mkopec.apsi_backend.service.PersonService;
import com.mkopec.apsi_backend.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final PersonService personService;

    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, PersonService personService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.personService = personService;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<ShortProjectDTO> getAllProjects() {
        return projectMapper.toShortProjectDTOs(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public FullProjectDTO getProjectDetails(@PathVariable Integer id) {
        return projectMapper.toFullProjectDTO(projectService.getSingleProject(id));
    }

    @PostMapping
    public ShortProjectDTO saveProject(@RequestBody ProjectPostDTO projectPostDTO) {
        Person leader = personService.getSinglePerson(projectPostDTO.getLeaderId());

        Project project = projectMapper.toProject(projectPostDTO);
        project.setDate(Calendar.getInstance());
        project.setProjectLeader(leader);

        Project savedProject = projectService.saveProject(project);

        return projectMapper.toShortProjectDTO(savedProject);
    }


    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }
}
