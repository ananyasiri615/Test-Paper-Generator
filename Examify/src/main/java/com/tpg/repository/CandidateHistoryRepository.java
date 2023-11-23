package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.CandidateHistory;


@Repository
public interface CandidateHistoryRepository extends JpaRepository<CandidateHistory, Long> {

}
