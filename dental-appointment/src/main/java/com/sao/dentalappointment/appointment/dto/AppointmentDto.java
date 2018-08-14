package com.sao.dentalappointment.appointment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {
    private String patientGiven;
    private String patientSurname;
    private Character patientInitial;
    private String patientEmail;
    private String clientName;
    private String clientGiven;
    private String clientSurname;
    private Character clientInitial;
    private String clientEmail;
    private Date start;
    private Date end;
}
