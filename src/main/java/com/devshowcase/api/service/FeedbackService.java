package com.devshowcase.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devshowcase.api.model.Feedback;
import com.devshowcase.api.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public Feedback findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}