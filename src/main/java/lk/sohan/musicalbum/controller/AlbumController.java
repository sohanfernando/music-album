package lk.sohan.musicalbum.controller;

import lk.sohan.musicalbum.dto.request.AlbumRequestDTO;
import lk.sohan.musicalbum.dto.response.AlbumResponseDTO;
import lk.sohan.musicalbum.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @PostMapping("/albums")
    public ResponseEntity<AlbumResponseDTO> createAlbum(@RequestBody AlbumRequestDTO albumRequestDTO){
        return ResponseEntity.ok(albumService.createAlbum(albumRequestDTO));
    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumResponseDTO>> getAllAlbums(){
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<AlbumResponseDTO> getAlbumById(@PathVariable Long id){
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<Void> deleteAlbumById(@PathVariable Long id){
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().build();
    }
}
