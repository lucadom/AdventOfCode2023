package it.lucadom.aoc2023.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public record Hand(String cards, int bid) {

    public HandType handType() {
        Map<String, Integer> occurrences = new HashMap<>();
        Arrays.stream(cards.split("")).forEach(card -> {
            if (occurrences.containsKey(card)) {
                occurrences.put(card, occurrences.get(card) + 1);
            } else {
                occurrences.put(card, 1);
            }
        });
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
