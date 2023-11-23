package com.tpg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tpg.entity.Candidate;
import com.tpg.entity.UserAnswer;
import com.tpg.repository.CandidateRepository;

@Service
public class CandidateService {
	
    private final CandidateRepository candidateRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId).orElse(null);
    }

    public Candidate createCandidate(Candidate candidate) {
        // Check if the username, email, and phoneNo are unique
        if (isUsernameUnique(candidate.getUsername()) && isEmailUnique(candidate.getEmail())
                && isPhoneNoUnique(candidate.getPhoneNo())) {

            String encodedPassword = passwordEncoder.encode(candidate.getPassword());
            candidate.setPassword(encodedPassword);
            return candidateRepository.save(candidate);
        } else {
            // Handle uniqueness violation, for example, by throwing an exception
            throw new RuntimeException("Username, email, or phone number is not unique");
        }
    }

    private boolean isUsernameUnique(String username) {
        return candidateRepository.findByUsername(username) == null;
    }

    private boolean isEmailUnique(String email) {
        return candidateRepository.findByEmail(email) == null;
    }

    private boolean isPhoneNoUnique(Long phoneNo) {
        return candidateRepository.findByPhoneNo(phoneNo) == null;
    }
    public Candidate updateCandidate(Long candidateId, Candidate candidate) {
        if (candidateRepository.existsById(candidateId)) {
            candidate.setCandidateId(candidateId);
            return candidateRepository.save(candidate);
        } else {
            return null;
        }
    }

    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
    
    
    

    public int calculateTotalMarksbyCandidate(Candidate candidate) {
        List<UserAnswer> userAnswers = candidate.getAnswers();
        int totalMarks = 0;

        for (UserAnswer userAnswer : userAnswers) {
            totalMarks += userAnswer.getMarks();
        }

        return totalMarks;
    }
}