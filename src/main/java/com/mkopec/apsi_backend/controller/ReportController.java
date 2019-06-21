package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.dtos.ReportDTO;
import com.mkopec.apsi_backend.dtos.ReportPostDTO;
import com.mkopec.apsi_backend.mapper.ReportMapper;
import com.mkopec.apsi_backend.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @PostMapping("/{projectID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ReportDTO postReport(@RequestBody ReportPostDTO reportPostDTO, @PathVariable Integer projectID) {
        Report report = reportMapper.toReport(reportPostDTO);
        return reportMapper.toReportDTO(reportService.saveReport(report, projectID));
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

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ReportDTO updateReport(@RequestBody ReportPostDTO postDTO) {
        Report newOne = reportMapper.toReport(postDTO);
        return reportMapper.toReportDTO(reportService.updateReport(newOne));
    }
}
