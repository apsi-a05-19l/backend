package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.Report;
import com.mkopec.apsi_backend.dtos.ReportDTO;
import com.mkopec.apsi_backend.dtos.ReportPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReportMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "text", source = "content")
    @Mapping(target = "author", expression = "java(getPersonName(report))")
    public abstract ReportDTO toReportDTO(Report report);

    public abstract List<ReportDTO> toReportDTOs(List<Report> reports);

    protected String getPersonName(Report report) {
        Person p = report.getPerson();
        return p.getName() + " " + p.getSurname();
    }

    @Mapping(target = "content", source = "text")
    public abstract Report toReport(ReportPostDTO reportPostDTO);
 }
