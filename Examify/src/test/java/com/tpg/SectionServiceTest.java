package com.tpg;

import com.tpg.entity.Question;
import com.tpg.entity.Section;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.SectionRepository;
import com.tpg.repository.UserAnswerRepository;
import com.tpg.service.SectionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SectionServiceTest {

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private QuestionsRepository questionsRepository;

    @Mock
    private UserAnswerRepository userAnswerRepository;

    @InjectMocks
    private SectionService sectionService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testGenerateRandomSection() {
//        // Mock data for testing
//        List<Question> allQuestions = new ArrayList<>();
//        Question question1 = new Question();
//        question1.setQ_id(1);
//        allQuestions.add(question1);
//
//        when(questionsRepository.findBySubjectSubjectId(1)).thenReturn(allQuestions);
//
//        // Call the service method
//        Section section = sectionService.generateRandomSection(1, 1);
//
//        // Check if the generated section is as expected
//        assertEquals(1, section.getSubject().getSubjectId());
//        assertEquals(1, section.getNumberOfQuestions());
//        assertEquals(1, section.getQuestions().size());
//    }

//    @Test
//    public void testCalculateResult() {
//        // Mock data for testing
//        List<Section> sectionList = new ArrayList<>();
//        Section section = new Section();
//        section.setSection_id(1);
//
//        List<Question> questions = new ArrayList<>();
//        Question question = new Question();
//        question.setQ_id(1);
//        question.setCorrect_op("A");
//        questions.add(question);
//
//        section.setQuestions(questions);
//
//        sectionList.add(section);
//
//        sectionService = new SectionService(sectionList, sectionRepository, questionsRepository, userAnswerRepository);
//
//        Map<Integer, String> answers = Map.of(1, "A");
//
//        // Call the service method
//        int totalMarks = sectionService.CalculateResult(answers);
//
//        // Check if the calculated result is as expected
//        assertEquals(1, totalMarks);
//    }

//    @Test
//    public void testCalculateFlaggedQuestions() {
//        // Mock data for testing
//        List<Question> questions = new ArrayList<>();
//        Question question1 = new Question();
//        question1.setQ_id(1);
//
//        List<Question> flaggedQuestions = new ArrayList<>();
//        flaggedQuestions.add(question1);
//
//        Map<Integer, Boolean> isFlagged = Map.of(1, true);
//
//        // Call the service method
//        int flaggedCount = sectionService.calculateFlaggedQuestions(isFlagged, flaggedQuestions);
//
//        // Check if the flagged count is as expected
//        assertEquals(1, flaggedCount);
//    }

    // Add more test methods as needed for your SectionService class.

}
