package it.lucadom.aoc2023.day9;

import java.util.ArrayList;
import java.util.List;

public class SequenceUtils {

    public static long predictNextValue(List<Integer> sequence) {
        long nextValue = sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 1) - sequence.get(sequence.size() - 2);
        while (sequence.stream().anyMatch(i -> i != 0)) {
            sequence = nextSequence(sequence);
            nextValue += sequence.get(sequence.size() - 1) - sequence.get(sequence.size() - 2);
        }
        return nextValue;
    }

    public static List<Integer> nextSequence(List<Integer> sequence) {
        List<Integer> nextSequence = new ArrayList<>();
        for (int i=1; i<sequence.size(); i++) {
            nextSequence.add(sequence.get(i) - sequence.get(i-1));
        }
        return nextSequence;
    }

}
