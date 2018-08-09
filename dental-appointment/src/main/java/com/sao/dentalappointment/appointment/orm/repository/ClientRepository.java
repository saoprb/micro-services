package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByName(String name);
}
