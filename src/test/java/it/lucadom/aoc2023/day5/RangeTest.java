package it.lucadom.aoc2023.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void containsSource() {
        assertFalse(new Range(50, 98, 2).containsSource(97));
        assertTrue(new Range(50, 98, 2).containsSource(98));
        assertTrue(new Range(50, 98, 2).containsSource(99));
        assertFalse(new Range(50, 98, 2).containsSource(100));
    }

    @Test
    void destination() {
        assertEquals(97, new Range(50, 98, 2).destination(97));
        assertEquals(50, new Range(50, 98, 2).destination(98));
        assertEquals(51, new Range(50, 98, 2).destination(99));
        assertEquals(100, new Range(50, 98, 2).destination(100));
    }

    @Test
    void containsDestination() {
        assertFalse(new Range(50, 98, 2).containsDestination(49));
        assertTrue(new Range(50, 98, 2).containsDestination(50));
        assertTrue(new Range(50, 98, 2).containsDestination(51));
        assertFalse(new Range(50, 98, 2).containsDestination(52));
    }

    @Test
    void source() {
        assertEquals(49, new Range(50, 98, 2).source(49));
        assertEquals(98, new Range(50, 98, 2).source(50));
        assertEquals(99, new Range(50, 98, 2).source(51));
        assertEquals(52, new Range(50, 98, 2).source(52));
    }

}