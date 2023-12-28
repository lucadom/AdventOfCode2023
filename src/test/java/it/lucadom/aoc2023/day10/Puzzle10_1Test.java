package it.lucadom.aoc2023.day10;

import it.lucadom.aoc2023.day9.Puzzle9_2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle10_1Test {

    @Test
    void solve() {
        assertEquals("4", new Puzzle10_1().solve("puzzle10_1_1"));
        assertEquals("8", new Puzzle10_1().solve("puzzle10_1_2"));
    }
}