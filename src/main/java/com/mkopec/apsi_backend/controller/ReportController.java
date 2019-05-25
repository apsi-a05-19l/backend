package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.dtos.ReportPostDTO;
import com.mkopec.apsi_backend.mapper.ReportMapper;
import com.mkopec.apsi_backend.service.ProjectService;
import com.mkopec.apsi_backend.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;
    private final ProjectService projectService;
    private final ReportMapper reportMapper;

    public ReportController(ReportService reportService, ProjectService projectService, ReportMapper reportMapper) {
        this.reportService = reportService;
        this.projectService = projectService;
        this.reportMapper = reportMapper;
    }

    @PostMapping("/{id}")
    public ReportPostDTO postReport(@RequestBody ReportPostDTO reportPostDTO, @PathVariable Integer id) {
        Project project = projectService.getSingleProject(id);

        Report report = reportMapper.toReport(reportPostDTO);
        report.setProject(project);
        report.setPerson(project.getProjectLeader());

        Report savedReport = reportService.saveReport(report);

        return reportMapper.toReportPostDTO(savedReport);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
    }
}
