package it.lucadom.aoc2023.day5;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle5_2 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Almanac almanac = Almanac.fromInput(input);
        long lowestLocation = almanac.lowestLocationFromSeedRange();
        return String.valueOf(lowestLocation);
    }

}