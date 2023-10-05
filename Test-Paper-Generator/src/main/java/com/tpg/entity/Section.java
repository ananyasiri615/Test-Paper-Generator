package com.tpg.entity;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int section_id;
    private String subject_name;
    private Time timer;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestPaper testPaper;

    @ManyToOne
    @JoinColumn(name = "q_id")
    private Questions questions;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Section() {
    }

	public Section(int section_id, String subject_name, Time timer, TestPaper testPaper, Questions questions,
			Subject subject) {
		super();
		this.section_id = section_id;
		this.subject_name = subject_name;
		this.timer = timer;
		this.testPaper = testPaper;
		this.questions = questions;
		this.subject = subject;
	}

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Time getTimer() {
		return timer;
	}

	public void setTimer(Time timer) {
		this.timer = timer;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Section [section_id=" + section_id + ", subject_name=" + subject_name + ", timer=" + timer
				+ ", testPaper=" + testPaper + ", questions=" + questions + ", subject=" + subject + "]";
	}
    
	
    
    
}
