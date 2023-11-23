package com.tpg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tpg.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tpg.entity.Question;
import com.tpg.entity.Subject;
import com.tpg.exception.DuplicateException;
import com.tpg.repository.QuestionsRepository;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private SubjectService subjectService;

    public Iterable<Question> getAllQuestions() {
        return questionsRepository.findAll();
    }

    public QuestionsService(QuestionsRepository questionsRepository, SubjectService subjectService) {
        super();
        this.questionsRepository = questionsRepository;
        this.subjectService = subjectService;
    }

    public Question findById(int q_id) {
        return questionsRepository.findById(q_id).orElse(null);
    }

    public Question createQuestions(Question newQuestion) {
        int subjectId = newQuestion.getSubject().getSubjectId();
        Subject subject = subjectService.findById(subjectId);
        newQuestion.setSubject(subject);

        // Check if a question with the same actual question text already exists
        Question existingQuestion = questionsRepository.findByActualQns(newQuestion.getActual_qns());

        if (existingQuestion != null) {
            // Question with the same content already exists, return an error message
            throw new DuplicateException("Question with the same content already exists");
        }

        return questionsRepository.save(newQuestion);
    }

    public List<Question> createMultipleQuestions(List<Question> questions) {
        List<Question> savedQuestions = new ArrayList<>();

        for (Question question : questions) {
            int subjectId = question.getSubject().getSubjectId();
            Subject subject = subjectService.findById(subjectId);
            question.setSubject(subject);
            Question existingQuestion = questionsRepository.findByActualQns(question.getActual_qns());

            if (existingQuestion != null) {
                throw new DuplicateException("Question with the same content already exists");
            }
            else {
                savedQuestions.add(questionsRepository.save(question));
            }
        }

        return savedQuestions;
    }


    public Question updateQuestions(int q_id, Question questions) {
        questions.setQ_id(q_id);
        int subjectId = questions.getSubject().getSubjectId();
        Subject subject = subjectService.findById(subjectId);
        questions.setSubject(subject);
        return questionsRepository.save(questions);
    }

    public void deleteQuestions(int q_id) {
        Optional<Question> questions = questionsRepository.findById(q_id);
        if (questions.isPresent()) {
            questionsRepository.deleteById(q_id);
        }
    }

    public List<Question> findAll() {
        return questionsRepository.findAll();
    }
}
