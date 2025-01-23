package lk.sohan.musicalbum.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistResponseDTO {
    private Long id;
    private String artistName;
    private String country;
    private String genre;
}
