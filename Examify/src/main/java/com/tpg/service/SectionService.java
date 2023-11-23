package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpg.entity.Question;
import com.tpg.entity.Section;
import com.tpg.entity.Subject;
import com.tpg.entity.TestPaper;
import com.tpg.entity.UserAnswer;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.SectionRepository;
import com.tpg.repository.TestPaperRepository;
import com.tpg.repository.UserAnswerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


import javax.persistence.EntityManager;

@Service
public class SectionService {

	private List<Section> sectionlist = new ArrayList();

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private UserAnswerRepository userAnswerRepository;

//    @Autowired
//    private TestPaperRepository testPaperRepository;
//
    public SectionService(List<Section> sectionlist, SectionRepository sectionRepository,
    		QuestionsRepository questionsRepository, UserAnswerRepository userAnswerRepository) {
    	super();
    	this.sectionlist = sectionlist;
    	this.sectionRepository = sectionRepository;
    	this.questionsRepository = questionsRepository;
    	this.userAnswerRepository = userAnswerRepository;
    }




    public Section generateRandomSection(int subjectId, int numberOfQuestions) {
        // Get all questions for the given subject
        List<Question> allQuestions = questionsRepository.findBySubjectSubjectId(subjectId);

        // Check if there are enough questions available for the given subject
        if (allQuestions.size() < numberOfQuestions) {
            throw new IllegalArgumentException("Not enough questions available for the subject.");
        }

        // Shuffle the questions and select the first 'numberOfQuestions' questions
        List<Question> randomQuestions = getRandomQuestions(allQuestions, numberOfQuestions);

        // Create a new Section object
        Section section = new Section();
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        section.setSubject(subject);
        section.setNumberOfQuestions(numberOfQuestions);
        section.setQuestions(randomQuestions);

        // Save the section to the database
        section = sectionRepository.save(section);

        sectionlist.add(section);
        return section;
    }




	// Get all sections
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(int section_id) {
        return sectionRepository.findSectionWithQuestions(section_id);
    }

//    public int CalculateResult(Map<Integer, String> answers, Map<Integer, Boolean> isFlagged) {
//        int totalMarks = 0;
//        for (Section section : sectionlist) {
//            for (Question question : section.getQuestions()) {
//                if (answers.containsKey(question.getQ_id())) {
//                    if (question.getCorrect_op().equalsIgnoreCase(answers.get(question.getQ_id()))) {
//                        totalMarks++;
//                    }
//                }
//
//                // Toggle the flag for the question
//                isFlagged.put(question.getQ_id(), !isFlagged.getOrDefault(question.getQ_id(), false));
//            }
//
//            section.setTotalmarks(totalMarks);
//            sectionRepository.save(section);
//        }
//
//        return totalMarks;
//    }

//    public int CalculateResult(Map<Integer, String> answers) {
//        int totalMarks = 0;
//        for (Section section : sectionlist) {
//            for (Question question : section.getQuestions()) {
//                if (answers.containsKey(question.getQ_id())) {
//                    if (question.getCorrect_op().equalsIgnoreCase(answers.get(question.getQ_id()))) {
//                        totalMarks++;
//                    }
//                }
//
//            }
//
//        }
//
//        return totalMarks;
//    }
//
//    public int calculateFlaggedQuestions(Map<Integer, Boolean> isFlagged, List<Question> questions) {
//        int flaggedCount = 0;
//
//        for (Question question : questions) {
//            // Convert the question ID to an Integer for matching
//            Integer q_id = Integer.valueOf(question.getQ_id());
//            isFlagged.put(question.getQ_id(), !isFlagged.getOrDefault(question.getQ_id(), false));
//            if (isFlagged.containsKey(q_id) && isFlagged.get(q_id)== true) {
//                flaggedCount++;
//            }
//        }
//        return flaggedCount;
//    }

    // Update a section
    public Section updateSection(int section_id, Section updatedSection) {
        updatedSection.setSection_id(section_id);
        return sectionRepository.save(updatedSection);
    }

    // Delete a section by ID
    public void deleteSection(int section_id) {
        sectionRepository.deleteById(section_id);
    }


    private List<Question> getRandomQuestions(List<Question> questions, int numberOfQuestions) {
    	 List<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();

        while (randomQuestions.size() < numberOfQuestions) {
            int randomIndex = random.nextInt(questions.size());
            Question randomQuestion = questions.get(randomIndex);

            // Check if the question is not already in the list
            if (!randomQuestions.contains(randomQuestion)) {
                randomQuestions.add(randomQuestion);
            }
        }

        return randomQuestions;
    }




//    public TestPaper createTestPaperWithSections(List<Section> sections) {
//
//        TestPaper testPaper = new TestPaper();
//
//        for (Section section : sections) {
//            section.setTestPapersection(testPaper);
//        }
//         testPaperRepository.save(testPaper);
//
//        return testPaper;
//    }

}
