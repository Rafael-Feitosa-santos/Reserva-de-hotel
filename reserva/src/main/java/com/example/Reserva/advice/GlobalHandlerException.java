package com.example.Reserva.advice;

import com.example.Reserva.exception.HospedeExistenteException;
import com.example.Reserva.exception.ReservaNaoLocalizada;
import com.example.Reserva.exception.ReservaNãoAtualizadaException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Hidden
public class GlobalHandlerException {

    @ExceptionHandler(ReservaNãoAtualizadaException.class)
    public ResponseEntity<Object> hanblerReservaNaoAtualizada(ReservaNãoAtualizadaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }

    @ExceptionHandler(ReservaNaoLocalizada.class)
    public ResponseEntity<Object> hanblerReservaNaoLocalizada(ReservaNaoLocalizada ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }

    @ExceptionHandler(HospedeExistenteException.class)
    public ResponseEntity<Object> hanblerHospedeExistente(HospedeExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }
}
