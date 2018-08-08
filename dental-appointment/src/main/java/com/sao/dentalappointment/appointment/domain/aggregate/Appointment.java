package com.sao.dentalappointment.appointment.domain.aggregate;

import com.sao.dentalappointment.appointment.domain.valueobject.StartEnd;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Appointment implements com.sao.dentalappointment.appointment.domain.aggregate.IEntity {

    private Client client;
    private StartEnd startEnd;
}
