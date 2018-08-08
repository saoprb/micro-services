package com.sao.dentalappointment.appointment.usecase.commands;

import com.sao.dentalappointment.appointment.cross_cutting_concerns.ClientException;
import com.sao.dentalappointment.appointment.cross_cutting_concerns.PatientException;
import com.sao.dentalappointment.appointment.domain.aggregate.Schedule;
import com.sao.dentalappointment.appointment.dto.AppointmentDto;
import com.sao.dentalappointment.appointment.orm.entity.Client;
import com.sao.dentalappointment.appointment.orm.entity.Patient;
import com.sao.dentalappointment.appointment.orm.repository.ClientRepository;
import com.sao.dentalappointment.appointment.orm.repository.PatientRepository;
import com.sao.dentalappointment.appointment.usecase.interfaces.IScheduleAppointmentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class ScheduleAppointmentCommand implements IScheduleAppointmentCommand {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Schedule schedule;

    @Override
    public AppointmentDto execute(AppointmentDto appointmentDto) {

        Client client = Optional
                .ofNullable(clientRepository.findByName(appointmentDto.getClientName()))
                .orElseThrow(() -> new ClientException(ClientException.NOT_FOUND));

        Patient patient = Optional
                .ofNullable(patientRepository.findByName(appointmentDto.getClientName()))
                .orElseThrow(() -> new PatientException(PatientException.NOT_FOUND));

        LocalDateTime start = appointmentDto.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = appointmentDto.getEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        //schedule.scheduleAnAppointment();

        return appointmentDto;
    }
}
