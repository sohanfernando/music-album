package lk.sohan.musicalbum.dto.response;

import lombok.Data;

@Data
public class AlbumResponseDTO {
    private Long id;
    private String albumName;
    private String genre;
    private String year;
    private ArtistResponseDTO artist;
}
