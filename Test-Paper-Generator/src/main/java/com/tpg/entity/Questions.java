package com.tpg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int q_id;
    private String actual_qns;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_op;
    private int level;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    public Questions() {
    }

	public Questions(int q_id, String actual_qns, String option1, String option2, String option3, String option4,
			String correct_op, int level, Admin admin, Subject subject) {
		super();
		this.q_id = q_id;
		this.actual_qns = actual_qns;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct_op = correct_op;
		this.level = level;
		this.admin = admin;
		this.subject = subject;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getActual_qns() {
		return actual_qns;
	}

	public void setActual_qns(String actual_qns) {
		this.actual_qns = actual_qns;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrect_op() {
		return correct_op;
	}

	public void setCorrect_op(String correct_op) {
		this.correct_op = correct_op;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Questions [q_id=" + q_id + ", actual_qns=" + actual_qns + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", correct_op=" + correct_op + ", level="
				+ level + ", admin=" + admin + ", subject=" + subject + "]";
	}
    
    
}
