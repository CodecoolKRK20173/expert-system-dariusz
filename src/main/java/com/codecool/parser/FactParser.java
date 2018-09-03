package com.codecool.parser;

import com.codecool.data.Fact;
import com.codecool.repository.FactRepository;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {
    private String xmlPath;
    private FactRepository factRepository;

    public FactParser() {
        this.xmlPath = "Facts.xml";
        this.factRepository = new FactRepository();
        loadXMLDocument(this.xmlPath);
        fillFactRepository();
    }

    private void fillFactRepository() {
        NodeList nodeList = getDocument().getElementsByTagName("Fact");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node factNode = nodeList.item(i);
            Element factElement = (Element) factNode;

            String id = factElement.getAttribute("id");

            Element descriptionElement = (Element) factElement.getElementsByTagName("Description").item(0);
            String description = descriptionElement.getAttribute("value");

            Fact factToBeAdded = new Fact(id, description);

            Element evals = (Element) factElement.getElementsByTagName("Evals").item(0);
            NodeList evalsList = evals.getElementsByTagName("Eval");

            for (int j = 0; j < evalsList.getLength(); j++) {
                Element eval = (Element) evalsList.item(j);
                factToBeAdded.setFactValueById(eval.getAttribute("id"), Boolean.valueOf(eval.getTextContent()));
            }
            factRepository.addFact(factToBeAdded);
        }
    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }
}