package lk.sohan.musicalbum.service.impl;

import lk.sohan.musicalbum.dto.request.ArtistRequestDTO;
import lk.sohan.musicalbum.dto.response.ArtistResponseDTO;
import lk.sohan.musicalbum.model.Artist;
import lk.sohan.musicalbum.repository.ArtistRepository;
import lk.sohan.musicalbum.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public ArtistResponseDTO createArtist(ArtistRequestDTO artistRequestDTO){
        Artist artist = new Artist();
        artist.setArtistName(artistRequestDTO.getArtistName());
        artist.setCountry(artistRequestDTO.getCountry());
        artist.setGenre(artistRequestDTO.getGenre());

        artist = artistRepository.save(artist);

        return mapToResponseDTO(artist);

    }

    @Override
    public List<ArtistResponseDTO> getAllArtists(){
        return artistRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistResponseDTO getArtistById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        return mapToResponseDTO(artist);
    }

    @Override
    public void deleteArtistById(Long id) {
        artistRepository.deleteById(id);
    }

    // Helper method to map Artist entity to ArtistResponseDTO
    private ArtistResponseDTO mapToResponseDTO(Artist artist) {
        ArtistResponseDTO responseDTO = new ArtistResponseDTO();
        responseDTO.setId(artist.getId());
        responseDTO.setArtistName(artist.getArtistName());
        responseDTO.setCountry(artist.getCountry());
        responseDTO.setGenre(artist.getGenre());
        return responseDTO;
    }


}
