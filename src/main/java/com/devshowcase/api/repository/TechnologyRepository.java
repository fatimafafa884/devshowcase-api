package com.devshowcase.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devshowcase.api.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}