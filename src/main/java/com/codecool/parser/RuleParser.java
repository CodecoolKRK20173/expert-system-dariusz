package com.codecool.parser;

import java.util.ArrayList;

import com.codecool.data.Answer;
import com.codecool.data.Question;
import com.codecool.repository.RuleRepository;
import com.codecool.value.MultipleValue;
import com.codecool.value.SingleValue;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {
    private String xmlPath;
    private RuleRepository ruleRepository;

    public RuleParser() {
        this.xmlPath = "Rules.xml";
        this.ruleRepository = new RuleRepository();
        loadXMLDocument(this.xmlPath);
        fillRuleRepository();
    }

    private void fillRuleRepository() {
        NodeList ruleList = getDocument().getElementsByTagName("Rule");

        for (int i = 0; i < ruleList.getLength(); i++) {
            Element rule = (Element) ruleList.item(i);

            String id = rule.getAttribute("id");

            Element question = (Element) rule.getElementsByTagName("Question").item(0);
            String questionString = question.getTextContent();

            NodeList selectionsList = rule.getElementsByTagName("Selection");

            Answer answer = new Answer();

            for (int k = 0; k < selectionsList.getLength(); k++) {
                Element selection = (Element) selectionsList.item(k);
                boolean selectionValue = Boolean.valueOf(selection.getAttribute("value"));
                // NodeList valueList = selection.getChildNodes();

                // for (int j = 0; j < valueList.getLength(); j++) {
                Element valueElement = (Element) selection.getChildNodes().item(1);

                if (valueElement.getTagName().equals("SingleValue")) {
                    answer.addValue(new SingleValue(valueElement.getAttribute("value"), selectionValue));
                } else {
                    ArrayList<String> params = new ArrayList<String>();
                    String[] paramsArray = valueElement.getAttribute("value").split(",");

                    for (String s : paramsArray)
                        params.add(s);

                    answer.addValue(new MultipleValue(params, selectionValue));
                }
                // }
            }
            ruleRepository.addQuestion(new Question(id, questionString, answer));
        }
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

}