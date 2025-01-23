package com.example.Reserva.dto;

import com.example.Reserva.model.Reserva;
import com.example.Reserva.model.StatusReserva;

public record ReservaExibicaoDto(
        Long idReserva,
        String nomeHotel,
        String nomeHospede,
        String dataCheckin,
        String dataCheckOut,
        Integer numeroQuarto,
        StatusReserva statusReserva

) {
    public ReservaExibicaoDto(Reserva reserva) {
        this(
                reserva.getIdReserva(),
                reserva.getNomeHotel(),
                reserva.getNomeHospede(),
                reserva.getDataCheckin(),
                reserva.getDataCheckOut(),
                reserva.getNumeroQuarto(),
                reserva.getStatusReserva()
        );
    }
}
