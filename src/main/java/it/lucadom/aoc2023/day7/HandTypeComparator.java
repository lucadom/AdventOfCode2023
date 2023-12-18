package it.lucadom.aoc2023.day7;

import java.util.Comparator;

public class HandTypeComparator implements Comparator<HandType> {
    @Override
    public int compare(HandType h1, HandType h2) {
        return Integer.compare(h2.strength, h1.strength);
    }
}
