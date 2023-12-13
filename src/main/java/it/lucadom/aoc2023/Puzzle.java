package it.lucadom.aoc2023;

import java.util.List;

public interface Puzzle {

    default String solve(String filename) {
        FileInputReader reader = new FileInputReader();
        List<String> input = reader.read(filename);
        return solve(input);
    }

    String solve(List<String> input);

}
