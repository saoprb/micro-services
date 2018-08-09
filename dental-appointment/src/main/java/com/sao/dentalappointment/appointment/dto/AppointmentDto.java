package com.sao.dentalappointment.appointment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {

    private String patientName;
    private String clientName;
    private Date start;
    private Date end;
}
