package lk.sohan.musicalbum.controller;

import lk.sohan.musicalbum.dto.request.ArtistRequestDTO;
import lk.sohan.musicalbum.dto.response.ArtistResponseDTO;
import lk.sohan.musicalbum.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/artists")
    public ResponseEntity<ArtistResponseDTO> createArtist(@RequestBody ArtistRequestDTO artistRequestDTO) {
        return ResponseEntity.ok(artistService.createArtist(artistRequestDTO));
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistResponseDTO>> getAllArtists(){
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistResponseDTO> getArtistById(@PathVariable Long id){
        return ResponseEntity.ok(artistService.getArtistById(id));
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteArtistById(@PathVariable Long id){
        artistService.deleteArtistById(id);
        return ResponseEntity.noContent().build();
    }
}
