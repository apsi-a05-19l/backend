package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.domain.RoleInClub;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import com.mkopec.apsi_backend.dtos.ShortPersonDTO;
import com.mkopec.apsi_backend.dtos.SimplePersonDTO;
import com.mkopec.apsi_backend.enums.RoleType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    @Mapping(source = "activities", target = "activities")
    @Mapping(target = "roleInClub", expression = "java(roleInClubToRoleType(person.getRoleInClub()))")
    public abstract PersonDTO toPersonDTO(Person person);

    public RoleType roleInClubToRoleType(RoleInClub roleInClub) {
        return roleInClub.getName();
    }

    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "surname", source = "lastName")
    @Mapping(target = "organizationStatus", source = "roleInClub")
    public abstract ShortPersonDTO toShortPersonDTO(Person person);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "surname", source = "lastName")
    public abstract SimplePersonDTO toSimplePersonDTO(Person person);

    public abstract List<SimplePersonDTO> toSimplePersonDTOs(List<Person> persons);

    public abstract List<ShortPersonDTO> toShortPersonDTOs(List<Person> persons);

    protected String nameDetails(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
}
