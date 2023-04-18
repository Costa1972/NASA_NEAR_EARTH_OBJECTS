package ru.costa.nasa_near_earth_objects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.costa.nasa_near_earth_objects.Url;
import ru.costa.nasa_near_earth_objects.repository.UrlRepository;

import java.util.List;

@Service
public class UrlService {

    public UrlRepository repository;

    @Autowired
    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public List<Url> getAll(){
        return repository.findAll();
    }

    public void add(Url url) {
        repository.save(url);
    }
    public Url getById(Long id) {
        return repository.getById(id);
    }
    public boolean existsByUrl(String url) {
        return repository.existsByPhotosUrl(url);
    }
}
