package it.lucadom.aoc2023.day6;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle6_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        return Races.fromInput(input).beatenTogether().toString();
    }

}
