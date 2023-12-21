package it.lucadom.aoc2023.day9;

import java.util.Arrays;
import java.util.List;

public record Oasis(List<List<Integer>> values) {
    public static Oasis fromInput(List<String> input) {
        List<List<Integer>> values = input.stream()
                .map(row -> Arrays.stream(row.split(" "))
                        .map(Integer::parseInt)
                        .toList()
                )
                .toList();
        return new Oasis(values);
    }

    public long sumExtrapolatedValuesForward() {
        return values.stream()
                .mapToLong(SequenceUtils::predictNextValue)
                .sum();
    }

    public long sumExtrapolatedValuesBackward() {
        return values.stream()
                .mapToLong(SequenceUtils::extrapolatePreviousValue)
                .sum();
    }
}
