package com.codecool.value;

import java.util.List;

public class SingleValue extends Value {
    private String param;

    public SingleValue(String param, boolean selectionType) {
        super();
        this.param = param;
        this.selectionType = selectionType;
    }

    @Override
    public List<String> getInputPattern() {
        this.inputPattern.add(this.param);
        return this.inputPattern;
    }

    @Override
    public boolean getSelectionType() {
        return this.selectionType;
    }

}