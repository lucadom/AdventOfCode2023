package it.lucadom.aoc2023.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void fromString() {
        assertEquals(new Card(1, List.of(41, 48, 83, 86, 17), List.of(83, 86, 6, 31, 17, 9, 48, 53)),
                Card.fromString("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"));
        assertEquals(new Card(1, List.of(1, 2, 3), List.of(1, 2, 3)),
                Card.fromString("Card   1:  1  2  3 |  1  2  3"));
    }

    @Test
    void points() {
        assertEquals(0, new Card(1, List.of(1), List.of(2)).points());
        assertEquals(1, new Card(1, List.of(1, 2), List.of(2, 3)).points());
        assertEquals(2, new Card(1, List.of(1, 2), List.of(1, 2, 3)).points());
        assertEquals(8, new Card(1, List.of(41, 48, 83, 86, 17), List.of(83, 86, 6, 31, 17, 9, 48, 53)).points());
    }
}