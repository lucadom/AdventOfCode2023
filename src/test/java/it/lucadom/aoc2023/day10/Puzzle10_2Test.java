package it.lucadom.aoc2023.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle10_2Test {

    @Test
    void solve() {
        assertEquals("4", new Puzzle10_2().solve("puzzle10_2_1"));
        assertEquals("8", new Puzzle10_2().solve("puzzle10_2_2"));
        assertEquals("10", new Puzzle10_2().solve("puzzle10_2_3"));
    }
}