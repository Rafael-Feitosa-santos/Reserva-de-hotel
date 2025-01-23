package br.com.exemplo.cadastro_hotel.advice;

import br.com.exemplo.cadastro_hotel.exception.HotelNaoAtualizadoException;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoEncontradoException;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoLocalizado;
import br.com.exemplo.cadastro_hotel.exception.HotelNomeExistenteException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNomeExistenteException.class)
    public ResponseEntity<Object> handleHotelNomeExistente(HotelNomeExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(HotelNaoEncontradoException.class)
    public ResponseEntity<Object> handleHotelNaoEncontrado(HotelNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HotelNaoAtualizadoException.class)
    public ResponseEntity<Object> handleHotelNaoAtualizado(HotelNaoAtualizadoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(HotelNaoLocalizado.class)
    public ResponseEntity<Object> handleHotelNaoLocalizado(HotelNaoLocalizado ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
