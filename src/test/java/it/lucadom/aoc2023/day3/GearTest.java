package it.lucadom.aoc2023.day3;

import it.lucadom.aoc2023.shared.Coord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GearTest {

    @Test
    void gear() {
        assertEquals(12, new Gear(new Coord(0, 0), 3, 4).ratio());
    }

}