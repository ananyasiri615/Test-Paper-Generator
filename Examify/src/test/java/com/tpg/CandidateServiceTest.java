package com.tpg;

import com.tpg.entity.Candidate;
import com.tpg.repository.CandidateRepository;
import com.tpg.service.CandidateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateService candidateService;

    @Test
    public void testGetAllCandidates() {
        // Create a list of candidates for testing
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate());
        candidates.add(new Candidate());

        // Mock the repository's findAll method
        when(candidateRepository.findAll()).thenReturn(candidates);

        // Call the service method
        List<Candidate> retrievedCandidates = candidateService.getAllCandidates();

        // Check if the retrieved candidates match the expected candidates
        assertNotNull(retrievedCandidates);
        assertEquals(candidates.size(), retrievedCandidates.size());
        assertEquals(candidates.get(0).getName(), retrievedCandidates.get(0).getName());
        assertEquals(candidates.get(1).getName(), retrievedCandidates.get(1).getName());
    }

    @Test
    public void testGetCandidateById() {
        // Create a sample candidate
        Candidate candidate = new Candidate();

        // Mock the repository's findById method
        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));

        // Call the service method
        Candidate retrievedCandidate = candidateService.getCandidateById(1L);

        // Check if the retrieved candidate matches the expected candidate
        assertNotNull(retrievedCandidate);
        assertEquals(candidate.getName(), retrievedCandidate.getName());
    }

    // You can write similar test methods for createCandidate, updateCandidate, and deleteCandidate.
}
