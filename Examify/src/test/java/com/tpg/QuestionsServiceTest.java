package com.tpg;

import com.tpg.entity.Question;
import com.tpg.entity.Subject;
import com.tpg.repository.QuestionsRepository;
import com.tpg.service.QuestionsService;
import com.tpg.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class QuestionsServiceTest {

    @Mock
    private QuestionsRepository questionsRepository;

    @Mock
    private SubjectService subjectService;

    @InjectMocks
    private QuestionsService questionsService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllQuestions() {
        // Mock the repository's findAll method
        List<Question> questions = new ArrayList<>();
        when(questionsRepository.findAll()).thenReturn(questions);

        Iterable<Question> retrievedQuestions = questionsService.getAllQuestions();

        assertNotNull(retrievedQuestions);
        assertEquals(0, ((List<Question>) retrievedQuestions).size());
    }

    @Test
    public void testCreateQuestions() {
        // Create a sample question and subject
        Question question = new Question();
        Subject subject = new Subject(1, "Sample Subject");
        question.setSubject(subject);

        // Mock the subjectService's findById method
        when(subjectService.findById(1)).thenReturn(subject);

        // Mock the repository's save method
        when(questionsRepository.save(any(Question.class))).thenReturn(question);

        Question createdQuestion = questionsService.createQuestions(question);

        assertNotNull(createdQuestion);
        assertEquals(question.getSubject(), createdQuestion.getSubject());
    }

    @Test
    public void testCreateMultipleQuestions() {
        List<Question> questionsList = new ArrayList<>();
        // Create sample questions and subjects
        Question question1 = new Question();
        Question question2 = new Question();
        Subject subject1 = new Subject(1, "Subject 1");
        Subject subject2 = new Subject(2, "Subject 2");
        question1.setSubject(subject1);
        question2.setSubject(subject2);
        questionsList.add(question1);
        questionsList.add(question2);

        when(subjectService.findById(1)).thenReturn(subject1);
        when(subjectService.findById(2)).thenReturn(subject2);
        when(questionsRepository.save(any(Question.class))).thenReturn(question1, question2);

        List<Question> savedQuestions = questionsService.createMultipleQuestions(questionsList);

        assertNotNull(savedQuestions);
        assertEquals(2, savedQuestions.size());
        assertEquals(subject1, savedQuestions.get(0).getSubject());
        assertEquals(subject2, savedQuestions.get(1).getSubject());
    }

    @Test
    public void testUpdateQuestions() {
        int questionId = 1;
        Question question = new Question();
        Subject subject = new Subject(1, "Sample Subject");
        question.setQ_id(questionId);
        question.setSubject(subject);

        when(subjectService.findById(1)).thenReturn(subject);
        when(questionsRepository.save(any(Question.class))).thenReturn(question);

        Question updatedQuestion = questionsService.updateQuestions(questionId, question);

        assertNotNull(updatedQuestion);
        assertEquals(question.getSubject(), updatedQuestion.getSubject());
        assertEquals(questionId, updatedQuestion.getQ_id());
    }

    @Test
    public void testDeleteQuestions() {
        int questionId = 1;
        when(questionsRepository.findById(questionId)).thenReturn(Optional.of(new Question()));

        questionsService.deleteQuestions(questionId);

        verify(questionsRepository, times(1)).deleteById(questionId);
    }

    @Test
    public void testFindAll() {
        List<Question> questionsList = new ArrayList<>();
        when(questionsRepository.findAll()).thenReturn(questionsList);

        List<Question> retrievedQuestions = questionsService.findAll();

        assertNotNull(retrievedQuestions);
        assertEquals(0, retrievedQuestions.size());
    }
}
