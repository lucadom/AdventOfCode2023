package it.lucadom.aoc2023.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleMapTest {

    @Test
    void fromInput() {
        assertArrayEquals(new String[][]{{"F", "7"}, {"L", "J"}},
                PuzzleMap.fromInput(List.of("F7", "LJ")).tiles());
    }
}