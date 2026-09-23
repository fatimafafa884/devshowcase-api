package com.devshowcase.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devshowcase.api.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findByProjectId(Long projectId);
}