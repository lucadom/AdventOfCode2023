package it.lucadom.aoc2023.day7;

import java.util.Comparator;

public class HandStrengthComparator implements Comparator<Hand> {

    private final CardComparator cardComparator;

    public HandStrengthComparator(CardComparator cardComparator) {
        this.cardComparator = cardComparator;
    }

    @Override
    public int compare(Hand h1, Hand h2) {
        int compared = new HandTypeComparator().compare(h2.handType(), h1.handType());
        if (compared != 0) {
            return compared;
        }
        return new HandCardsComparator(cardComparator).compare(h2.cards(), h1.cards());
    }
}
