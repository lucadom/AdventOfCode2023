package it.lucadom.aoc2023.day5;

import java.util.List;

public record Mapping(String source, String destination, List<Range> ranges) {

    public long mapToDestination(long source) {
        return ranges.stream()
                .filter(r -> r.containsSource(source))
                .findFirst()
                .map(r -> r.destination(source))
                .orElse(source);
    }

    public long mapToSource(long destination) {
        return ranges.stream()
                .filter(r -> r.containsDestination(destination))
                .findFirst()
                .map(r -> r.source(destination))
                .orElse(destination);
    }

}
