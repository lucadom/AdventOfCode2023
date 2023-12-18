package it.lucadom.aoc2023.day7;

import it.lucadom.aoc2023.Puzzle;
import it.lucadom.aoc2023.day6.Races;

import java.util.List;

public class Puzzle7_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        long totalWinnings = Hands.fromInput(input).totalWinnings();
        return String.valueOf(totalWinnings);
    }

}
