package it.lucadom.aoc2023.day7;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle7_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        CardComparator cardComparator = new CardComparator("AKQJT98765432");
        long totalWinnings = Hands.withoutJokers(input).totalWinnings(cardComparator);
        return String.valueOf(totalWinnings);
    }

}
