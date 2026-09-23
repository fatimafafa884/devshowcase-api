package com.devshowcase.api.service;

import java.util.List;
import com.devshowcase.api.model.Project;
import com.devshowcase.api.repository.ProjectRepository;

import org.springframework.stereotype.Service;

import com.devshowcase.api.model.Feedback;
import com.devshowcase.api.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;
    
    private final ProjectRepository projectRepository;

    public FeedbackService(FeedbackRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public Feedback findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Feedback save(Feedback feedback) {
        Project project = projectRepository.findById(feedback.getProject().getId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        feedback.setProject(project);

        Feedback saved = repository.save(feedback);

        List<Feedback> feedbacks = repository.findAll();

        double average = feedbacks.stream()
                .filter(f -> f.getProject() != null)
                .filter(f -> f.getProject().getId().equals(project.getId()))
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);

        project.setAverageRating(average);
        projectRepository.save(project);

        return saved;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}