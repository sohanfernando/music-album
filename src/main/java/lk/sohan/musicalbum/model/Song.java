package lk.sohan.musicalbum.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "song_name", nullable = false)
    private String songName;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    private String genre;
    private String year;
    private String duration;
}
