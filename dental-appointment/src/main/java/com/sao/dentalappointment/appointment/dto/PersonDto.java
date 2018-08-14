package com.sao.dentalappointment.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {

    private String givenName;
    private String surname;
    private Character initial;
    private Integer age;
    private String email;
}
