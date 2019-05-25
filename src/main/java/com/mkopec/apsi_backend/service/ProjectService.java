package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project getSingleProject(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    }
}
