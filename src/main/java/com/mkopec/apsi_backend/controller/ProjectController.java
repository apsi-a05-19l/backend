package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.FullProjectDTO;
import com.mkopec.apsi_backend.dtos.ProjectPostDTO;
import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import com.mkopec.apsi_backend.mapper.ProjectMapper;
import com.mkopec.apsi_backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
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
        Project project = projectMapper.toProject(projectPostDTO);
        return projectMapper.toShortProjectDTO(projectService.saveProject(project));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }

    @PutMapping("/archive/{projectID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShortProjectDTO archiveProject(@PathVariable Integer projectID) {
        return projectMapper.toShortProjectDTO(projectService.archiveProject(projectID));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShortProjectDTO updateProject(@RequestBody ProjectPostDTO dto) {
        return projectMapper.toShortProjectDTO(projectService.updateProject(dto));
    }

    @PutMapping("/addMember/{projectID}/{memberID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FullProjectDTO addMemberToProject(@PathVariable Integer projectID, @PathVariable Integer memberID) {
        return projectMapper.toFullProjectDTO(projectService.addMemberToProject(projectID, memberID));
    }

    @PutMapping("/removeMember/{projectID}/{memberID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FullProjectDTO removeMemberFromProject(@PathVariable Integer projectID, @PathVariable Integer memberID) {
        return projectMapper.toFullProjectDTO(projectService.removeMemberFromProject(projectID, memberID));
    }
}
