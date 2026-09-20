package com.devshowcase.api.controller;

import java.util.List;
import jakarta.validation.Valid;
import com.devshowcase.api.dto.ProjectDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devshowcase.api.dto.ProjectDTO;
import com.devshowcase.api.dto.ProjectResponseDTO;
import com.devshowcase.api.model.Project;

import com.devshowcase.api.model.Project;
import com.devshowcase.api.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO findById(@PathVariable Long id) {
        Project project = service.findById(id);

        if (project == null) {
            return null;
        }

        return new ProjectResponseDTO(
            project.getId(),
            project.getName(),
            project.getDescription(),
            project.getUrl()
        );
    }

    @PostMapping
    public Project save(@Valid @RequestBody ProjectDTO dto) {
        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setUrl(dto.getUrl());

        return service.save(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}