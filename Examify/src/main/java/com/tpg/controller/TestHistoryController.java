package com.tpg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.TestHistory;
import com.tpg.request.TestHistoryRequest;
import com.tpg.service.TestHistoryService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/testHistory")
public class TestHistoryController {

    @Autowired
    private TestHistoryService testHistoryService;

    @PostMapping("/createTestHistoryList")
    public List<TestHistory> createTestHistoryList(@RequestBody TestHistoryRequest testHistoryRequest) {
        return testHistoryService.createTestHistoryList(testHistoryRequest.getTestpapers());
    }
    
    @GetMapping("/byUsername/{username}")
    public List<TestHistory> getTestHistoryByUsername(@PathVariable String username) {
        return testHistoryService.getTestHistoryByUsername(username);
    }
    
    @GetMapping("/all")
    public List<TestHistory> getAllTestHistory() {
        return testHistoryService.getAllTestHistory();
    }
    
}
