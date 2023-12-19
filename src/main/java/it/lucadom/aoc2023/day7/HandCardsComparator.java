package it.lucadom.aoc2023.day7;

import java.util.Comparator;

public class HandCardsComparator implements Comparator<String> {

    private final CardComparator cardComparator;

    public HandCardsComparator(CardComparator cardComparator) {
        this.cardComparator = cardComparator;
    }

    @Override
    public int compare(String h1, String h2) {
        int result = 0;
        for (int i=0; i<h1.length(); i++) {
            result = cardComparator.compare(
                    String.valueOf(h1.charAt(i)),
                    String.valueOf(h2.charAt(i))
            );
            if (result != 0) {
                return result;
            }
        }
        return result;
    }
}
