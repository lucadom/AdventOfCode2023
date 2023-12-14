package it.lucadom.aoc2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MappingTest {

    @Test
    void map() {
        Mapping mapping = new Mapping("seed", "soil", List.of(
                new Range(50, 98, 2),
                new Range(52, 50, 48)
        ));

        assertEquals(0, mapping.map(0));
        assertEquals(1, mapping.map(1));
        assertEquals(48, mapping.map(48));
        assertEquals(49, mapping.map(49));
        assertEquals(52, mapping.map(50));
        assertEquals(53, mapping.map(51));
        assertEquals(98, mapping.map(96));
        assertEquals(99, mapping.map(97));
        assertEquals(50, mapping.map(98));
        assertEquals(51, mapping.map(99));
    }
}