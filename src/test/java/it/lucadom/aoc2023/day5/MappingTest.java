package it.lucadom.aoc2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MappingTest {

    @Test
    void mapToDestination() {
        Mapping mapping = new Mapping("seed", "soil", List.of(
                new Range(50, 98, 2),
                new Range(52, 50, 48)
        ));

        assertEquals(0, mapping.mapToDestination(0));
        assertEquals(1, mapping.mapToDestination(1));
        assertEquals(48, mapping.mapToDestination(48));
        assertEquals(49, mapping.mapToDestination(49));
        assertEquals(52, mapping.mapToDestination(50));
        assertEquals(53, mapping.mapToDestination(51));
        assertEquals(98, mapping.mapToDestination(96));
        assertEquals(99, mapping.mapToDestination(97));
        assertEquals(50, mapping.mapToDestination(98));
        assertEquals(51, mapping.mapToDestination(99));
    }

    @Test
    void mapToSource() {
        Mapping mapping = new Mapping("seed", "soil", List.of(
                new Range(50, 98, 2),
                new Range(52, 50, 48)
        ));

        assertEquals(0, mapping.mapToSource(0));
        assertEquals(1, mapping.mapToSource(1));
        assertEquals(48, mapping.mapToSource(48));
        assertEquals(49, mapping.mapToSource(49));
        assertEquals(50, mapping.mapToSource(52));
        assertEquals(51, mapping.mapToSource(53));
        assertEquals(96, mapping.mapToSource(98));
        assertEquals(97, mapping.mapToSource(99));
        assertEquals(98, mapping.mapToSource(50));
        assertEquals(99, mapping.mapToSource(51));
    }

}