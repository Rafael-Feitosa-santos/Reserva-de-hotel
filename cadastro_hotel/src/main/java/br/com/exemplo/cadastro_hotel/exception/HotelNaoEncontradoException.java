package br.com.exemplo.cadastro_hotel.exception;

public class HotelNaoEncontradoException extends RuntimeException {
    public HotelNaoEncontradoException(String message) {
        super(message);
    }
}
