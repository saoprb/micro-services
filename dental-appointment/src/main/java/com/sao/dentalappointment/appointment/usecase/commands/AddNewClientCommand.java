package com.sao.dentalappointment.appointment.usecase.commands;

import com.sao.dentalappointment.appointment.dto.ClientDto;
import com.sao.dentalappointment.appointment.orm.entity.Client;
import com.sao.dentalappointment.appointment.orm.entity.Person;
import com.sao.dentalappointment.appointment.orm.repository.ClientRepository;
import com.sao.dentalappointment.appointment.orm.repository.PersonRepository;
import com.sao.dentalappointment.appointment.service.PersonService;
import com.sao.dentalappointment.appointment.usecase.interfaces.IAddNewClientCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddNewClientCommand implements IAddNewClientCommand {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Override
    public ClientDto execute(ClientDto clientDto) {

        Person person = personService.findPersonOrCreate(clientDto.getGivenName(), clientDto.getInitial(),
                clientDto.getSurname(), clientDto.getEmail(), clientDto.getAge());

        Client client = clientRepository.findById(person.getPersonId())
                .orElse(clientRepository.save(new Client(null, person.getPersonId(), null)));

        return null;
    }
}
