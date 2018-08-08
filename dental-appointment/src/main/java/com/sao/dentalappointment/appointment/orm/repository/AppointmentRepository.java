package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
