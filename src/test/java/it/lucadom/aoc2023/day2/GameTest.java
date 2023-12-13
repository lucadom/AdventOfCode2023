package it.lucadom.aoc2023.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void getGame() {
        assertEquals(new Game(1, List.of(
                new Cubes(3, 4, 0),
                new Cubes(6, 1, 2),
                new Cubes(0, 0, 2)
        )), Game.fromString("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
    }

    @Test
    void minimumCubes() {
        assertEquals(new Cubes(6, 4, 2),
                new Game(1, List.of(
                    new Cubes(3, 4, 0),
                    new Cubes(6, 1, 2),
                    new Cubes(0, 0, 2)
        )).minimum());
    }
}
