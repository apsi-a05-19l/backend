package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.repository.ProjectRepository;
import com.mkopec.apsi_backend.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository repository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Report saveReport(Report newReport, Integer projectID) {
        Project project = projectRepository.getOne(projectID);
        newReport.setProject(project);
        newReport.setPerson(project.getProjectLeader());
        newReport.setDate(Calendar.getInstance());
        newReport.setContent(newReport.getContent());
        return repository.save(newReport);
    }
    @Transactional
    public void deleteReport(Integer id) {
        repository.deleteById(id);
    }

    public List<Report> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Report updateReport(Report newReport) {
        Report old = repository.getOne(newReport.getId());
        old.setContent(newReport.getContent());
        return repository.save(old);
    }
}
