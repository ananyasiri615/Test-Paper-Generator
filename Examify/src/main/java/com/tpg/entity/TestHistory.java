package com.tpg.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class TestHistory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "history_id")
    private int history_id;

    @ManyToOne
    @JoinColumn(name = "q_id")
    private Question question;

    private String chosenAnswer;
    
    private int totalmarks;
    private String username;
    
    private String question_name;
    private String correct_option;
    
    private int level;
    
   

	public String getQuestion_name() {
		return question_name;
	}


	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}


	public String getCorrect_option() {
		return correct_option;
	}


	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getHistory_id() {
		return history_id;
	}


	public void setHistory_id(int history_id) {
		this.history_id = history_id;
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


	public int getTotalmarks() {
		return totalmarks;
	}


	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public TestHistory() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "TestHistory [history_id=" + history_id + ", question=" + question + ", chosenAnswer=" + chosenAnswer
				+ ", totalmarks=" + totalmarks + ", username=" + username + ", question_name=" + question_name
				+ ", correct_option=" + correct_option + ", level=" + level + "]";
	}


	public TestHistory(int history_id, Question question, String chosenAnswer, int totalmarks, String username,
			String question_name, String correct_option, int level) {
		super();
		this.history_id = history_id;
		this.question = question;
		this.chosenAnswer = chosenAnswer;
		this.totalmarks = totalmarks;
		this.username = username;
		this.question_name = question_name;
		this.correct_option = correct_option;
		this.level = level;
	}


	
	
    
    
    
		

}