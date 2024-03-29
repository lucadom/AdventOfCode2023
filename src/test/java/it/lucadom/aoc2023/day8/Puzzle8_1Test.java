package it.lucadom.aoc2023.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle8_1Test {

    @Test
    void solve() {
        assertEquals("2", new Puzzle8_1().solve("puzzle8_1_1"));
        assertEquals("6", new Puzzle8_1().solve("puzzle8_1_2"));
    }

}