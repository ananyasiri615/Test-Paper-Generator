package com.tpg.request;

import java.util.Map;

public class SubmitAnswersRequest {
    private Map<Integer, String> answers;
    private Map<Integer, Boolean> isFlagged;

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public Map<Integer, Boolean> getIsFlagged() {
        return isFlagged;
    }

    public void setIsFlagged(Map<Integer, Boolean> isFlagged) {
        this.isFlagged = isFlagged;
    }
}

