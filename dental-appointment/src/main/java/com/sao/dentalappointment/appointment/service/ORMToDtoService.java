package com.sao.dentalappointment.appointment.service;

import com.sao.dentalappointment.appointment.dto.PersonDto;
import com.sao.dentalappointment.appointment.orm.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class ORMToDtoService {

    public PersonDto transform(Person person) {
        return new PersonDto(person.getGiven(), person.getSurname(), person.getInitial(), person.getAge(),
                person.getEmail());
    }
}
