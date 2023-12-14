package it.lucadom.aoc2023.day4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public record Card(int id, List<Integer> winningNumbers, List<Integer> yourNumbers) {

    public static Card fromString(String row) {
        String[] card = row.split(": ");
        int id = Integer.parseInt(card[0].split("\\s+")[1]);
        String[] numbers = card[1].split(" \\| ");
        List<Integer> winningNumbers = Arrays.stream(numbers[0].split("\\s+"))
                .filter(Predicate.not(String::isEmpty))
                .map(Integer::parseInt)
                .toList();
        List<Integer> yourNumbers = Arrays.stream(numbers[1].split("\\s+"))
                .filter(Predicate.not(String::isEmpty))
                .map(Integer::parseInt)
                .toList();
        return new Card(id, winningNumbers, yourNumbers);
    }

    public int points() {
        long found = found();
        return found == 0 ? 0 : (int) Math.pow(2, found-1);
    }

    public long found() {
        return yourNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

}
