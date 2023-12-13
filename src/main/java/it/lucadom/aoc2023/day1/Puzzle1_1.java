package it.lucadom.aoc2023.day1;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle1_1 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Long sum = input.stream()
                .map(Puzzle1_1::extractNumber)
                .mapToLong(Long::longValue)
                .sum();
        return String.valueOf(sum);
    }

    public static Long extractNumber(String str) {
        String replaced = str.replaceAll("[^0-9]", "");
        String firstDigit = String.valueOf(replaced.charAt(0));
        String lastDigit = String.valueOf(replaced.charAt(replaced.length()-1));
        return Long.parseLong(firstDigit+lastDigit);
    }

}
