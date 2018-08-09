package com.sao.dentalappointment.appointment.domain.valueobject;

import lombok.Value;

@Value
public class Name {
    private String given;
    private String surname;
    private Character initial;
}
