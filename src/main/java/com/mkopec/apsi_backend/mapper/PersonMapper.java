package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    @Mapping(source = "activities", target = "activities")
    public abstract PersonDTO toPersonDTO(Person person);

    public abstract Person toPerson(PersonDTO personDTO);
}
