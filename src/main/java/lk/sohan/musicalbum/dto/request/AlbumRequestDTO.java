package lk.sohan.musicalbum.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumRequestDTO {
    private String albumName;
    private Long artistId;
    private String genre;
    private String year;
}
