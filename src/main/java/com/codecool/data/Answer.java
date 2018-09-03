package com.codecool.data;

import java.util.ArrayList;
import java.util.List;

import com.codecool.value.Value;

public class Answer {
    private List<Value> values;

    public Answer() {
        this.values = new ArrayList<Value>();
    }

    public void addValue(Value value) {
        this.values.add(value);
    }

    public boolean evaluateAnswerByInput(String input) {
        boolean evaluatedAnswer = false;

        for (Value value : values) {
            for (String s : value.getInputPattern()) {
                if (s.equals(input)) {
                    evaluatedAnswer = value.getSelectionType();
                }
            }
        }

        return evaluatedAnswer;
    }

    public List<Value> getValues() {
        return this.values;
    }
}