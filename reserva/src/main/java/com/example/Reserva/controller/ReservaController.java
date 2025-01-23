package com.example.Reserva.controller;

import com.example.Reserva.dto.ReservaCadastroDto;
import com.example.Reserva.dto.ReservaExibicaoDto;
import com.example.Reserva.model.Reserva;
import com.example.Reserva.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar nova reserva", description = "Cria uma nova reserva no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ReservaExibicaoDto criar(@RequestBody @Valid ReservaCadastroDto reservaCadastro) {
        return service.salvar(reservaCadastro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todos as reservas", description = "Retorna uma lista de todos as reservas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reserva retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma reserva encontrada")
    })
    public ResponseEntity<List<ReservaExibicaoDto>> listar() {
        return ResponseEntity.ok(service.listaReserva());
    }

    @GetMapping("/{idReserva}")
    @Operation(summary = "Listar todas as reservas", description = "Retorna uma lista de todas as reservas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    public ResponseEntity<ReservaExibicaoDto> listaPorIdReserva(@PathVariable Long idReserva) {
        return ResponseEntity.ok(service.buscarPorIdReserva(idReserva));
    }

    @DeleteMapping("/{idReserva}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Excluir reserva", description = "Exclui uma reserva específica do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    public ResponseEntity<String> excluir(@PathVariable Long idReserva) {
        service.excluir(idReserva);
        return ResponseEntity.ok("Reserva com ID " + idReserva + " excluída com sucesso.");
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar reserva", description = "Atualiza as informações de um reserva existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    public Reserva atualizar(@RequestBody Reserva idReserva) {
        return service.atualizar(idReserva);
    }

}
