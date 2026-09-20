package com.devshowcase.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devshowcase.api.model.Feedback;
import com.devshowcase.api.service.FeedbackService;

import jakarta.validation.Valid;
import com.devshowcase.api.dto.FeedbackDTO;

import com.devshowcase.api.dto.FeedbackResponseDTO;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FeedbackResponseDTO findById(@PathVariable Long id) {
        Feedback feedback = service.findById(id);

        if (feedback == null) {
            return null;
        }

        Long projectId = null;

        if (feedback.getProject() != null) {
            projectId = feedback.getProject().getId();
        }

        return new FeedbackResponseDTO(
            feedback.getId(),
            feedback.getComment(),
            projectId
        );
    }

    @PostMapping
    public Feedback save(@Valid @RequestBody FeedbackDTO dto) {
        Feedback feedback = new Feedback();

        feedback.setComment(dto.getComment());

        return service.save(feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}