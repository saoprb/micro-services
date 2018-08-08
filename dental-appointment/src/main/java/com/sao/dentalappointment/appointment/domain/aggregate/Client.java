package com.sao.dentalappointment.appointment.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client implements com.sao.dentalappointment.appointment.domain.aggregate.IEntity {

    private String name;
    private Patient patient;
}
