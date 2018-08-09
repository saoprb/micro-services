package com.sao.dentalappointment.appointment.service;

import com.sao.dentalappointment.appointment.orm.entity.Person;
import com.sao.dentalappointment.appointment.orm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPerson(final String givaen, final Character initial, final String surname, final String email) {
        Person person = personRepository.findByEmail(email);

        if (null == person) {
            person = personRepository.findByGivenAndInitialAndSurname(givaen, initial, surname);
        }

        if (null == person) {
            person = personRepository.findByGivenAndSurname(givaen, surname);
        }

        return person;
    }

    public Person findPersonOrCreate(final String givaen, final Character initial, final String surname, final String email, final Integer age) {
        Person person = findPerson(givaen, initial, surname, email);

        if (null == person) {
            person = new Person(null, givaen, surname, initial, email, age);
            personRepository.save(person);
        }

        return person;
    }
}
