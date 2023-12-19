package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void handType() {
        assertEquals(HandType.FIVE_OF_A_KIND, new HandWithoutJokers("AAAAA", 0).handType());
        assertEquals(HandType.FOUR_OF_A_KIND, new HandWithoutJokers("AA8AA", 0).handType());
        assertEquals(HandType.FULL_HOUSE, new HandWithoutJokers("23332", 0).handType());
        assertEquals(HandType.THREE_OF_A_KIND, new HandWithoutJokers("TTT98", 0).handType());
        assertEquals(HandType.TWO_PAIR, new HandWithoutJokers("23432", 0).handType());
        assertEquals(HandType.ONE_PAIR, new HandWithoutJokers("A23A4", 0).handType());
        assertEquals(HandType.HIGH_CARD, new HandWithoutJokers("23456", 0).handType());
    }
}