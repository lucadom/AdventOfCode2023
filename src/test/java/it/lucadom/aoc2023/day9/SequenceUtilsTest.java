package it.lucadom.aoc2023.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceUtilsTest {

    @Test
    void predictNextValue() {
        assertEquals(28, SequenceUtils.predictNextValue(List.of(1, 3, 6, 10, 15, 21)));
    }

    @Test
    void nextSequence() {
        assertEquals(List.of(2, 3, 4, 5, 6), SequenceUtils.nextSequence(List.of(1, 3, 6, 10, 15, 21)));
    }

    @Test
    void extrapolatePreviousValue() {
        assertEquals(-3, SequenceUtils.extrapolatePreviousValue(List.of(0, 3, 6, 9, 12, 15)));
        assertEquals(0, SequenceUtils.extrapolatePreviousValue(List.of(1, 3, 6, 10, 15, 21)));
        assertEquals(5, SequenceUtils.extrapolatePreviousValue(List.of(10, 13, 16, 21, 30, 45)));
    }

}