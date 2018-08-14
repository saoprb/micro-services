package com.sao.dentalappointment.appointment.controller;

import com.sao.dentalappointment.appointment.dto.PersonDto;
import com.sao.dentalappointment.appointment.usecase.commands.RegisterNewPersonCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @Autowired
    private RegisterNewPersonCommand registerNewPersonCommand;

    @RequestMapping(value = "/registerNewPerson", method = RequestMethod.POST)
    public ResponseEntity<PersonDto> registerNewPerson(final PersonDto personDto) {
        PersonDto resultDto = registerNewPersonCommand.execute(personDto);
        return new ResponseEntity<>(resultDto, HttpStatus.CREATED);
    }
}
