package it.lucadom.aoc2023.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void wins() {
        assertEquals(4, new Race(7, 9).wins());
        assertEquals(8, new Race(15, 40).wins());
        assertEquals(9, new Race(30, 200).wins());
    }
}