package it.lucadom.aoc2023.day7;

import java.util.Comparator;

public class CardComparator implements Comparator<String> {

    private static final String CARD_STRENGTH = "AKQJT98765432";
    @Override
    public int compare(String h1, String h2) {
        return Integer.compare(CARD_STRENGTH.indexOf(h1), CARD_STRENGTH.indexOf(h2));
    }

}
