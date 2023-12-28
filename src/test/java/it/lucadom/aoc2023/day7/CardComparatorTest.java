package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardComparatorTest {

    @Test
    void compare() {
        CardComparator cardComparator = new CardComparator("AKQJT98765432");
        assertEquals(-1, cardComparator.compare("A", "K"));
        assertEquals(0, cardComparator.compare("Q", "Q"));
        assertEquals(1, cardComparator.compare("4", "7"));
    }

    @Test
    void sort() {
        CardComparator cardComparator = new CardComparator("AKQJT98765432");
        assertEquals("AKQJT98765432", Arrays.stream("T4532JQ67K8A9".split(""))
                .sorted(cardComparator)
                .collect(Collectors.joining())
        );
    }
}