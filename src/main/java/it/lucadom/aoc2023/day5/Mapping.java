package it.lucadom.aoc2023.day5;

import java.util.List;
import java.util.Optional;

public record Mapping(String source, String destination, List<Range> ranges) {

    public long map(long source) {
        return ranges.stream()
                .filter(r -> r.contains(source))
                .findFirst()
                .map(r -> r.destination(source))
                .orElse(source);
    }
}
