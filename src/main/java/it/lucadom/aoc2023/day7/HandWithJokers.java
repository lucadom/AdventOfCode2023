package it.lucadom.aoc2023.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public record HandWithJokers(String cards, int bid) implements Hand {

    private int jokers() {
        return (int) cards.chars().filter(c -> c == 'J').count();
    }

    @Override
    public HandType handType() {
        Map<String, Integer> occurrences = new HashMap<>();

        // count non-joker cards
        Arrays.stream(cards.split("")).filter(card -> !card.equals("J")).forEach(card -> {
            if (occurrences.containsKey(card)) {
                occurrences.put(card, occurrences.get(card) + 1);
            } else {
                occurrences.put(card, 1);
            }
        });

        // if we have 5 equal cards (non-jokers or jokers) we're done
        if (occurrences.keySet().size() == 1 || occurrences.isEmpty()) {
            return HandType.FIVE_OF_A_KIND;
        }

        // add jokers count to the card with most occurrences
        String card = Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey();
        occurrences.put(card, occurrences.get(card) + jokers());

        // check again all hand types
        if (occurrences.keySet().size() == 1) {
            return HandType.FIVE_OF_A_KIND;
        } else if (occurrences.keySet().size() == 2) {
            if (occurrences.values().stream().anyMatch(count -> count == 4)) {
               return HandType.FOUR_OF_A_KIND;
            } else {
                return HandType.FULL_HOUSE;
            }
        } else if (occurrences.keySet().size() == 3) {
            if (occurrences.values().stream().anyMatch(count -> count == 3)) {
                return HandType.THREE_OF_A_KIND;
            } else {
                return HandType.TWO_PAIR;
            }
        } else if (occurrences.keySet().size() == 4) {
            return HandType.ONE_PAIR;
        } else {
            return HandType.HIGH_CARD;
        }
    }


}
