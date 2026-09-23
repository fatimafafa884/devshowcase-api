package com.devshowcase.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devshowcase.api.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Page<Project> findByTechnologies_NameContainingIgnoreCase(
            String technology,
            Pageable pageable
    );
}