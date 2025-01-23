package lk.sohan.musicalbum.service;

import lk.sohan.musicalbum.dto.request.AlbumRequestDTO;
import lk.sohan.musicalbum.dto.response.AlbumResponseDTO;

import java.util.List;

public interface AlbumService {
    AlbumResponseDTO createAlbum(AlbumRequestDTO albumRequestDTO);
    List<AlbumResponseDTO> getAllAlbums();
    AlbumResponseDTO getAlbumById(Long id);
    void deleteAlbumById(Long id);
}
