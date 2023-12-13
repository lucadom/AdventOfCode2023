package it.lucadom.aoc2023.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    @Test
    void engine() {
        Engine underTest = new Engine(List.of("ab", "cd"));
        assertEquals(2, underTest.rows());
        assertEquals(2, underTest.cols());
        assertArrayEquals( new String[][]{{"a", "b"}, {"c", "d"}}, underTest.schematic());
    }

    @Test
    void candidates() {
        assertEquals(List.of(
                new PartNumber(new Coord(0, 0), 467),
                new PartNumber(new Coord(0, 5), 114),
                new PartNumber(new Coord(2, 2), 35),
                new PartNumber(new Coord(2, 6), 633)
        ), new Engine(List.of(
                "467..114..",
                "...*......",
                "..35..633.")).candidates());
    }

    @Test
    void neighbours() {
        assertEquals(List.of("r", "a", "s", "d", "f"),
                new Engine(List.of(
                        "123rt",
                        "asdfg",
                        "zxcvb")).neighbours(new PartNumber(new Coord(0, 0), 123)));

        assertEquals(List.of("w", "s", "d", "f", "g"),
                new Engine(List.of(
                        "qw123",
                        "asdfg",
                        "zxcvb")).neighbours(new PartNumber(new Coord(0, 2), 123)));

        assertEquals(List.of("q", "w", "e", "r", "t", "a", "g", "z", "x", "c", "v", "b"),
                new Engine(List.of(
                "qwert",
                "a123g",
                "zxcvb")).neighbours(new PartNumber(new Coord(1, 1), 123)));
    }

    @Test
    void partNumbers() {
        assertEquals(List.of(
                new PartNumber(new Coord(0, 0), 467),
                new PartNumber(new Coord(2, 2), 35)
        ), new Engine(List.of(
                "467..114..",
                "...*......",
                "..35..633.")).partNumbers());
    }
}