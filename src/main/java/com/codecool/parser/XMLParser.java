package com.codecool.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public abstract class XMLParser {
    // private File xmlFile;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;

    public void loadXMLDocument(String xmlPath) {
        try {
            // ClassLoader classLoader = getClass().getClassLoader();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File xmlFile = new File(classloader.getResource(xmlPath).getFile());
            documentBuilderFactory = documentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return this.document;
    }

}