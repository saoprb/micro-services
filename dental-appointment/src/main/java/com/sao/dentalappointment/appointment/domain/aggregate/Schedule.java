package com.sao.dentalappointment.appointment.domain.aggregate;

import com.sao.dentalappointment.appointment.domain.interfaces.IAggregate;
import com.sao.dentalappointment.appointment.domain.valueobject.StartEnd;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Schedule implements IAggregate {

    private List<Appointment> appoinmentList = new ArrayList<>();

    public Appointment scheduleAnAppointment(final LocalDateTime start, final LocalDateTime end,
                                             final Patient patient, final Client client) {
        client.setPatient(patient);
        Appointment appointment = new Appointment(client, new StartEnd(start, end));
        return appointment;
    }
}
