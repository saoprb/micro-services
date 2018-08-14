package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    Person findByGivenAndInitialAndSurname(String given, Character initial, String surname);

    Person findByGivenAndSurname(String given, String surname);
}
