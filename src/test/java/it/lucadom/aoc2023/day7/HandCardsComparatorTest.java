package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandCardsComparatorTest {

    private final CardComparator cardComparator = new CardComparator("AKQJT98765432");
    private final HandCardsComparator handCardsComparator = new HandCardsComparator(cardComparator);

    @Test
    void compare() {
        assertEquals(-1, handCardsComparator.compare("33332", "2AAAA"));
        assertEquals(1, handCardsComparator.compare("77788", "77888"));
    }
}