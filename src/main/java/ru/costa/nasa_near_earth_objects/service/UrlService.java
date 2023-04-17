package ru.costa.nasa_near_earth_objects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.costa.nasa_near_earth_objects.Url;
import ru.costa.nasa_near_earth_objects.repository.UrlRepository;

@Service
public class UrlService {

    public UrlRepository repository;

    @Autowired
    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public void add(Url url) {
        repository.save(url);
    }
    public boolean existsByUrl(String url) {
        return repository.existsByPhotosUrl(url);
    }
}
