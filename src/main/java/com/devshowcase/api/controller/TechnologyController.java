package com.devshowcase.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devshowcase.api.model.Technology;
import com.devshowcase.api.service.TechnologyService;
import jakarta.validation.Valid;
import com.devshowcase.api.dto.TechnologyDTO;

import com.devshowcase.api.dto.TechnologyResponseDTO;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Technology> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TechnologyResponseDTO findById(@PathVariable Long id) {
        Technology technology = service.findById(id);

        if (technology == null) {
            return null;
        }

        return new TechnologyResponseDTO(
            technology.getId(),
            technology.getName()
        );
    }
    

    @PostMapping
    public Technology save(@Valid @RequestBody TechnologyDTO dto) {
        Technology technology = new Technology();

        technology.setName(dto.getName());

        return service.save(technology);
    }
    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}