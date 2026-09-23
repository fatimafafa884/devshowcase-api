package com.devshowcase.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.devshowcase.api.dto.FeedbackDTO;
import com.devshowcase.api.dto.ProjectDTO;
import com.devshowcase.api.dto.ProjectResponseDTO;
import com.devshowcase.api.model.Feedback;
import com.devshowcase.api.model.Project;
import com.devshowcase.api.service.FeedbackService;
import com.devshowcase.api.service.ProjectService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;
    private final FeedbackService feedbackService;

    public ProjectController(ProjectService service, FeedbackService feedbackService) {
        this.service = service;
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public org.springframework.data.domain.Page<Project> findAll(
            @RequestParam(required = false) String technology,
            org.springframework.data.domain.Pageable pageable) {

        return service.findAll(technology, pageable);
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO findById(@PathVariable Long id) {
        Project project = service.findById(id);

        if (project == null) {
        	throw new RuntimeException("Projeto não encontrado");
        }

        return new ProjectResponseDTO(
        	    project.getId(),
        	    project.getName(),
        	    project.getDescription(),
        	    project.getUrl(),
        	    project.getAverageRating()
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
    @PostMapping("/{id}/feedbacks")
    public FeedbackDTO addFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackDTO dto) {

        Feedback feedback = new Feedback();

        feedback.setComment(dto.getComment());
        feedback.setRating(dto.getRating());

        Project project = service.findById(id);

        if (project == null) {
            return null;
        }

        feedback.setProject(project);

        Feedback saved = feedbackService.save(feedback);

        dto.setId(saved.getId());
        dto.setProjectId(id);

        return dto;
    }
    @PutMapping("/{id}/upvote")
    public Project upvote(@PathVariable Long id) {
        return service.upvote(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
   
}