package com.codecool.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.codecool.data.Question;

public class RuleRepository {
    private List<Question> questions;
    private QuestionIterator questionIterator;

    public RuleRepository() {
        this.questions = new ArrayList<Question>();
        this.questionIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public Iterator<Question> getIerator() {
        return this.questionIterator;
    }

    private class QuestionIterator implements Iterator<Question> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < questions.size();
        }

        public Question next() {
            return questions.get(currentIndex++);
        }
    }
}