package it.lucadom.aoc2023.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CubesTest {

    @Test
    void getCubes() {
        assertEquals(new Cubes(1, 0, 0), Cubes.fromString("1 blue"));
        assertEquals(new Cubes(6, 1, 2), Cubes.fromString("1 red, 2 green, 6 blue"));
    }

    @Test
    void validCubes() {
        Cubes max = new Cubes(14, 12, 13);

        assertTrue(new Cubes(14, 12, 13).valid(max));

        assertFalse(new Cubes(15, 12, 13).valid(max));
        assertFalse(new Cubes(14, 13, 13).valid(max));
        assertFalse(new Cubes(14, 12, 14).valid(max));
    }

    @Test
    void cubesPower() {
        assertEquals(0, new Cubes(0, 0, 0).power());

        assertEquals(1, new Cubes(1, 0, 0).power());
        assertEquals(1, new Cubes(0, 1, 0).power());
        assertEquals(1, new Cubes(0, 0, 1).power());

        assertEquals(1, new Cubes(1, 1, 1).power());

        assertEquals(48, new Cubes(6, 4, 2).power());
        assertEquals(12, new Cubes(4, 1, 3).power());
        assertEquals(1560, new Cubes(6, 20, 13).power());
        assertEquals(630, new Cubes(15, 14, 3).power());
        assertEquals(36, new Cubes(2, 6, 3).power());
    }

}
