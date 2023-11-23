package com.tpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Question;
import com.tpg.entity.TestHistory;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.TestHistoryRepository;

@Service
public class TestHistoryService {

    @Autowired
    private TestHistoryRepository testrepo;
    @Autowired
    private QuestionsRepository questionRepository; // Assuming you have a Question repository

    public List<TestHistory> createTestHistoryList(List<TestHistory> userAnswers) {
        List<TestHistory> testHistoryList = new ArrayList<>();

        for (TestHistory testhistory : userAnswers) {
            if (testhistory != null) {
                // Get the question by its ID from the database
                int q_id = testhistory.getQuestion().getQ_id();
                Question question = questionRepository.findById(q_id).orElse(null);
                

                if (question != null) {
                    // Associate the question with the TestHistory
                	testhistory.setQuestion(question);
                	testhistory.setQuestion_name(question.getActual_qns());
                	testhistory.setCorrect_option(question.getCorrect_op());
                	testhistory.setLevel(question.getLevel());
                    // Save the TestHistory object
                    testHistoryList.add(testhistory);
                }
            }
        }
        
        // Save all the associated TestHistory objects
        testrepo.saveAll(testHistoryList);

        return testHistoryList;
    }
    
    
    public List<TestHistory> getTestHistoryByUsername(String username) {
        return testrepo.findByUsername(username);
    }
    public List<TestHistory> getAllTestHistory() {
        return testrepo.findAll();
    }
}







