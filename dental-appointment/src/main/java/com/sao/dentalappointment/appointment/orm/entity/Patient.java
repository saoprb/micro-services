package com.sao.dentalappointment.appointment.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue
    private Long patientId;

    @Column(name = "NameText")
    private String name;
}
