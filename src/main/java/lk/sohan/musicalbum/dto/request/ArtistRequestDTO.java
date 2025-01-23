package lk.sohan.musicalbum.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistRequestDTO {
    private String artistName;
    private String country;
    private String genre;
}
