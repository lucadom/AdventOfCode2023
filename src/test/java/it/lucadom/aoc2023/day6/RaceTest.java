package it.lucadom.aoc2023.day6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void wins() {
        assertEquals(BigInteger.valueOf(4), new Race(BigInteger.valueOf(7), BigInteger.valueOf(9)).wins());
        assertEquals(BigInteger.valueOf(8), new Race(BigInteger.valueOf(15), BigInteger.valueOf(40)).wins());
        assertEquals(BigInteger.valueOf(9), new Race(BigInteger.valueOf(30), BigInteger.valueOf(200)).wins());
    }
}