package it.lucadom.aoc2023.day8;

import java.util.*;

public record NavigationMap(String instructions, Map<String, Pair> mapNodes) {
    public static NavigationMap fromInput(List<String> input) {
        String instructions = input.get(0);
        Map<String, Pair> mapNodes = new HashMap<>();
        input.subList(2, input.size()).forEach(row -> mapNodes.put(
                row.substring(0, 3), new Pair(
                    row.substring(7, 10),
                    row.substring(12, 15)
                )
        ));
        return new NavigationMap(instructions, mapNodes);
    }

    public long totalSteps() {
        int total = 0;
        String currentPoint = "AAA";
        Iterator<Character> instructionsIterator = new LoopIterator(instructions);
        while (!currentPoint.equals("ZZZ")) {
            total++;
            currentPoint = instructionsIterator.next() == 'L'
                    ? mapNodes.get(currentPoint).left()
                    : mapNodes.get(currentPoint).right();
        }
        return total;
    }

    public long totalSimultaneousSteps() {
        int[] pathsSteps = mapNodes.keySet().stream()
                .filter(k -> k.endsWith("A"))
                .mapToInt(k -> {
                    int total = 0;
                    String currentPoint = k;
                    Iterator<Character> instructionsIterator = new LoopIterator(instructions);
                    while (!currentPoint.endsWith("Z")) {
                        total++;
                        currentPoint = instructionsIterator.next() == 'L'
                                ? mapNodes.get(currentPoint).left()
                                : mapNodes.get(currentPoint).right();
                    }
                    return total;
                })
                .toArray();
        return MathUtils.lcm_of_array_elements(pathsSteps);
    }

}
