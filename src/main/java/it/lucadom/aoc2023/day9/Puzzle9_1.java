package it.lucadom.aoc2023.day9;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle9_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        long extrapolatedValue = Oasis.fromInput(input).sumExtrapolatedValuesForward();
        return String.valueOf(extrapolatedValue);
    }

}
