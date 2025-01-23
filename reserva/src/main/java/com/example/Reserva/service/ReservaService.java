package com.example.Reserva.service;

import com.example.Reserva.dto.ReservaCadastroDto;
import com.example.Reserva.dto.ReservaExibicaoDto;
import com.example.Reserva.exception.HospedeExistenteException;
import com.example.Reserva.exception.ReservaNaoLocalizada;
import com.example.Reserva.exception.ReservaNãoAtualizadaException;
import com.example.Reserva.model.Reserva;
import com.example.Reserva.model.StatusReserva;
import com.example.Reserva.repository.ReservaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;


    public ReservaExibicaoDto salvar(ReservaCadastroDto reservaCadastro) {

        if (reservaRepository.existsByNomeHospede(reservaCadastro.nomeHospede())) {
            throw new HospedeExistenteException("Já existe um hóspede com esse nome!");
        }

        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaCadastro, reserva);
        reserva.setStatusReserva(StatusReserva.CONFIRMADA);

        return new ReservaExibicaoDto(reservaRepository.save(reserva));
    }

    public List<ReservaExibicaoDto> listaReserva() {
        List<Reserva> reserva = reservaRepository.findAll();
        return reserva
                .stream()
                .map(ReservaExibicaoDto::new)
                .toList();
    }

    public Reserva atualizar(Reserva reserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(reserva.getIdReserva());
        if (reservaOptional.isPresent()) {
            Reserva reservaAtualizada = reservaOptional.get();

            reservaAtualizada.setNomeHotel(reserva.getNomeHotel());
            reservaAtualizada.setNomeHospede(reserva.getNomeHospede());
            reservaAtualizada.setDataCheckin(reserva.getDataCheckin());
            reservaAtualizada.setDataCheckOut(reserva.getDataCheckOut());
            reservaAtualizada.setNumeroQuarto(reserva.getNumeroQuarto());
            reservaAtualizada.setStatusReserva(reserva.getStatusReserva());

            return reservaRepository.save(reservaAtualizada);
        } else {
            throw new ReservaNãoAtualizadaException("Atualização não efetuada!");
        }

    }

    public void excluir(Long idReserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(idReserva);

        if (reservaOptional.isPresent()) {
            reservaRepository.delete(reservaOptional.get());
        } else {
            throw new ReservaNaoLocalizada("Reserva não foi localizada!");
        }
    }

    public ReservaExibicaoDto buscarPorIdReserva(Long idReserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(idReserva);

        if (reservaOptional.isPresent()) {
            return new ReservaExibicaoDto(reservaOptional.get());
        } else {
            throw new ReservaNaoLocalizada("Reserva não foi localizada!");
        }
    }
}
