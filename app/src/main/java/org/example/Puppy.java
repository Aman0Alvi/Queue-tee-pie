package org.example;

public class Puppy implements Cutie {

    @Override
    public String description() {
        return "A playful puppy that loves belly rubs.";
    }

    @Override
    public Integer cutenessRating() {
        return 10;
    }
}
