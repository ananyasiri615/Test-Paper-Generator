package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpg.entity.Section;
import com.tpg.entity.TestPaper;
import com.tpg.repository.TestPaperRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestPaperService {
    
    @Autowired
    private TestPaperRepository testPaperRepository;
    
    
    public List<TestPaper> getAllTestPapers() {
        List<TestPaper> testPapers = testPaperRepository.findAll();
        return testPapers;
    }


    @Transactional
    public TestPaper createTestPaperWithSections(List<Section> sections) {
        
       TestPaper testPaper = new TestPaper();
        
       List<Section> list = new ArrayList<>();
       for(Section section: sections) {
    	   list.add(section);
       }
       
       testPaper.setSections(list);
       
     
        return testPaper;
    }

}


















//	public TestPaper saveTestPaper(TestPaper createdTestPaper) {
//		return testPaperRepository.save(createdTestPaper);
//	}
    
//    @Transactional
//    public TestPaper createTestPaper(List<Section> sections) {
//        // Fetch associated entities and attach them to the session if needed
//
//        // Create a new TestPaper
//        TestPaper testPaper = new TestPaper();
//        //testPaper.setSections(sections);
//
//        for (Section section : sections) {
//            section.setTestPapersection(testPaper);
//        }
//
//        // Save the TestPaper (and associated entities) within a transaction
//        return testPaperRepository.save(testPaper);
//    }





//for (Section section : sections) {
//section.setTestPapersection(testPaper);
//}
