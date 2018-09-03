package com.codecool.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String id;
    private String description;
    private Map<String, Boolean> valuesById;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.valuesById = new HashMap<String, Boolean>();
    }

    public Set<String> getIdSet() {
        return this.valuesById.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        this.valuesById.put(id, value);
    }

    public boolean getValueById(String id) {
        return this.valuesById.get(id);
    }

    public String getDescription() {
        return this.description;
    }
}