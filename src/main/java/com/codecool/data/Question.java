package com.codecool.data;

public class Question {
    private String id;
    private String question;
    private Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return this.answer.evaluateAnswerByInput(input);
    }
}