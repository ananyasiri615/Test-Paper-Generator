package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpg.entity.CandidateHistory;
import com.tpg.service.CandidateHistoryService;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/candidatehistory")
public class CandidateHistoryController {

    @Autowired
    private CandidateHistoryService candidateHistoryService;

    @PostMapping("/add")
    public CandidateHistory createCandidateHistory(@RequestBody CandidateHistory candidateHistory) {
        return candidateHistoryService.createCandidateHistory(candidateHistory);
    }

    @GetMapping("/all")
    public List<CandidateHistory> getAllCandidateHistories() {
        return candidateHistoryService.getAllCandidateHistories();
    }

    @GetMapping("/{id}")
    public Optional<CandidateHistory> getCandidateHistoryById(@PathVariable Long id) {
        return candidateHistoryService.getCandidateHistoryById(id);
    }

    @PutMapping("/update")
    public CandidateHistory updateCandidateHistory(@RequestBody CandidateHistory candidateHistory) {
        return candidateHistoryService.updateCandidateHistory(candidateHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidateHistory(@PathVariable Long id) {
        candidateHistoryService.deleteCandidateHistory(id);
    }
}
