package org.example;

public class Kitty implements Cutie {

    @Override
    public String description() {
        return "A tiny kitten that purrs loudly.";
    }

    @Override
    public Integer cutenessRating() {
        return 9;
    }
}
