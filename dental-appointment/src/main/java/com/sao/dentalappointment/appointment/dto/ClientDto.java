package com.sao.dentalappointment.appointment.dto;

import lombok.Data;

@Data
public class ClientDto {

    private String givenName;
    private String surname;
    private Character initial;
    private Integer age;
    private String email;
}
