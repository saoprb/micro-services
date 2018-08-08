package com.sao.dentalappointment.appointment.orm.repository;

import com.sao.dentalappointment.appointment.orm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
}
