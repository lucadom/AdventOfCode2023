package it.lucadom.aoc2023.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void contains() {
        assertFalse(new Range(50, 98, 2).contains(97));
        assertTrue(new Range(50, 98, 2).contains(98));
        assertTrue(new Range(50, 98, 2).contains(99));
        assertFalse(new Range(50, 98, 2).contains(100));
    }

    @Test
    void destination() {
        assertEquals(97, new Range(50, 98, 2).destination(97));
        assertEquals(50, new Range(50, 98, 2).destination(98));
        assertEquals(51, new Range(50, 98, 2).destination(99));
        assertEquals(100, new Range(50, 98, 2).destination(100));
    }
}