package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void handType() {
        assertEquals(HandType.FIVE_OF_A_KIND, new Hand("AAAAA", 0).handType());
        assertEquals(HandType.FOUR_OF_A_KIND, new Hand("AA8AA", 0).handType());
        assertEquals(HandType.FULL_HOUSE, new Hand("23332", 0).handType());
        assertEquals(HandType.THREE_OF_A_KIND, new Hand("TTT98", 0).handType());
        assertEquals(HandType.TWO_PAIR, new Hand("23432", 0).handType());
        assertEquals(HandType.ONE_PAIR, new Hand("A23A4", 0).handType());
        assertEquals(HandType.HIGH_CARD, new Hand("23456", 0).handType());
    }
}