package com.tpg.request;

import java.util.List;

import com.tpg.entity.TestHistory;

public class TestHistoryRequest {
	private List<TestHistory> testpapers;
	
	public List<TestHistory> getTestpapers() {
		return testpapers;
	}


	public void setTestpapers(List<TestHistory> testpapers) {
		this.testpapers = testpapers;
	}


	public TestHistoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TestHistoryRequest(List<TestHistory> testpapers) {
		super();
		this.testpapers = testpapers;
	}


	@Override
	public String toString() {
		return "TestHistoryRequest [testpapers=" + testpapers + "]";
	}
	
	
	
	
	
	
	

}
