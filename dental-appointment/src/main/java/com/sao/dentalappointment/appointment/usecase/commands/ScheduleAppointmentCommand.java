package com.sao.dentalappointment.appointment.usecase.commands;

import com.sao.dentalappointment.appointment.domain.aggregate.Schedule;
import com.sao.dentalappointment.appointment.dto.AppointmentDto;
import com.sao.dentalappointment.appointment.orm.entity.Client;
import com.sao.dentalappointment.appointment.orm.entity.Patient;
import com.sao.dentalappointment.appointment.orm.entity.Person;
import com.sao.dentalappointment.appointment.orm.repository.ClientRepository;
import com.sao.dentalappointment.appointment.orm.repository.PatientRepository;
import com.sao.dentalappointment.appointment.orm.repository.PersonRepository;
import com.sao.dentalappointment.appointment.service.PersonService;
import com.sao.dentalappointment.appointment.sharedkernel.exceptions.ClientException;
import com.sao.dentalappointment.appointment.sharedkernel.exceptions.PatientException;
import com.sao.dentalappointment.appointment.usecase.interfaces.IScheduleAppointmentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class ScheduleAppointmentCommand implements IScheduleAppointmentCommand {

    @Autowired
    private PersonService personService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Schedule schedule;

    @Override
    public AppointmentDto execute(AppointmentDto appointmentDto) {

        Person personClient =  personService.findPerson(appointmentDto.getClientGiven(), appointmentDto.getClientInitial(),
                appointmentDto.getClientSurname(), appointmentDto.getClientEmail());

        Client client = Optional
                .ofNullable(clientRepository.findByPersonId(personClient.getPersonId()))
                .orElseThrow(() -> new ClientException(ClientException.NOT_FOUND, personClient.toString()));

        Person personPatient =  personService.findPerson(appointmentDto.getPatientGiven(), appointmentDto.getPatientInitial(),
                appointmentDto.getPatientSurname(), appointmentDto.getPatientEmail());

        Patient patient = Optional
                .ofNullable(patientRepository.findByPersonId(personPatient.getPersonId()))
                .orElseThrow(() -> new PatientException(PatientException.NOT_FOUND, personPatient.toString()));

        LocalDateTime start = appointmentDto.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = appointmentDto.getEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        //schedule.scheduleAnAppointment();

        return appointmentDto;
    }
}
