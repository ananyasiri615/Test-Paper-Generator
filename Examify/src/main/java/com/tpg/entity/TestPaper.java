package com.tpg.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "testpaper")
public class TestPaper {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int testPaperId;

    private Integer test_marks;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date date;
    

    
    @OneToMany(mappedBy = "testPapersection")
    private List<Section> sections;
    
    
    
    public TestPaper() {
    }


	public Integer getTest_marks() {
		return test_marks;
	}

	public void setTest_marks(Integer test_marks) {
		this.test_marks = test_marks;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public int getTestPaperId() {
		return testPaperId;
	}


	public void setTestPaperId(int testPaperId) {
		this.testPaperId = testPaperId;
	}


	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public TestPaper(int testPaperId, Integer test_marks, Date date, List<Section> sections) {
		super();
		this.testPaperId = testPaperId;
		this.test_marks = test_marks;
		this.date = date;
		this.sections = sections;
	}


	@Override
	public String toString() {
		return "TestPaper [testPaperId=" + testPaperId + ", test_marks=" + test_marks + ", date=" + date + ", sections="
				+ sections + "]";
	}


	

	
    
}
