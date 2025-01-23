package br.com.exemplo.cadastro_hotel.repository;

import br.com.exemplo.cadastro_hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByNomeMunicipioAndNomeEstado(String nomeMunicipio, String nomeEstado);

    List<Hotel> findByNomeEstado(String nomeEstado);

    boolean existsByNomeHotel(String nomeHotel);

}
