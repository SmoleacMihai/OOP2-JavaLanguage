package org.example;

public class CounterClass {
    private int nrVowels;
    private int nrConsonants;

    public int getNrVowels() {
        return nrVowels;
    }

    public int getNrConsonants() {
        return nrConsonants;
    }

    public CounterClass(int nrVowels, int nrConsonants) {
        this.nrVowels = nrVowels;
        this.nrConsonants = nrConsonants;
    }
}
