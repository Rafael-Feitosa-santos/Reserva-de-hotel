package br.com.exemplo.cadastro_hotel.exception;

public class HotelNaoAtualizadoException extends RuntimeException {
    public HotelNaoAtualizadoException(String message) {
        super(message);
    }
}
