package it.lucadom.aoc2023.day4;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle4_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Long sum = input.stream()
                .map(Card::fromString)
                .mapToLong(Card::points)
                .sum();
        return String.valueOf(sum);
    }

}
