package it.lucadom.aoc2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class AlmanacTest {

    Mapping atob = new Mapping("a", "b", List.of(
            new Range(10, 0, 10)
    ));
    Mapping btoc = new Mapping("b", "c", List.of(
            new Range(100, 10, 10)
    ));
    Mapping ctod = new Mapping("c", "d", List.of(
            new Range(1000, 100, 10)
    ));
    Almanac almanac = new Almanac(null, List.of(atob, btoc, ctod));

    @Test
    void mappingFrom() {
        assertEquals(atob, almanac.mappingFrom("a"));
        assertEquals(btoc, almanac.mappingFrom("b"));
        assertEquals(ctod, almanac.mappingFrom("c"));
        assertThrows(NoSuchElementException.class, () -> almanac.mappingFrom("d"));
    }

    @Test
    void mappingTo() {
        assertEquals(atob, almanac.mappingTo("b"));
        assertEquals(btoc, almanac.mappingTo("c"));
        assertEquals(ctod, almanac.mappingTo("d"));
        assertThrows(NoSuchElementException.class, () -> almanac.mappingTo("e"));
    }

    @Test
    void fromSourceToDestination() {
        assertEquals(10, almanac.fromSourceToDestination("a", "b", 0));
        assertEquals(100, almanac.fromSourceToDestination("a", "c", 0));
        assertEquals(1000, almanac.fromSourceToDestination("a", "d", 0));
    }

    @Test
    void fromDestinationToSource() {
        assertEquals(0, almanac.fromDestinationToSource("b", "a", 10));
        assertEquals(0, almanac.fromDestinationToSource("c", "a", 100));
        assertEquals(0, almanac.fromDestinationToSource("d", "a", 1000));
    }

}