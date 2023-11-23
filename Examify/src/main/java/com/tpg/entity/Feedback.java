package com.tpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String examFeedback;
    private String platformFeedback;
    private int platformratings;
    private int examRatings;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getExamFeedback() {
        return examFeedback;
    }
    public void setExamFeedback(String examFeedback) {
        this.examFeedback = examFeedback;
    }
    public String getPlatformFeedback() {
        return platformFeedback;
    }
    public void setPlatformFeedback(String platformFeedback) {
        this.platformFeedback = platformFeedback;
    }
    public int getPlatformratings() {
        return platformratings;
    }
    public void setPlatformratings(int platformratings) {
        this.platformratings = platformratings;
    }
    public int getExamRatings() {
        return examRatings;
    }
    public void setExamRatings(int examRatings) {
        this.examRatings = examRatings;
    }
    @Override
    public String toString() {
        return "Feedback [id=" + id + ", username=" + username + ", examFeedback=" + examFeedback
                + ", platformFeedback=" + platformFeedback + ", platformratings=" + platformratings + ", examRatings="
                + examRatings + "]";
    }
    public Feedback(Long id, String username, String examFeedback, String platformFeedback, int platformratings,
                    int examRatings) {
        super();
        this.id = id;
        this.username = username;
        this.examFeedback = examFeedback;
        this.platformFeedback = platformFeedback;
        this.platformratings = platformratings;
        this.examRatings = examRatings;
    }
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }


}