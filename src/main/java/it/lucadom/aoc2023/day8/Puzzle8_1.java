package it.lucadom.aoc2023.day8;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle8_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        long totalSteps = NavigationMap.fromInput(input).totalSteps();
        return String.valueOf(totalSteps);
    }

}
