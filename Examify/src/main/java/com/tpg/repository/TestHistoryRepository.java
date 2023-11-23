package com.tpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tpg.entity.TestHistory;

@Repository
public interface TestHistoryRepository extends JpaRepository<TestHistory, Long> {
	 List<TestHistory> findByUsername(String username);
}
