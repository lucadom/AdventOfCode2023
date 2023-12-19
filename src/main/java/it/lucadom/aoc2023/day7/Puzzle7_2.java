package it.lucadom.aoc2023.day7;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle7_2 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        CardComparator cardComparator = new CardComparator("AKQT98765432J");
        long totalWinnings = Hands.withJokers(input).totalWinnings(cardComparator);
        return String.valueOf(totalWinnings);
    }

}
