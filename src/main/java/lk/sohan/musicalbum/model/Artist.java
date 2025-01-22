package lk.sohan.musicalbum.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name", nullable = false)
    private String artistName;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    private String country;
    private String genre;

}
