package com.sao.dentalappointment.appointment.dto;

import lombok.Value;

import java.util.Date;

@Value
public class AppointmentDto {
    private String patientName;
    private String clientName;
    private Date start;
    private Date end;
}
