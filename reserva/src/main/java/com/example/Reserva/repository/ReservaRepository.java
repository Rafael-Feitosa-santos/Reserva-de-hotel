package com.example.Reserva.repository;

import com.example.Reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsByNomeHospede(String nomeHospede);

}
