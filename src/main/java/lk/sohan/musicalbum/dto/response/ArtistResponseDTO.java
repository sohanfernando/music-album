package lk.sohan.musicalbum.dto.response;

import lombok.Data;

@Data
public class ArtistResponseDTO {
    private Long id;
    private String artistName;
    private String country;
    private String genre;
}
