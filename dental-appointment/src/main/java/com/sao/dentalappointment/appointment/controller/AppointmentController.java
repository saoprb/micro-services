package com.sao.dentalappointment.appointment.controller;

import com.sao.dentalappointment.appointment.dto.AppointmentDto;
import com.sao.dentalappointment.appointment.usecase.interfaces.IScheduleAppointmentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppointmentController {

    @Autowired
    private IScheduleAppointmentCommand iScheduleAppointmentCommand;

    @RequestMapping("/scheduleAppointment")
    public ResponseEntity<AppointmentDto> scheduleAppointment(final AppointmentDto appointmentDto) {
        AppointmentDto resultDto = iScheduleAppointmentCommand.execute(appointmentDto);
        return new ResponseEntity<AppointmentDto>(resultDto, HttpStatus.CREATED);
    }
}
