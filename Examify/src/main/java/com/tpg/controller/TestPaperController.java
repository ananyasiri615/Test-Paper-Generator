package com.tpg.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.Section;
import com.tpg.entity.TestPaper;
import com.tpg.repository.TestPaperRepository;
import com.tpg.request.TestpaperRequest;
import com.tpg.service.SectionService;
import com.tpg.service.TestPaperService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/testpapers")
public class TestPaperController {
	
    @Autowired
    private TestPaperService testpaperservice;
    
    @Autowired
    private TestPaperRepository testpaperrepo;
    
    
	public TestPaperController(TestPaperService testpaperservice, TestPaperRepository testpaperrepo) {
		super();
		this.testpaperservice = testpaperservice;
		this.testpaperrepo = testpaperrepo;
	}

	@GetMapping("/all")
    public ResponseEntity<List<TestPaper>> getAllTestPapers() {
        List<TestPaper> testPapers = testpaperservice.getAllTestPapers();
        return new ResponseEntity<>(testPapers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TestPaper> createTestPaper(@RequestBody TestpaperRequest testpaperrequest) {
        TestPaper createdTestPaper = testpaperservice.createTestPaperWithSections(testpaperrequest.getSections());
        return new ResponseEntity<>(createdTestPaper, HttpStatus.CREATED);
    }
    
    @PostMapping("/createwithdate")
    public ResponseEntity<TestPaper> createTestPaperWithDate(
    	    @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
    	    @RequestBody TestpaperRequest testPaperRequest
    	) {
    	    TestPaper createdTestPaper = testpaperservice.createTestPaperWithSections(testPaperRequest.getSections());
    	    createdTestPaper.setDate(date);
    	    createdTestPaper.setTest_marks(testPaperRequest.getSections().size()*20);
    	    testpaperrepo.save(createdTestPaper);

    	    return new ResponseEntity<>(createdTestPaper, HttpStatus.OK);
    	}
 
}


































//@PostMapping("/createwithdate")
//public ResponseEntity<TestPaper> createTestPaperWithDate(
//      @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
//      @RequestBody TestpaperRequest testPaperRequest
//) {
// 
//      // Create a TestPaper with sections using the service
//      TestPaper createdTestPaper = testpaperservice.createTestPaperWithSections(testPaperRequest.getSections());
//
//      // Set the date and test_marks for the created TestPaper
//      createdTestPaper.setDate(date);
//      createdTestPaper.setTest_marks(testPaperRequest.getSections().size() * 2);
//
//      // Save the created TestPaper in the database (assuming your service does this)
//      testpaperrepo.save(createdTestPaper);
//
//      // Return a response with the created TestPaper and HTTP status 201 (Created)
//      return new ResponseEntity<>(createdTestPaper, HttpStatus.OK);
//  
//     
//
//  
//}

//public ResponseEntity<TestPaper> createTestPaperwithDate(@RequestParam("date") Date date,@RequestBody TestpaperRequest testpaperrequest) {
//TestPaper createdTestPaper = testpaperervice.createTestPaperWithSections(testpaperrequest.getSections());
//createdTestPaper.setDate(date);
//return new ResponseEntity<>(createdTestPaper, HttpStatus.CREATED);
//}