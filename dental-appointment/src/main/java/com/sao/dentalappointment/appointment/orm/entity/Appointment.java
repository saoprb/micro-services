package com.sao.dentalappointment.appointment.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private Long appointmentId;

    @Column
    private Date dayOfAppointment;

    @Column
    private Time start;

    @Column
    private Time end;

    @Column
    private Long clientId;
}
