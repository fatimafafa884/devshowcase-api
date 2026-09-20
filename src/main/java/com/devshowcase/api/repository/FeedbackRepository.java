package com.devshowcase.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devshowcase.api.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}