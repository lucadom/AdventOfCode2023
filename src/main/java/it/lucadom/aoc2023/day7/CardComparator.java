package it.lucadom.aoc2023.day7;

import java.util.Comparator;

public class CardComparator implements Comparator<String> {

    private final String cardStrength;

    CardComparator(String cardStrength) {
        this.cardStrength = cardStrength;
    }

    @Override
    public int compare(String h1, String h2) {
        return Integer.compare(cardStrength.indexOf(h1), cardStrength.indexOf(h2));
    }

}
