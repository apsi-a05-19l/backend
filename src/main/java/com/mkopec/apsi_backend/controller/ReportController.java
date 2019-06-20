package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.dtos.ReportDTO;
import com.mkopec.apsi_backend.dtos.ReportPostDTO;
import com.mkopec.apsi_backend.mapper.ReportMapper;
import com.mkopec.apsi_backend.service.ProjectService;
import com.mkopec.apsi_backend.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final ProjectService projectService;
    private final ReportMapper reportMapper;

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ReportDTO postReport(@RequestBody ReportPostDTO reportPostDTO, @PathVariable Integer id) {
        Project project = projectService.getSingleProject(id);

        Report report = reportMapper.toReport(reportPostDTO);
        report.setProject(project);
        report.setPerson(project.getProjectLeader());
        report.setDate(Calendar.getInstance());
        Report savedReport = reportService.saveReport(report);

        return reportMapper.toReportDTO(savedReport);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
    }

    @GetMapping
    public List<ReportDTO> getAll() {
        return reportMapper.toReportDTOs(reportService.findAll());
    }
}
