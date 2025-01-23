package br.com.exemplo.cadastro_hotel.exception;

public class HotelNomeExistenteException extends RuntimeException {
    public HotelNomeExistenteException(String message) {
        super(message);
    }
}
