package com.devshowcase.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devshowcase.api.model.Technology;
import com.devshowcase.api.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository repository;

    public TechnologyService(TechnologyRepository repository) {
        this.repository = repository;
    }

    public List<Technology> findAll() {
        return repository.findAll();
    }

    public Technology findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Technology save(Technology technology) {
        return repository.save(technology);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}