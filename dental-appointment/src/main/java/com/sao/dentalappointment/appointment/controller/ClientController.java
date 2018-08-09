package com.sao.dentalappointment.appointment.controller;

import com.sao.dentalappointment.appointment.dto.ClientDto;
import com.sao.dentalappointment.appointment.usecase.commands.AddNewClientCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    @Autowired
    private AddNewClientCommand addNewClientCommand;

    public ResponseEntity<ClientDto> addNewClient(final ClientDto clientDto) {
        ClientDto resultDto = addNewClientCommand.execute(clientDto);
        return new ResponseEntity<>(resultDto, HttpStatus.CREATED);
    }
}
