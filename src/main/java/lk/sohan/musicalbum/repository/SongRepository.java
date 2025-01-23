package lk.sohan.musicalbum.repository;

import lk.sohan.musicalbum.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
