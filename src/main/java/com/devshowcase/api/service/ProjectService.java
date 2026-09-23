package com.devshowcase.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devshowcase.api.model.Project;
import com.devshowcase.api.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return repository.save(project);
    }
    public Project upvote(Long id) {
        Project project = repository.findById(id).orElse(null);

        if (project == null) {
            return null;
        }

        if (project.getUpvotes() == null) {
            project.setUpvotes(0);
        }

        project.setUpvotes(project.getUpvotes() + 1);

        return repository.save(project);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public org.springframework.data.domain.Page<Project> findAll(
            String technology,
            org.springframework.data.domain.Pageable pageable) {

        if (technology == null || technology.isBlank()) {
            return repository.findAll(pageable);
        }

        return repository.findByTechnologies_NameContainingIgnoreCase(
                technology,
                pageable
        );
    }
}
