package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTypeComparatorTest {

    private final HandTypeComparator handTypeComparator = new HandTypeComparator();

    @Test
    void compare() {
        assertEquals(-1, handTypeComparator.compare(HandType.FIVE_OF_A_KIND, HandType.FOUR_OF_A_KIND));
        assertEquals(0, handTypeComparator.compare(HandType.THREE_OF_A_KIND, HandType.THREE_OF_A_KIND));
        assertEquals(1, handTypeComparator.compare(HandType.HIGH_CARD, HandType.TWO_PAIR));
    }

}