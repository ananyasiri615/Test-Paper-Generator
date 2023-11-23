package com.tpg.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int section_id;
	private int numberOfQuestions;
	private int totalmarks;

//    private Time timer;
//    private Boolean attempted;
//    private Boolean notAttempted;
//    private Boolean flag;

	@OneToMany(mappedBy = "sectionquestions", cascade = CascadeType.ALL)
	private List<Question> questions;


	@ManyToOne(fetch=FetchType.LAZY)
	private TestPaper testPapersection;

	@OneToOne
	@JoinColumn(name = "subject_id")
	public Subject subject;

	public Section() {
	}

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}


	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public TestPaper getTestPapersection() {
		return testPapersection;
	}

	public void setTestPapersection(TestPaper testPapersection) {
		this.testPapersection = testPapersection;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Section(int section_id, int numberOfQuestions, int totalmarks, List<Question> questions,
				   TestPaper testPapersection, Subject subject) {
		super();
		this.section_id = section_id;
		this.numberOfQuestions = numberOfQuestions;
		this.totalmarks = totalmarks;
		this.questions = questions;
		this.testPapersection = testPapersection;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Section [section_id=" + section_id + ", numberOfQuestions=" + numberOfQuestions + ", totalmarks="
				+ totalmarks + ", questions=" + questions + ", testPapersection=" + testPapersection + ", subject="
				+ subject + "]";
	}







}