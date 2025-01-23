package br.com.exemplo.cadastro_hotel.exception;

public class HotelNaoLocalizado extends RuntimeException {
    public HotelNaoLocalizado(String message) {
        super(message);
    }
}
