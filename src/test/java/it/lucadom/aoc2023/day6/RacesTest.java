package it.lucadom.aoc2023.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacesTest {

    @Test
    void fromInput() {
        assertEquals(new Races(
                List.of(
                        new Race(7, 9),
                        new Race(15, 40),
                        new Race(30, 200)
                )
        ), Races.fromInput(List.of(
                "Time:      7  15   30",
                "Distance:  9  40  200")
        ));
    }

}