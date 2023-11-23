package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpg.entity.Candidate;
import com.tpg.repository.CandidateRepository;
import com.tpg.service.CandidateService;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/candidates")
public class CandidateController {
	
	@Autowired
    private CandidateService candidateService;
	
	@Autowired
    private CandidateRepository candidaterepo;
	
	

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/all")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{candidateId}")
    public Candidate getCandidateById(@PathVariable Long candidateId) {
        return candidateService.getCandidateById(candidateId);
    }

    @PostMapping("/create")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.createCandidate(candidate);
    }

    @PutMapping("/{candidateId}")
    public Candidate updateCandidate(@PathVariable Long candidateId, @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(candidateId, candidate);
    }

    @DeleteMapping("/{candidateId}")
    public void deleteCandidate(@PathVariable Long candidateId) {
        candidateService.deleteCandidate(candidateId);
    }
    
    @GetMapping("/{candidateId}/total-marks")
    public int getTotalMarks(@PathVariable Long candidateId) {
        Candidate candidate = candidaterepo.findById(candidateId).orElse(null);
        
        if (candidate != null) {
            int totalMarks = candidateService.calculateTotalMarksbyCandidate(candidate);
            return totalMarks;
        } else {
            // Handle candidate not found
            return -1;
        }
    }
}