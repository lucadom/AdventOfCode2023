package it.lucadom.aoc2023.day4;

import it.lucadom.aoc2023.Puzzle;

import java.util.Arrays;
import java.util.List;

public class Puzzle4_2 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        List<Card> cards = input.stream().map(Card::fromString).toList();
        long[] copies = new long[cards.size()];
        Arrays.fill(copies, 1);

        cards.forEach(card -> {
            for (int i = 0; i < card.found(); i++) {
                copies[card.id() + i] += (copies[card.id() - 1]);
            }
        });

        Long sum = Arrays.stream(copies).sum();

        return String.valueOf(sum);
    }

}
