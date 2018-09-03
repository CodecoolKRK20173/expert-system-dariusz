package com.codecool.value;

import java.util.ArrayList;
import java.util.List;

abstract public class Value {
    List<String> inputPattern;
    boolean selectionType;

    public Value() {
        this.inputPattern = new ArrayList<String>();
    }

    abstract public List<String> getInputPattern();

    abstract public boolean getSelectionType();

}