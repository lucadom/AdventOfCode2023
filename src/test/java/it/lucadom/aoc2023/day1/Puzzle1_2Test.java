package it.lucadom.aoc2023.day1;

import it.lucadom.aoc2023.day1.Puzzle1_2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle1_2Test {

    @Test
    void solve() {
        assertEquals("281", new Puzzle1_2().solve("puzzle1_2"));
    }
    @Test
    void extractNumber_sample() {
        assertEquals(29, Puzzle1_2.extractNumber("two1nine"));
        assertEquals(83, Puzzle1_2.extractNumber("eightwothree"));
        assertEquals(13, Puzzle1_2.extractNumber("abcone2threexyz"));
        assertEquals(24, Puzzle1_2.extractNumber("xtwone3four"));
        assertEquals(42, Puzzle1_2.extractNumber("4nineeightseven2"));
        assertEquals(14, Puzzle1_2.extractNumber("zoneight234"));
        assertEquals(76, Puzzle1_2.extractNumber("7pqrstsixteen"));
    }

    @Test
    void extractNumber_base() {
        assertEquals(11, Puzzle1_2.extractNumber("1"));
        assertEquals(11, Puzzle1_2.extractNumber("one"));

        assertEquals(11, Puzzle1_2.extractNumber("x1"));
        assertEquals(11, Puzzle1_2.extractNumber("xone"));

        assertEquals(11, Puzzle1_2.extractNumber("1x"));
        assertEquals(11, Puzzle1_2.extractNumber("onex"));

        assertEquals(11, Puzzle1_2.extractNumber("oneone"));
        assertEquals(11, Puzzle1_2.extractNumber("one1"));
        assertEquals(11, Puzzle1_2.extractNumber("1one"));
        assertEquals(11, Puzzle1_2.extractNumber("11"));

        assertEquals(11, Puzzle1_2.extractNumber("xoneone"));
        assertEquals(11, Puzzle1_2.extractNumber("xone1"));
        assertEquals(11, Puzzle1_2.extractNumber("x1one"));
        assertEquals(11, Puzzle1_2.extractNumber("x11"));

        assertEquals(11, Puzzle1_2.extractNumber("oneonex"));
        assertEquals(11, Puzzle1_2.extractNumber("one1x"));
        assertEquals(11, Puzzle1_2.extractNumber("1onex"));
        assertEquals(11, Puzzle1_2.extractNumber("11x"));

        assertEquals(11, Puzzle1_2.extractNumber("onexone"));
        assertEquals(11, Puzzle1_2.extractNumber("onex1"));
        assertEquals(11, Puzzle1_2.extractNumber("1xone"));
        assertEquals(11, Puzzle1_2.extractNumber("1x1"));

        assertEquals(11, Puzzle1_2.extractNumber("xonexone"));
        assertEquals(11, Puzzle1_2.extractNumber("xonex1"));
        assertEquals(11, Puzzle1_2.extractNumber("x1xone"));
        assertEquals(11, Puzzle1_2.extractNumber("x1x1"));

        assertEquals(11, Puzzle1_2.extractNumber("onexonex"));
        assertEquals(11, Puzzle1_2.extractNumber("onex1x"));
        assertEquals(11, Puzzle1_2.extractNumber("1xonex"));
        assertEquals(11, Puzzle1_2.extractNumber("1x1x"));

        assertEquals(11, Puzzle1_2.extractNumber("xonexonex"));
        assertEquals(11, Puzzle1_2.extractNumber("xonex1x"));
        assertEquals(11, Puzzle1_2.extractNumber("x1xonex"));
        assertEquals(11, Puzzle1_2.extractNumber("x1x1x"));
    }

    @Test
    void extractNumber_other() {
        assertEquals(28, Puzzle1_2.extractNumber("abc2x3oneight"));
    }

}