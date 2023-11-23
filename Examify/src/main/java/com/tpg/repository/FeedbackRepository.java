package com.tpg.repository;

import org.springframework.data.repository.CrudRepository;

import com.tpg.entity.Feedback;



public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	
}