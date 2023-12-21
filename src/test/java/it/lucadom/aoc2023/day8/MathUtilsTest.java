package it.lucadom.aoc2023.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void lcm_of_array_elements() {
        assertEquals(6, MathUtils.lcm_of_array_elements(new int[]{2, 3}));
        assertEquals(24, MathUtils.lcm_of_array_elements(new int[]{1, 2, 8, 3}));
    }
}