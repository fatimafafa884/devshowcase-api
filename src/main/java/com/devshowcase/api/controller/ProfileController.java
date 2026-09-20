package com.devshowcase.api.controller;

import java.util.List;
import jakarta.validation.Valid;
import com.devshowcase.api.dto.ProfileDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devshowcase.api.model.Profile;
import com.devshowcase.api.service.ProfileService;
import com.devshowcase.api.dto.ProfileResponseDTO;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profile> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProfileResponseDTO findById(@PathVariable Long id) {
        Profile profile = service.findById(id);

        if (profile == null) {
            return null;
        }

        return new ProfileResponseDTO(
            profile.getId(),
            profile.getName(),
            profile.getBio(),
            profile.getEmail()
        );
    }

    @PostMapping
    public Profile save(@Valid @RequestBody ProfileDTO dto) {
        Profile profile = new Profile();

        profile.setName(dto.getName());
        profile.setBio(dto.getBio());
        profile.setEmail(dto.getEmail());

        return service.save(profile);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}