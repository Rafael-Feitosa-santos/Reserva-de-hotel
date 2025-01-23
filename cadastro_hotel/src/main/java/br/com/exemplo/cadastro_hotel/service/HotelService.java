package br.com.exemplo.cadastro_hotel.service;

import br.com.exemplo.cadastro_hotel.dto.HotelCadastroDto;
import br.com.exemplo.cadastro_hotel.dto.HotelExibicaoDto;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoAtualizadoException;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoEncontradoException;
import br.com.exemplo.cadastro_hotel.exception.HotelNaoLocalizado;
import br.com.exemplo.cadastro_hotel.exception.HotelNomeExistenteException;
import br.com.exemplo.cadastro_hotel.model.Hotel;
import br.com.exemplo.cadastro_hotel.repository.HotelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelExibicaoDto criar(HotelCadastroDto hotelCadastroDto) {

        // Verifica se já existe um hotel com o mesmo nome
        if (hotelRepository.existsByNomeHotel(hotelCadastroDto.nomeHotel())) {
            throw new HotelNomeExistenteException("Já existe um hotel com esse nome.");
        }

        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelCadastroDto, hotel);

        Hotel hotelCriado = hotelRepository.save(hotel);

        return new HotelExibicaoDto(hotelCriado);
    }

    public HotelExibicaoDto buscarPorIdHotel(Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);

        if (hotelOptional.isPresent()) {
            return new HotelExibicaoDto(hotelOptional.get());
        } else {
            throw new HotelNaoEncontradoException("Hotel não encontrado!");
        }
    }


    public List<HotelExibicaoDto> listaHotel() {
        List<Hotel> hotel = hotelRepository.findAll();
        return hotel
                .stream()
                .map(HotelExibicaoDto::new)
                .toList();
    }

    public Hotel atualizar(Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotel.getHotelId());
        if (hotelOptional.isPresent()) {
            Hotel hotelExistente = hotelOptional.get();

            hotelExistente.setNomeHotel(hotel.getNomeHotel());
            hotelExistente.setQuantidadeVaga(hotel.getQuantidadeVaga());
            hotelExistente.setQuantidadeVagaDisponivel(hotel.getQuantidadeVagaDisponivel());
            hotelExistente.setEndereco(hotel.getEndereco());
            hotelExistente.setNomeMunicipio(hotel.getNomeMunicipio());
            hotelExistente.setNomeEstado(hotel.getNomeEstado());


            return hotelRepository.save(hotelExistente);
        } else {
            throw new HotelNaoAtualizadoException("Atualização não efetuada!");
        }
    }

    public void excluir(Long hotelId) {

        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);

        if (hotelOptional.isPresent()) {
            hotelRepository.delete(hotelOptional.get());
        } else {
            throw new HotelNaoLocalizado("Hotel não encontrada!");
        }
    }

    public List<Hotel> buscarHoteisPorMunicipioEEstado(String municipio, String estado) {
        return hotelRepository.findByNomeMunicipioAndNomeEstado(municipio, estado);
    }

    public List<Hotel> buscarHoteisPorEstado(String estado) {

        return hotelRepository.findByNomeEstado(estado);
    }


}
