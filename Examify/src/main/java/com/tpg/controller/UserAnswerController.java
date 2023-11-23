package com.tpg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.TestHistory;
import com.tpg.entity.UserAnswer;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.SectionRepository;
import com.tpg.repository.TestHistoryRepository;
import com.tpg.repository.UserAnswerRepository;
import com.tpg.request.UserAnswerAndMarksCreateRequest;
import com.tpg.service.UserAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/useranswer")
public class UserAnswerController {
	
    @Autowired
    private final UserAnswerService userAnswerService;
    
    @Autowired
    private QuestionsRepository questionsRepository;
	
	@Autowired
    private SectionRepository sectionRepository;
	
	@Autowired
	private UserAnswerRepository userAnswerRepository;
	
	@Autowired
	private TestHistoryRepository testHistoryRepository;

    

    public UserAnswerController(UserAnswerService userAnswerService, QuestionsRepository questionsRepository,
			SectionRepository sectionRepository, UserAnswerRepository userAnswerRepository) {
		super();
		this.userAnswerService = userAnswerService;
		this.questionsRepository = questionsRepository;
		this.sectionRepository = sectionRepository;
		this.userAnswerRepository = userAnswerRepository;
	}
    
    
    
    

    @PostMapping("/gettotal")
    public ResponseEntity<String> saveUserAnswerAndCalculateMarks(@RequestBody UserAnswerAndMarksCreateRequest request) {
        int total = userAnswerService.calculateMarksForWholeTestPaper(request.getUserAnswers());

        String response = "{\"totalMarks\":" + total + "}";
        System.out.println(response);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

   
}














//	@PostMapping("/report")
//    public int report(@RequestBody UserAnswerAndMarksCreateRequest request) {
//    	int marks =  userAnswerService.calculateTotalMarks(request.getUserAnswers());
//    	//userAnswerRepository.save(user);
//		return marks;
//    }
    
    
    
    
	
//	@GetMapping("/completereport")
//    public ResponseEntity<Map<Long, List<UserAnswer>>> getAllSections() {
//        Map<Long, List<UserAnswer>> sections = userAnswerService.organizeUserAnswersBySections();
//        return ResponseEntity.ok(sections);
//    }
