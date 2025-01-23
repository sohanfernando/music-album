package lk.sohan.musicalbum.controller;

import lk.sohan.musicalbum.dto.request.SongRequestDTO;
import lk.sohan.musicalbum.dto.response.SongResponseDTO;
import lk.sohan.musicalbum.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @PostMapping("/songs")
    public ResponseEntity<SongResponseDTO> createSong(@RequestBody SongRequestDTO songRequestDTO) {
        return ResponseEntity.ok(songService.createSong(songRequestDTO));
    }

    @GetMapping("/songs")
    public ResponseEntity<List<SongResponseDTO>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<SongResponseDTO> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Void> deleteSongById(@PathVariable Long id) {
        songService.deleteSongById(id);
        return ResponseEntity.ok().build();
    }
}
