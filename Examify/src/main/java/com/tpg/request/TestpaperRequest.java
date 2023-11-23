package com.tpg.request;

import java.util.List;

import com.tpg.entity.Section;

public class TestpaperRequest {
	private List<Section> sections;

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public TestpaperRequest(List<Section> sections) {
		super();
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "TestpaperRequest [sections=" + sections + "]";
	}

	public TestpaperRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
