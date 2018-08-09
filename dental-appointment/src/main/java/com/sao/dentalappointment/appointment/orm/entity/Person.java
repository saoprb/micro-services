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
public class Person {

    @Id
    @GeneratedValue
    private Long personId;

    @Column
    private String given;

    @Column
    private String surname;

    @Column
    private Character initial;

    @Column
    private String email;

    @Column
    private Integer age;
}
