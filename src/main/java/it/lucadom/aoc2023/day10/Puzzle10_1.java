package it.lucadom.aoc2023.day10;

import it.lucadom.aoc2023.Puzzle;
import it.lucadom.aoc2023.day9.Oasis;

import java.util.List;

public class Puzzle10_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        long steps = PuzzleMap.fromInput(input).stepsToFarthestTileFromStart();
        return String.valueOf(steps);
    }

}
