package it.lucadom.aoc2023.day8;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigationMapTest {

    @Test
    void fromInput() {
        assertEquals(new NavigationMap("RL", Map.of(
                "AAA", new Pair("BBB", "CCC"),
                "BBB", new Pair("DDD", "EEE")
        )), NavigationMap.fromInput(List.of(
                "RL",
                "",
                "AAA = (BBB, CCC)",
                "BBB = (DDD, EEE)"
        )));
    }

}