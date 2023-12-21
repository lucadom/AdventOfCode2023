package it.lucadom.aoc2023.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceUtilsTest {

    @Test
    void predictNextValue() {
        assertEquals(28, SequenceUtils.predictNextValue(List.of(1, 3, 6, 10, 15, 21)));
    }

    @Test
    void nextSequence() {
        assertEquals(List.of(2, 3, 4, 5, 6), SequenceUtils.nextSequence(List.of(1, 3, 6, 10, 15, 21)));
    }
}