package it.lucadom.aoc2023.day2;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle2_2 implements Puzzle {

    public static final Cubes MAX_CUBES = new Cubes(14, 12, 13);

    @Override
    public String solve(List<String> input) {
        Long sum = input.stream()
                .map(Game::fromString)
                .map(Game::minimum)
                .mapToLong(Cubes::power)
                .sum();
        return String.valueOf(sum);
    }

}
