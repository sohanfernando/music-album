package lk.sohan.musicalbum.dto.request;

import lombok.Data;

@Data
public class SongRequestDTO {
    private String songName;
    private Long albumId;
    private String genre;
    private String year;
    private String duration;
}
