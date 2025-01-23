package com.example.Reserva.dto;

import com.example.Reserva.model.StatusReserva;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ReservaDto(

        Long idReserva,
        String nomeHotel,
        String nomeHospede,
        String dataCheckin,
        String dataCheckOut,
        Integer numeroQuarto,
        StatusReserva statusReserva

) {
}
