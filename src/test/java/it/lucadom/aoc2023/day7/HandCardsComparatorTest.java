package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandCardsComparatorTest {

    private final HandCardsComparator handCardsComparator = new HandCardsComparator();

    @Test
    void compare() {
        assertEquals(-1, handCardsComparator.compare("33332", "2AAAA"));
        assertEquals(1, handCardsComparator.compare("77788", "77888"));
    }
}