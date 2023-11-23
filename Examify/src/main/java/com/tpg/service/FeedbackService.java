package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Feedback;
import com.tpg.repository.FeedbackRepository;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback submitFeedback(Feedback feedback) {
        // Add any business logic or validation here if needed
        return feedbackRepository.save(feedback);
    }

    public Iterable<Feedback> getAllFeedback() {
        // Retrieve all feedback entries
        return feedbackRepository.findAll();
    }
}