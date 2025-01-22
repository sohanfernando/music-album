package lk.sohan.musicalbum.dto.response;

import lombok.Data;

@Data
public class SongResponseDTO {
    private Long id;
    private String songName;
    private String genre;
    private String year;
    private String duration;
    private AlbumResponseDTO album;
}
