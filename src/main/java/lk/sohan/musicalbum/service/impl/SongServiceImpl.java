package lk.sohan.musicalbum.service.impl;

import lk.sohan.musicalbum.dto.request.SongRequestDTO;
import lk.sohan.musicalbum.dto.response.AlbumResponseDTO;
import lk.sohan.musicalbum.dto.response.ArtistResponseDTO;
import lk.sohan.musicalbum.dto.response.SongResponseDTO;
import lk.sohan.musicalbum.model.Album;
import lk.sohan.musicalbum.model.Artist;
import lk.sohan.musicalbum.model.Song;
import lk.sohan.musicalbum.repository.AlbumRepository;
import lk.sohan.musicalbum.repository.SongRepository;
import lk.sohan.musicalbum.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    // Implement methods
    @Override
    public SongResponseDTO createSong(SongRequestDTO songRequestDTO){
        Album album = albumRepository.findById(songRequestDTO.getAlbumId()).orElseThrow(() -> new RuntimeException("Album not found"));

        //Map SongRequestDTO to Song Entity
        Song song = new Song();
        song.setSongName(songRequestDTO.getSongName());
        song.setGenre(songRequestDTO.getGenre());
        song.setYear(songRequestDTO.getYear());
        song.setDuration(songRequestDTO.getDuration());
        song.setAlbum(album);

        song = songRepository.save(song);

        return mapToResponseDTO(song);

    }

    @Override
    public List<SongResponseDTO> getAllSongs(){
        List<Song> songs = songRepository.findAll();
        return songs.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public SongResponseDTO getSongById(Long id){
        Song song = songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song not found"));
        return mapToResponseDTO(song);
    }

    @Override
    public void deleteSongById(Long id){
        // Check if the song exists
        if (!songRepository.existsById(id)) {
            throw new RuntimeException("Song not found with ID: " + id);
        }

        // Delete the song
        songRepository.deleteById(id);
    }

    // Helper method to map Song entity to SongResponseDTO
    private SongResponseDTO mapToResponseDTO(Song song) {
        SongResponseDTO responseDTO = new SongResponseDTO();
        responseDTO.setId(song.getId());
        responseDTO.setSongName(song.getSongName());
        responseDTO.setGenre(song.getGenre());
        responseDTO.setYear(song.getYear());
        responseDTO.setDuration(song.getDuration());

        // Map album details
        Album album = song.getAlbum();
        AlbumResponseDTO albumResponseDTO = new AlbumResponseDTO();
        albumResponseDTO.setId(album.getId());
        albumResponseDTO.setAlbumName(album.getAlbumName());
        albumResponseDTO.setGenre(album.getGenre());
        albumResponseDTO.setYear(album.getYear());

        // Map artist details to the album
        Artist artist = album.getArtist();
        if (artist != null) {
            ArtistResponseDTO artistResponseDTO = new ArtistResponseDTO();
            artistResponseDTO.setId(artist.getId());
            artistResponseDTO.setArtistName(artist.getArtistName());
            artistResponseDTO.setCountry(artist.getCountry());
            artistResponseDTO.setGenre(artist.getGenre());
            albumResponseDTO.setArtist(artistResponseDTO);
        }

        responseDTO.setAlbum(albumResponseDTO);

        return responseDTO;
    }

}
