package br.com.exemplo.cadastro_hotel.controller;

import br.com.exemplo.cadastro_hotel.dto.HotelCadastroDto;
import br.com.exemplo.cadastro_hotel.dto.HotelExibicaoDto;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoEncontradoException;
import br.com.exemplo.cadastro_hotel.model.Hotel;
import br.com.exemplo.cadastro_hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;


    // Criar novo hotel
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar novo hotel", description = "Cria um novo hotel no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hotel criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public HotelExibicaoDto criar(@RequestBody @Valid HotelCadastroDto hotelCadastroDto) {
        return service.criar(hotelCadastroDto);
    }

    // Listar todos os hotéis
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todos os hotéis", description = "Retorna uma lista de todos os hotéis cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hotéis retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum hotel encontrado")
    })
    public ResponseEntity<List<HotelExibicaoDto>> listaHoteis() {
        return ResponseEntity.ok(service.listaHotel());
    }

    // Buscar hotel por ID
    @GetMapping("/{hotelId}")
    @Operation(summary = "Buscar hotel por ID", description = "Retorna os dados de um hotel específico através do seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel encontrado"),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado")
    })
    public ResponseEntity<HotelExibicaoDto> buscarPorIdHotel(@PathVariable Long hotelId){
        return ResponseEntity.ok(service.buscarPorIdHotel(hotelId));
    }

    // Buscar hotéis por município e estado
    @GetMapping("/por-municipio-estado")
    @Operation(summary = "Buscar hotéis por município e estado", description = "Retorna uma lista de hotéis filtrados por município e estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hotéis encontrada"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
    })
    public List<Hotel> buscarHoteisPorMunicipioEEstado(@RequestParam String municipio,
                                                       @RequestParam String estado) {
        return service.buscarHoteisPorMunicipioEEstado(municipio, estado);
    }

    // Buscar hotéis por estado
    @GetMapping("/por-estado")
    @Operation(summary = "Buscar hotéis por estado", description = "Retorna uma lista de hotéis filtrados por estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hotéis encontrada"),
            @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
    })
    public List<Hotel> buscarHoteisPorEstado(@RequestParam String estado) {
        return service.buscarHoteisPorEstado(estado);
    }

    // Excluir hotel por ID
    @DeleteMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir hotel", description = "Exclui um hotel específico do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Hotel excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado")
    })
    public void excluir(@PathVariable Long hotelId) {

        service.excluir(hotelId);
    }

    // Atualizar hotel
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar hotel", description = "Atualiza as informações de um hotel existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado")
    })
    public Hotel atualizar(@RequestBody Hotel hotelId) {

        return service.atualizar(hotelId);
    }
}
