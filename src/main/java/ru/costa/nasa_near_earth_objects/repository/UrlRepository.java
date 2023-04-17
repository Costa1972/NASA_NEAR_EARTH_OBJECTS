package ru.costa.nasa_near_earth_objects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.costa.nasa_near_earth_objects.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    boolean existsByPhotosUrl(String url);
}
