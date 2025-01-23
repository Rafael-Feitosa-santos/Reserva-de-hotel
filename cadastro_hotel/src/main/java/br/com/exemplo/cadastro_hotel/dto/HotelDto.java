package br.com.exemplo.cadastro_hotel.dto;

public record HotelDto(

        Long hotelId,

        String nomeHotel,

        Integer quantidadeVaga,

        Integer quantidadeVagaDisponivel,

        String endereco,

        String nomeMunicipio,

        String nomeEstado

) {
}
