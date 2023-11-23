package com.tpg.request;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.tpg.entity.UserAnswer;

public class UserAnswerAndMarksCreateRequest {
	
	private List<UserAnswer> userAnswers;
	

	public List<UserAnswer> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public UserAnswerAndMarksCreateRequest(List<UserAnswer> userAnswers) {
		super();
		this.userAnswers = userAnswers;
	}

	@Override
	public String toString() {
		return "UserAnswerAndMarksCreateRequest [userAnswers=" + userAnswers + "]";
	}

	public UserAnswerAndMarksCreateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	   
}