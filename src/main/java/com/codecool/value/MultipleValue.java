package com.codecool.value;

import java.util.List;

public class MultipleValue extends Value {

    public MultipleValue(List<String> params, boolean selectionType) {
        super();
        this.inputPattern = params;
        this.selectionType = selectionType;
    }

    @Override
    public List<String> getInputPattern() {
        return this.inputPattern;
    }

    @Override
    public boolean getSelectionType() {
        return this.selectionType;
    }
}