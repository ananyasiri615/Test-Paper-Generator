package com.tpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Question;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {
	
    List<Question> findBySubjectSubjectId(int subjectId);
    
    @Query("SELECT q FROM Question q WHERE q.actual_qns = :actualQns")
    Question findByActualQns(@Param("actualQns") String actualQns);
}
