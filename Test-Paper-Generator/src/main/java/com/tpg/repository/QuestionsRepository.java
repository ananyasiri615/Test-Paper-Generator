package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

}
