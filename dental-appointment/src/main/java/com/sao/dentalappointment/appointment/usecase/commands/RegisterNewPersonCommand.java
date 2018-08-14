package com.sao.dentalappointment.appointment.usecase.commands;

import com.sao.dentalappointment.appointment.dto.PersonDto;
import com.sao.dentalappointment.appointment.orm.entity.Person;
import com.sao.dentalappointment.appointment.service.ORMToDtoService;
import com.sao.dentalappointment.appointment.service.PersonService;
import com.sao.dentalappointment.appointment.usecase.interfaces.IRegisterNewPersonCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewPersonCommand implements IRegisterNewPersonCommand {

    @Autowired
    private PersonService personService;

    @Autowired
    private ORMToDtoService ormToDtoService;

    @Override
    public PersonDto execute(PersonDto clientDto) {

        Person person = personService.findPersonOrCreate(clientDto.getGivenName(), clientDto.getInitial(),
                clientDto.getSurname(), clientDto.getEmail(), clientDto.getAge());
        return ormToDtoService.transform(person);
    }
}
