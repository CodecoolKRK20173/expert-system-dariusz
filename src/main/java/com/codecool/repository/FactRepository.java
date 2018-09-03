package com.codecool.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.codecool.data.Fact;

public class FactRepository {
    private List<Fact> facts;
    private FactIterator factIterator;

    public FactRepository() {
        this.facts = new ArrayList<Fact>();
        this.factIterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return this.factIterator;
    }

    private class FactIterator implements Iterator<Fact> {
        private int currentIndex = 0;

        public Fact next() {
            return facts.get(currentIndex++);
        }

        public boolean hasNext() {
            return currentIndex < facts.size();
        }
    }

}