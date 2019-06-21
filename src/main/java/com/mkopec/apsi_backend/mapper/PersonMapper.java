package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.RoleInClub;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.dtos.PersonPostDTO;
import com.mkopec.apsi_backend.dtos.ShortPersonDTO;
import com.mkopec.apsi_backend.dtos.SimplePersonDTO;
import com.mkopec.apsi_backend.enums.RoleType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    @Autowired
    protected ProjectMapper projectMapper;

    @Autowired
    protected RoleMapper roleMapper;

    @Mapping(target = "activities", source = "activities")
    @Mapping(target = "organisationStatus", expression = "java(roleMapper.getRoleName(person.getRoleInClub()))")
    @Mapping(target = "projects", expression = "java(projectMapper.toShortProjectDTOs(person.getProjects()))")
    public abstract PersonDTO toPersonDTO(Person person);

    @Mapping(target = "organisationStatus", expression = "java(roleMapper.getRoleName(person.getRoleInClub()))")
    public abstract ShortPersonDTO toShortPersonDTO(Person person);

    public abstract SimplePersonDTO toSimplePersonDTO(Person person);

    public abstract List<SimplePersonDTO> toSimplePersonDTOs(List<Person> persons);

    public abstract List<ShortPersonDTO> toShortPersonDTOs(List<Person> persons);

    protected String nameDetails(Person person) {
        return person.getName() + " " + person.getSurname();
    }

    @Mappings({
            @Mapping(target = "roleInClub.id", source = "roleID"),
    })
    public abstract Person toPersonDTO(PersonPostDTO dto);

    @Mappings({
            @Mapping(target = "roleID", source = "roleInClub.id"),
    })
    public abstract PersonPostDTO toPersonPostDTO(Person person);
}
