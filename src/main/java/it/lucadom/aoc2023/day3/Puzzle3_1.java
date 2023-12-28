package it.lucadom.aoc2023.day3;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle3_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Engine engine = new Engine(input);

        Long sum = engine.partNumbers().stream()
                .mapToLong(PartNumber::number)
                .sum();
        return String.valueOf(sum);
    }

}
