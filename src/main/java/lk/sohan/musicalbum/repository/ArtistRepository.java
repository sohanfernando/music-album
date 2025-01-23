package lk.sohan.musicalbum.repository;

import lk.sohan.musicalbum.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
