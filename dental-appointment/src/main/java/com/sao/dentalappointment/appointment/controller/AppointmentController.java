package com.sao.dentalappointment.appointment.controller;

import com.sao.dentalappointment.appointment.dto.AppointmentDto;
import com.sao.dentalappointment.appointment.usecase.interfaces.IScheduleAppointmentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class AppointmentController {

    private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    @Autowired
    private IScheduleAppointmentCommand iScheduleAppointmentCommand;

    @RequestMapping(value = "/scheduleAppointment", method = RequestMethod.POST)
    public ResponseEntity<AppointmentDto> scheduleAppointment(final AppointmentDto appointmentDto) {
        AppointmentDto resultDto = iScheduleAppointmentCommand.execute(appointmentDto);
        return new ResponseEntity<AppointmentDto>(resultDto, HttpStatus.CREATED);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = Optional
                .ofNullable(threadLocal.get())
                .orElseGet(() -> {
                    threadLocal.set(new SimpleDateFormat(DATE_TIME_FORMAT));
                    return threadLocal.get();
                });
        simpleDateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }
}
