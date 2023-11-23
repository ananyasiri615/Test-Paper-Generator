package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.tpg.entity.Feedback;
import com.tpg.repository.FeedbackRepository;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping("/submit")
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        // Save the feedback to the database
        return feedbackRepository.save(feedback);
    }

    @GetMapping("/all")
    public Iterable<Feedback> getAllFeedback() {
        // Retrieve all feedback entries
        return feedbackRepository.findAll();
    }
}