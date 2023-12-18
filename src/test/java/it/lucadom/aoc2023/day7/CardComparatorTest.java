package it.lucadom.aoc2023.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CardComparatorTest {

    private final CardComparator cardComparator = new CardComparator();

    @Test
    void compare() {
        assertEquals(-1, cardComparator.compare("A", "K"));
        assertEquals(0, cardComparator.compare("Q", "Q"));
        assertEquals(1, cardComparator.compare("4", "7"));
    }

    @Test
    void sort() {
        assertEquals("AKQJT98765432", Arrays.stream("T4532JQ67K8A9".split(""))
                .sorted(cardComparator)
                .collect(Collectors.joining())
        );
    }
}