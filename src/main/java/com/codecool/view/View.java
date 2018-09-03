package com.codecool.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codecool.data.Question;
import com.codecool.value.Value;

public class View {
    Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput(Question question) {
        boolean inputCorrect = false;
        String input = "";

        while (!inputCorrect) {
            input = scanner.nextLine().toLowerCase().trim();
            if (getPossibleAnswers(question).contains(input)) {
                inputCorrect = true;
            } else {
                System.out.println("Unknown answer, try again...");
            }
        }

        return input;
    }

    public void printQuestion(Question question) {
        System.out.println(question.getQuestion());
        printPossibleAnswers(question);
    }

    public void printPossibleAnswers(Question question) {
        String possibleAnswers = "Possible answers: \n";
        List<String> possibleAnswersList = getPossibleAnswers(question);

        for (String s : possibleAnswersList) {
            possibleAnswers += s + " ";
        }

        System.out.println(possibleAnswers);
    }

    private List<String> getPossibleAnswers(Question question) {
        List<Value> possibleValues = question.getAnswer().getValues();
        List<String> possibleAnswers = new ArrayList<String>();

        for (Value value : possibleValues) {
            possibleAnswers.addAll(value.getInputPattern());
        }

        return possibleAnswers;
    }

}