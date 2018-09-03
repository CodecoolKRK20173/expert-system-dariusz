package com.codecool;

import com.codecool.esprovider.ESProvider;
import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome! Answer questions to get advice.");
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());
        esProvider.collectAnswers();
        esProvider.evaluate();
    }
}
