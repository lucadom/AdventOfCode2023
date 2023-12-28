package it.lucadom.aoc2023.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle10_1Test {

    @Test
    void solve() {
        assertEquals("4", new Puzzle10_1().solve("puzzle10_1_1"));
        assertEquals("8", new Puzzle10_1().solve("puzzle10_1_2"));
    }
}