package br.com.exemplo.cadastro_hotel.dto;

import br.com.exemplo.cadastro_hotel.model.Hotel;

public record HotelExibicaoDto(
        Long hotelId,
        String nomeHotel,
        Integer quantidadeVaga,
        Integer quantidadeVagaDisponivel,
        String endereco,
        String nomeMunicipio,
        String nomeEstado
) {
    public HotelExibicaoDto(Hotel hotel) {
        this(
                hotel.getHotelId(),
                hotel.getNomeHotel(),
                hotel.getQuantidadeVaga(),
                hotel.getQuantidadeVagaDisponivel(),
                hotel.getEndereco(),
                hotel.getNomeMunicipio(),
                hotel.getNomeEstado()
        );
    }
}
