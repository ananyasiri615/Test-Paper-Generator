package com.tpg;

import com.tpg.entity.Feedback;
import com.tpg.repository.FeedbackRepository;
import com.tpg.service.FeedbackService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSubmitFeedback() {
        // Create a sample feedback
        Feedback feedback = new Feedback();
        feedback.setId(1L);
        feedback.setExamFeedback("Test feedback message");

        // Mock the repository's save method
        when(feedbackRepository.save(feedback)).thenReturn(feedback);

        // Call the service method
        Feedback submittedFeedback = feedbackService.submitFeedback(feedback);

        // Check if the submitted feedback matches the expected feedback
        assertEquals(1L, submittedFeedback.getId().longValue());
        assertEquals("Test feedback message", submittedFeedback.getExamFeedback());
    }

    @Test
    public void testGetAllFeedback() {
        // Create a list of feedback for testing
        Feedback feedback1 = new Feedback();
        feedback1.setId(1L);
        feedback1.setExamFeedback("Feedback 1");

        Feedback feedback2 = new Feedback();
        feedback2.setId(2L);
        feedback2.setExamFeedback("Feedback 2");

        when(feedbackRepository.findAll()).thenReturn(Arrays.asList(feedback1, feedback2));

        // Call the service method
        Iterable<Feedback> allFeedback = feedbackService.getAllFeedback();

        // Check if the retrieved feedback matches the expected feedback
        int count = 0;
        for (Feedback feedback : allFeedback) {
            if (count == 0) {
                assertEquals(1L, feedback.getId().longValue());
                assertEquals("Feedback 1", feedback.getExamFeedback());
            } else if (count == 1) {
                assertEquals(2L, feedback.getId().longValue());
                assertEquals("Feedback 2", feedback.getExamFeedback());
            }
            count++;
        }
    }
}