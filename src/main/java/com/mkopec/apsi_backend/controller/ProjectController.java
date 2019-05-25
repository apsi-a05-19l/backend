package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import com.mkopec.apsi_backend.mapper.ProjectMapper;
import com.mkopec.apsi_backend.service.ProjectService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ShortProjectDTO> getAllProjects() {
        return projectMapper.toShortProjectDTOs(projectService.getAllProjects());
    }
}
