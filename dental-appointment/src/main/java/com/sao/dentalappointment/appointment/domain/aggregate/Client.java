package com.sao.dentalappointment.appointment.domain.aggregate;

import com.sao.dentalappointment.appointment.domain.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client implements com.sao.dentalappointment.appointment.domain.aggregate.IEntity {

    private Name name;
    private Integer age;
    private Patient patient;
}
