package com.tpg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userAnswer")
public class UserAnswer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ans_id;

    @ManyToOne
    @JoinColumn(name = "q_id")
    private Question question;

    private String chosenAnswer;

    private Boolean Attempted;
    
    private Boolean flagged;
    
    private int marks;
    
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidateanswers;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

	public int getAns_id() {
		return ans_id;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(String chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public Boolean getAttempted() {
		return Attempted;
	}

	public void setAttempted(Boolean attempted) {
		Attempted = attempted;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	

	public Candidate getCandidateanswers() {
		return candidateanswers;
	}

	public void setCandidateanswers(Candidate candidateanswers) {
		this.candidateanswers = candidateanswers;
	}

	public UserAnswer() {
		
	}

	public UserAnswer(int ans_id, Question question, String chosenAnswer, Boolean attempted, Boolean flagged, int marks,
			Candidate candidateanswers, Section section) {
		super();
		this.ans_id = ans_id;
		this.question = question;
		this.chosenAnswer = chosenAnswer;
		Attempted = attempted;
		this.flagged = flagged;
		this.marks = marks;
		this.candidateanswers = candidateanswers;
		this.section = section;
	}

	@Override
	public String toString() {
		return "UserAnswer [ans_id=" + ans_id + ", question=" + question + ", chosenAnswer=" + chosenAnswer
				+ ", Attempted=" + Attempted + ", flagged=" + flagged + ", marks=" + marks + ", candidateanswers="
				+ candidateanswers + ", section=" + section + "]";
	}

	

}