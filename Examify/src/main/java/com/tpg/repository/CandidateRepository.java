package com.tpg.repository;

import com.tpg.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Find by username
    Candidate findByUsername(String username);

    // Find by email
    Candidate findByEmail(String email);

    // Find by phone number
    Candidate findByPhoneNo(Long phoneNo);
}
