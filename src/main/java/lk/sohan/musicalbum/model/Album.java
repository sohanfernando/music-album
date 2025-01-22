package lk.sohan.musicalbum.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    private String genre;
    private String year;
}
