package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.FullProjectDTO;
import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper {

    @Autowired
    protected ReportMapper reportMapper;
    @Autowired
    protected PersonMapper personMapper;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract ShortProjectDTO toShortProjectDTO(Project project);

    public abstract List<ShortProjectDTO> toShortProjectDTOs(List<Project> projects);

    @Mappings({
            @Mapping(target = "currentLeader", expression = "java(nameDetails(project.getProjectLeader()))"),
            @Mapping(target = "reports", expression = "java(reportMapper.toReportDTOs(project.getReports()))"),
            @Mapping(target = "members", expression = "java(personMapper.toSimplePersonDTOs(project.getPersons()))")
    })
    public abstract FullProjectDTO toFullProjectDTO(Project project);

    protected String nameDetails(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
}
