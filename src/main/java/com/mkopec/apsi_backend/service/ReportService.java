package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public Report saveReport(Report activity) {
        return repository.save(activity);
    }

    public void deleteReport(Integer id) {
        repository.deleteById(id);
    }

    public List<Report> findAll() {
        return repository.findAll();
    }
}
