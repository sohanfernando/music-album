package lk.sohan.musicalbum.service;

import lk.sohan.musicalbum.dto.request.ArtistRequestDTO;
import lk.sohan.musicalbum.dto.response.ArtistResponseDTO;

import java.util.List;

public interface ArtistService {
    ArtistResponseDTO createArtist(ArtistRequestDTO artistRequestDTO);
    List<ArtistResponseDTO> getAllArtists();
    ArtistResponseDTO getArtistById(Long id);
    void deleteArtistById(Long id);
}
