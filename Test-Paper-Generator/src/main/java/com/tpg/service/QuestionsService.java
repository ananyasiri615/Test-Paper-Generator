package com.tpg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tpg.entity.Questions;
import com.tpg.entity.Subject;
import com.tpg.repository.QuestionsRepository;

@Service
public class QuestionsService {
	
	@Autowired
    private QuestionsRepository questionsRepository;
	
	@Autowired
    private SubjectService subjectService; 

    public Iterable<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }
    
    public Questions findById(int q_id) {
        return questionsRepository.findById(q_id).orElse(null);
    }
    
    public Questions createQuestions(@RequestBody Questions questions) {
    	int subject_id = questions.getSubject().getSubject_id(); 
        Subject subject = subjectService.findById(subject_id); 
        questions.setSubject(subject);
        return questionsRepository.save(questions);
    }
    
    public Questions updateQuestions(@PathVariable int q_id, @RequestBody Questions questions) {
        questions.setQ_id(q_id);
        int subject_id = questions.getSubject().getSubject_id(); 
        Subject subject = subjectService.findById(subject_id); 
        questions.setSubject(subject);
        return questionsRepository.save(questions);
    }
    
    public void deleteQuestions(@PathVariable int q_id) {
		Optional<Questions> questions = questionsRepository.findById(q_id);
        if (questions.isPresent()) { 
        	questionsRepository.deleteById(q_id);
        }
    }

    public List<Questions> findAll() {
        return questionsRepository.findAll();
    }
    
//    public List<Questions> getRandomQuestionsByDifficulty(int numQuestions, String difficulty) {
//        List<Questions> questions = questionsRepository.findByDifficulty(difficulty);
//        return getRandomQuestions(questions, numQuestions);
//    }
//
//    public List<Questions> getRandomQuestions(int numQuestions) {
//        List<Questions> allQuestions = questionsRepository.findAll();
//        return getRandomQuestions(allQuestions, numQuestions);
//    }

//    private List<Questions> getRandomQuestions(List<Questions> questions, int numQuestions) {
//        // Shuffle the list to randomize the order
//        Random random = new Random();
//        for (int i = questions.size() - 1; i > 0; i--) {
//            int index = random.nextInt(i + 1);
//            Questions temp = questions.get(index);
//            questions.set(index, questions.get(i));
//            questions.set(i, temp);
//        }
//
//        // Return the specified number of random questions
//        return questions.subList(0, Math.min(numQuestions, questions.size()));
//    }






}
