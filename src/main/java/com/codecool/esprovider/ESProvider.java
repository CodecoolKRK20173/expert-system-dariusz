package com.codecool.esprovider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codecool.data.Fact;
import com.codecool.data.Question;
import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;
import com.codecool.repository.FactRepository;
import com.codecool.repository.RuleRepository;
import com.codecool.view.View;

public class ESProvider {
    FactRepository factRepository;
    RuleRepository ruleRepository;
    Map<String, Boolean> answers;
    Iterator<Fact> factIterator;
    Iterator<Question> questionIterator;
    View view;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factIterator = this.factRepository.getIterator();
        this.questionIterator = this.ruleRepository.getIerator();
        this.view = new View();
    }

    public void collectAnswers() {
        this.answers = new HashMap<String, Boolean>();

        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            view.printQuestion(question);
            String answer = view.getUserInput(question);
            boolean evaluatedValue = question.getEvaluatedAnswer(answer);
            answers.put(question.getId(), evaluatedValue);
        }

    }

    public boolean getAnswerByQuestion(String questionId) {
        return false;
    }

    public String evaluate() {
        String carForYou = "Car for you: ";
        boolean carFound = false;

        while (factIterator.hasNext()) {
            Fact fact = factIterator.next();

            if (checkIfAnswersMatchToFact(this.answers, fact)) {
                carForYou += fact.getDescription() + " ";
                carFound = true;
            }
        }

        if (!carFound) {
            carForYou += "try a bicycle! :)";
        }

        System.out.println(carForYou);

        return carForYou;
    }

    private boolean checkIfAnswersMatchToFact(Map<String, Boolean> answers, Fact fact) {
        boolean answerMatch = false;
        int counter = 0;

        for (String id : answers.keySet()) {
            if (answers.get(id) == fact.getValueById(id))
                counter++;
        }

        if (counter == 3)
            answerMatch = true;

        return answerMatch;
    }
}