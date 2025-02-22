package com.example.Reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TB_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "ID_RESERVA")
    private Long idReserva;

    @Column(name = "Nm_HOTEL")
    private String nomeHotel;

    @Column(name = "NM_HOSPEDE")
    @NotBlank(message = "Informe o nome do hóspede.")
    private String nomeHospede;

    @Column(name = "DT_CHECK_IN")
    @NotNull(message = "A data de check-in é obrigatória")
    private String dataCheckIn;

    @Column(name = "DT_CHECK_OUT")
    @NotNull(message = "A data de check-out é obrigatória")
    private String dataCheckOut;

    @Column(name = "NRO_QUARTO")
    private Integer numeroQuarto;

    private StatusReserva statusReserva;

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }
}
