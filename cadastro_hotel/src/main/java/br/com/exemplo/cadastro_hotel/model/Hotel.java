package br.com.exemplo.cadastro_hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "ID_HOTEL")
    private Long hotelId;

    @Column(name = "NM_HOTEL")
    @Size(min = 3, max = 100)
    @NotBlank(message = "Informe o nome do estabelecimento")
    private String nomeHotel;

    @Column(name = "QTDE_VAGA")
    @Positive
    @NotNull(message = "Quantidade Obrigatória!!")
    private Integer quantidadeVaga;

    @Column(name = "QDE_VAGA_DISPONIVEL")
    private Integer quantidadeVagaDisponivel;

    @NotBlank(message = "Informe o Endereço")
    private String endereco;

    @Column(name = "NM_MUNICIPIO")
    @NotBlank(message = "Informe o Município")
    private String nomeMunicipio;

    @Column(name = "NM_ESTADO")
    @NotBlank(message = "Informe o Estado")
    private String nomeEstado;


    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public Integer getQuantidadeVaga() {
        return quantidadeVaga;
    }

    public void setQuantidadeVaga(Integer quantidadeVaga) {
        this.quantidadeVaga = quantidadeVaga;
    }

    public Integer getQuantidadeVagaDisponivel() {
        return quantidadeVagaDisponivel;
    }

    public void setQuantidadeVagaDisponivel(Integer quantidadeVagaDisponivel) {
        this.quantidadeVagaDisponivel = quantidadeVagaDisponivel;
    }
}
