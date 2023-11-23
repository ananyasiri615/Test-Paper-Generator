package com.tpg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpg.entity.CandidateHistory;
import com.tpg.repository.CandidateHistoryRepository;

@Service
public class CandidateHistoryService {

    @Autowired
    private CandidateHistoryRepository candidateHistoryRepository;

    // Create (Add) a CandidateHistory record
    public CandidateHistory createCandidateHistory(CandidateHistory candidateHistory) {
        return candidateHistoryRepository.save(candidateHistory);
    }

    // Read (Retrieve) all CandidateHistory records
    public List<CandidateHistory> getAllCandidateHistories() {
        return candidateHistoryRepository.findAll();
    }

    // Read (Retrieve) a single CandidateHistory record by ID
    public Optional<CandidateHistory> getCandidateHistoryById(Long id) {
        return candidateHistoryRepository.findById(id);
    }

    // Update (Modify) a CandidateHistory record
    public CandidateHistory updateCandidateHistory(CandidateHistory candidateHistory) {
        return candidateHistoryRepository.save(candidateHistory);
    }

    // Delete a CandidateHistory record by ID
    public void deleteCandidateHistory(Long id) {
        candidateHistoryRepository.deleteById(id);
    }
}
