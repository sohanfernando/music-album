package lk.sohan.musicalbum.service;

import lk.sohan.musicalbum.dto.request.SongRequestDTO;
import lk.sohan.musicalbum.dto.response.SongResponseDTO;

import java.util.List;

public interface SongService {
    SongResponseDTO createSong(SongRequestDTO songRequestDTO);
    List<SongResponseDTO> getAllSongs();
    SongResponseDTO getSongById(Long id);
    void deleteSongById(Long id);
}
