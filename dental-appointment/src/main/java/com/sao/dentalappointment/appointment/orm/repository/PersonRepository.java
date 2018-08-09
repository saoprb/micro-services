package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(final String email);

    Person findByGivenAndInitialAndSurname(final String given, final Character initial, final String surname);

    Person findByGivenAndSurname(final String given, final String surname);
}
