package it.lucadom.aoc2023.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle1_1Test {

    @Test
    void solve() {
        assertEquals("142", new Puzzle1_1().solve("puzzle1_1"));
    }
    @Test
    void extractNumber() {
        assertEquals(12, Puzzle1_1.extractNumber("1abc2"));
        assertEquals(38, Puzzle1_1.extractNumber("pqr3stu8vwx"));
        assertEquals(15, Puzzle1_1.extractNumber("a1b2c3d4e5f"));
        assertEquals(77, Puzzle1_1.extractNumber("treb7uchet"));
    }

}