package com.sao.dentalappointment.appointment.service;

import com.sao.dentalappointment.appointment.orm.entity.Person;
import com.sao.dentalappointment.appointment.orm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPerson(final String given, final Character initial, final String surname, final String email) {
        Person person = Optional
                .ofNullable(personRepository.findByEmail(email))
                .orElseGet(() -> Optional
                        .ofNullable(personRepository.findByGivenAndInitialAndSurname(given, initial, surname))
                        .orElseGet(() -> Optional
                                .ofNullable(personRepository.findByGivenAndSurname(given, surname))
                                .orElseGet(() -> new Person(-1L, "","", '0',"", -1))
                        )
                );

        return person;
    }

    public Person findPersonOrCreate(final String givaen, final Character initial, final String surname,
                                     final String email, final Integer age) {
        Person person = findPerson(givaen, initial, surname, email);

        if (-1L == person.getPersonId()) {
            person = new Person(null, givaen, surname, initial, email, age);
            personRepository.save(person);
        }

        return person;
    }
}
