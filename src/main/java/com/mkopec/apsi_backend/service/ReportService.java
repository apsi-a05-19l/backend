package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public Report saveReport(Report activity) {
        return repository.save(activity);
    }

    public void deleteReport(Integer id) {
        repository.deleteById(id);
    }
}
