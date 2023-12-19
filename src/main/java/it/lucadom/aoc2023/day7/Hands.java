package it.lucadom.aoc2023.day7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Hands(List<Hand> hands) {
    public static Hands withoutJokers(List<String> input) {
        List<Hand> hands = input.stream()
                .map(row -> {
                    String[] split = row.split(" ");
                    String cards = split[0];
                    int bid = Integer.parseInt(split[1]);
                    return new HandWithoutJokers(cards, bid);
                }).collect(Collectors.toList());
        return new Hands(hands);
    }

    public static Hands withJokers(List<String> input) {
        List<Hand> hands = input.stream()
                .map(row -> {
                    String[] split = row.split(" ");
                    String cards = split[0];
                    int bid = Integer.parseInt(split[1]);
                    return new HandWithJokers(cards, bid);
                }).collect(Collectors.toList());
        return new Hands(hands);
    }

    public long totalWinnings(CardComparator cardComparator) {
        List<Hand> sorted = hands.stream().sorted(new HandStrengthComparator(cardComparator)).toList();
        return IntStream.range(0, sorted.size())
                .mapToLong(index -> (long) (index + 1) * sorted.get(index).bid())
                .sum();
    }

}
