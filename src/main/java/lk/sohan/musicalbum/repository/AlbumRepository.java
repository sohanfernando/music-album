package lk.sohan.musicalbum.repository;

import lk.sohan.musicalbum.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
