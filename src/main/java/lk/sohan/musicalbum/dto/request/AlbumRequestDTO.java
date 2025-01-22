package lk.sohan.musicalbum.dto.request;

import lombok.Data;

@Data
public class AlbumRequestDTO {
    private String albumName;
    private Long artistId;
    private String genre;
    private String year;
}
