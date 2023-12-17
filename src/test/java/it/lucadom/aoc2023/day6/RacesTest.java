package it.lucadom.aoc2023.day6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacesTest {

    @Test
    void fromInput() {
        assertEquals(new Races(
                List.of(
                        new Race(BigInteger.valueOf(7), BigInteger.valueOf(9)),
                        new Race(BigInteger.valueOf(15), BigInteger.valueOf(40)),
                        new Race(BigInteger.valueOf(30), BigInteger.valueOf(200))
                )
        ), Races.fromInput(List.of(
                "Time:      7  15   30",
                "Distance:  9  40  200")
        ));
    }

}