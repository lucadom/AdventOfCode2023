package it.lucadom.aoc2023.day6;

import it.lucadom.aoc2023.Puzzle;
import it.lucadom.aoc2023.day5.Almanac;

import java.util.List;

public class Puzzle6_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Races races = Races.fromInput(input);
        long beatenTogether = races.beatenTogether();
        return String.valueOf(beatenTogether);
    }

}
