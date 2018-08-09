package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByName(String name);
}
