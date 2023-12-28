package it.lucadom.aoc2023.day10;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle10_2 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        long tilesEnclosed = PuzzleMap.fromInput(input).tilesEnclosed();
        return String.valueOf(tilesEnclosed);
    }

}
