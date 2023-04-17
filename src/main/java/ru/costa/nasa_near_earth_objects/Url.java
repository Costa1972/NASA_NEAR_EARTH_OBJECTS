package ru.costa.nasa_near_earth_objects;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "urls")
@NoArgsConstructor
@Builder
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "photos_url", length = 2048)
    private String photosUrl;

    public Url(Long id, String photos_url) {
        this.id = id;
        this.photosUrl = photos_url;
    }
}
