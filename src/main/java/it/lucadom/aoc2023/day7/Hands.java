package it.lucadom.aoc2023.day7;

import java.util.List;
import java.util.stream.IntStream;

public record Hands(List<Hand> hands) {
    public static Hands fromInput(List<String> input) {
        List<Hand> hands = input.stream()
                .map(row -> {
                    String[] split = row.split(" ");
                    String cards = split[0];
                    int bid = Integer.parseInt(split[1]);
                    return new Hand(cards, bid);
                }).toList();
        return new Hands(hands);
    }

    public long totalWinnings() {
        List<Hand> sorted = hands.stream().sorted(new HandStrengthComparator()).toList();
        return IntStream.range(0, sorted.size())
                .mapToLong(index -> (long) (index + 1) * sorted.get(index).bid())
                .sum();
    }

}
