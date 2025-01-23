package br.com.exemplo.cadastro_hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record HotelCadastroDto(

        @Schema(description = "Nome do estabelecimento", example = "Leão da Montanha")
        String nomeHotel,

        @Schema(description = "Quantidade de vagas no hotel", example = "50")
        Integer quantidadeVaga,

        @Schema(description = "Quantidade de vagas disponíveis", example = "30")
        Integer quantidadeVagaDisponivel,

        @Schema(description = "Endereço do hotel", example = "Av Principal, 123")
        String endereco,

        @Schema(description = "Nome do município", example = "Gramados")
        String nomeMunicipio,

        @Schema(description = "Nome do estado", example = "Rio Grande do Sul")
        String nomeEstado
) {
}
