package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.dtos.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    public abstract PersonDTO toPersonDTO(Person person);

    public abstract Person toPerson(PersonDTO personDTO);
}
