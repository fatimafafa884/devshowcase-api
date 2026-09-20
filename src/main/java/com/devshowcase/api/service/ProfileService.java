package com.devshowcase.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devshowcase.api.model.Profile;
import com.devshowcase.api.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> findAll() {
        return repository.findAll();
    }

    public Profile findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Profile save(Profile profile) {
        return repository.save(profile);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}