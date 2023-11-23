package com.tpg.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CandidateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private int totalscore;

    private String startTime;
    private String endTime;
    private String grade;
    private Date date;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getTotalscore() {
        return totalscore;
    }
    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "CandidateHistory [id=" + id + ", username=" + username + ", totalscore=" + totalscore + ", startTime="
                + startTime + ", endTime=" + endTime + ", grade=" + grade + ", date=" + date + "]";
    }
    public CandidateHistory(int id, String username, int totalscore, String startTime, String endTime, String grade,
                            Date date) {
        super();
        this.id = id;
        this.username = username;
        this.totalscore = totalscore;
        this.startTime = startTime;
        this.endTime = endTime;
        this.grade = grade;
        this.date = date;
    }
    public CandidateHistory() {
        super();
        // TODO Auto-generated constructor stub
    }



}