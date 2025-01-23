package com.example.Reserva.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReservaCadastroDto(

        @Schema(description = "Nome do Hotel", example = "Leão da Montanha")
        String nomeHotel,

        @Schema(description = "Nome do Hóspede", example = "João Silva")
        String nomeHospede,

        @Schema(description = "Data de Check-in", example = "07-01-2025")
        String dataCheckin,

        @Schema(description = "Data de Check-out", example = "20-01-2025")
        String dataCheckOut,

        @Schema(description = "Nº do Quarto", example = "405")
        Integer numeroQuarto

) {
}

