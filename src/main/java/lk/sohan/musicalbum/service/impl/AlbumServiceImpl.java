package lk.sohan.musicalbum.service.impl;

import lk.sohan.musicalbum.dto.request.AlbumRequestDTO;
import lk.sohan.musicalbum.dto.response.AlbumResponseDTO;
import lk.sohan.musicalbum.dto.response.ArtistResponseDTO;
import lk.sohan.musicalbum.model.Album;
import lk.sohan.musicalbum.model.Artist;
import lk.sohan.musicalbum.repository.AlbumRepository;
import lk.sohan.musicalbum.repository.ArtistRepository;
import lk.sohan.musicalbum.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public AlbumResponseDTO createAlbum(AlbumRequestDTO albumRequestDTO){
        Artist artist = artistRepository.findById(albumRequestDTO.getArtistId()).orElseThrow(() -> new RuntimeException("Artist not found"));

        Album album = new Album();
        album.setAlbumName(albumRequestDTO.getAlbumName());
        album.setGenre(albumRequestDTO.getGenre());
        album.setYear(albumRequestDTO.getYear());
        album.setArtist(artist);

        album = albumRepository.save(album);

        return mapToResponseDTO(album);
    }

    @Override
    public List<AlbumResponseDTO> getAllAlbums(){
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public AlbumResponseDTO getAlbumById(Long id){
        Album album = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        return mapToResponseDTO(album);
    }

    @Override
    public void deleteAlbumById(Long id){
        albumRepository.deleteById(id);
    }

    // Helper method to map Album entity to AlbumResponseDTO
    private AlbumResponseDTO mapToResponseDTO(Album album) {
        AlbumResponseDTO responseDTO = new AlbumResponseDTO();
        responseDTO.setId(album.getId());
        responseDTO.setAlbumName(album.getAlbumName());
        responseDTO.setGenre(album.getGenre());
        responseDTO.setYear(album.getYear());

        // Map artist details to ArtistResponseDTO
        Artist artist = album.getArtist();
        responseDTO.setArtist(new ArtistResponseDTO());
        responseDTO.getArtist().setId(artist.getId());
        responseDTO.getArtist().setArtistName(artist.getArtistName());
        responseDTO.getArtist().setCountry(artist.getCountry());
        responseDTO.getArtist().setGenre(artist.getGenre());

        return responseDTO;
    }
}
