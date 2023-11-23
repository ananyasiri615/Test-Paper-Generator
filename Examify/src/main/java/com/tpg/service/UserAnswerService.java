package com.tpg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpg.entity.Candidate;
import com.tpg.entity.Question;
import com.tpg.entity.Section;
import com.tpg.entity.UserAnswer;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.SectionRepository;
import com.tpg.repository.UserAnswerRepository;
import com.tpg.request.UserAnswerAndMarksCreateRequest;

@Service
public class UserAnswerService {
	
	@Autowired
    private QuestionsRepository questionsRepository;
	
	@Autowired
    private SectionRepository sectionRepository;
	
	@Autowired
    private final UserAnswerRepository userAnswerRepository;

    public UserAnswerService(UserAnswerRepository UserAnswerRepository) {
        this.userAnswerRepository = UserAnswerRepository;
    }

    // Save the user's answer and marks in the database
   
    public List<UserAnswer> saveUserAnswerAndMarks(List<UserAnswer> userAnswers) {
        List<UserAnswer> userAnswersList = new ArrayList<>();
        UserAnswer processedUserAnswer = new UserAnswer();

        for (UserAnswer userAnswer : userAnswers) {
            // Retrieve the corresponding section and question for the user answer
            Section section = sectionRepository.findById(userAnswer.getSection().getSection_id()).orElseThrow();
            Question question = questionsRepository.findById(userAnswer.getQuestion().getQ_id()).orElseThrow();

            // Create a new UserAnswer object for each item in the list
            
            // Set the properties of the user answer
            processedUserAnswer.setSection(section);
            processedUserAnswer.setQuestion(question);
            

            // Calculate the marks for the user answer
            int marks = calculateMarks(userAnswer);

            // Set the calculated marks
            processedUserAnswer.setMarks(marks);
            processedUserAnswer.setAttempted(userAnswer.getAttempted());
            processedUserAnswer.setChosenAnswer(userAnswer.getChosenAnswer());;
            processedUserAnswer.setFlagged(userAnswer.getFlagged());
            processedUserAnswer.setQuestion(question);
            processedUserAnswer.setSection(section);

            // Add the processed user answer to the list
            userAnswersList.add(processedUserAnswer);
            userAnswerRepository.saveAll(userAnswersList);
            
        }

        // Optionally, you can save the updated user answers to a repository or database here.

        return userAnswersList;
    }

    
    public String getCorrectAnswer(int q_id) {
        Question question = questionsRepository.findById(q_id).get();
        return question.getCorrect_op();
    }

    public int calculateTotalMarks(List<UserAnswer> userAnswers) {
        int totalMarks = 0;
        
        for (UserAnswer userAnswer : userAnswers) {
            int marksForAnswer = calculateMarks(userAnswer);
            totalMarks += marksForAnswer;
        }
        
        return totalMarks;
    }
//    public Map<Long, List<UserAnswer>> organizeUserAnswersBySections() {
//        List<UserAnswer> userAnswers = userAnswerRepository.findAll();
//
//        Map<Long, List<UserAnswer>> sections = new HashMap<>();
//        for (UserAnswer userAnswer : userAnswers) {
//            Long sectionId = (long) userAnswer.getSection().getSection_id();
//            sections.computeIfAbsent(sectionId, k -> new ArrayList<>()).add(userAnswer);
//        }
//
//        return sections;
//    }
//    public int calculateTotalMarksForSection(int sectionId) {
//        List<UserAnswer> userAnswers = userAnswerRepository.findBySectionSectionId(sectionId);
//
//        int totalMarks = 0;
//
//        for (UserAnswer userAnswer : userAnswers) {
//            int marksForAnswer = calculateMarks(userAnswer);
//            totalMarks += marksForAnswer;
//        }
//
//        return totalMarks;
//    }


    private int calculateMarks(UserAnswer userAnswer) {
        if (userAnswer != null) {
            Question question = userAnswer.getQuestion();
            String userChoice = userAnswer.getChosenAnswer();
            String correctAnswer = getCorrectAnswer(question.getQ_id());

            System.out.println("User Choice: " + userChoice);
            System.out.println("Correct Answer: " + correctAnswer);

            if (userChoice != null && userChoice.equals(correctAnswer)) {
                return 1;
            }
        }

        return 0;
    }
    public int calculateMarksForWholeTestPaper(List<UserAnswer> userAnswers) {
        int total = 0;

        for (UserAnswer userAnswer : userAnswers) {
            if (userAnswer != null) {
                Question question = userAnswer.getQuestion();
                String userChoice = userAnswer.getChosenAnswer();

                if (userChoice != null) {
                    String correctAnswer = getCorrectAnswer(question.getQ_id());
                    boolean isFlagged = userAnswer.getFlagged();
                    userAnswer.setAttempted(true);
                    int level = question.getLevel();

                    System.out.println("User Choice: " + userChoice);
                    System.out.println("Correct Answer: " + correctAnswer);

                    if (userChoice.equals(correctAnswer)) {
                        if (level == 1) {
                            total += 1;
                        } else if (level == 2) {
                            total += 2;
                        } else {
                            total += 3;
                        }
                    }
                }
            }
        }

        return total;
    }
    
    public int calculateTotalTestPaperScore(List<UserAnswer> userAnswers) {
        int totalTestPaperScore = 0;

        for (UserAnswer userAnswer : userAnswers) {
            if (userAnswer != null) {
                Question question = userAnswer.getQuestion();
                int level = question.getLevel();

                // Increment totalTestPaperScore based on the level
                if (level == 1) {
                    totalTestPaperScore += 1;
                } else if (level == 2) {
                    totalTestPaperScore += 2;
                } else if (level == 3) {
                    totalTestPaperScore += 3;
                }
            }
        }

        return totalTestPaperScore;
    }



	

}
















//public List<UserAnswer> saveUserAnswerAndMarks(List<UserAnswer> userAnswersDto) {
//List<UserAnswer> userAnswersList = new ArrayList<>();
//
//for (UserAnswer userAnswerDto : userAnswersDto) {
//  Section section = sectionRepository.findById(userAnswerDto.getSection()).orElseThrow(() -> new NotFoundException("Section not found"));
//  Question question = questionsRepository.findById(userAnswerDto.getQuestion()).orElseThrow(() -> new NotFoundException("Question not found"));
//
//  UserAnswer userAnswer = new UserAnswer();
//  userAnswer.setSection(section);
//  userAnswer.setQuestion(question);
//  userAnswer.setChosenAnswer(userAnswerDto.getChosenAnswer());
//  userAnswer.setFlagged(userAnswerDto.getFlagged());
//  userAnswer.setAttempted(userAnswerDto.getAttempted());
//
//  int marks = calculateMarks(userAnswer); // Calculate marks
//
//  // Save the marks in the database
//  userAnswer.setMarks(marks);
//  userAnswersList.add(userAnswer);
//}
//
//return userAnswersList;
//}
//
//

