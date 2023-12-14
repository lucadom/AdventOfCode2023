package it.lucadom.aoc2023.day5;

import java.util.*;

public record Almanac(List<Long> seeds, List<Mapping> mappings) {

    public static Almanac fromInput(List<String> input) {
        List<Long> seeds = new ArrayList<>();
        List<Mapping> mappings = new ArrayList<>();
        for (Iterator<String> it = input.iterator(); it.hasNext();) {
            String row = it.next();
            if (row.startsWith("seeds:")) {
               seeds.addAll(Arrays.stream(row.split(": ")[1].split(" ")).map(Long::parseLong).toList());
            } else if (row.contains("map:")) {
                String map = row.split(" ")[0];
                String[] split = map.split("-to-");
                Mapping mapping = new Mapping(split[0], split[1], new ArrayList<>());
                while (it.hasNext() && !row.isEmpty()) {
                    row = it.next();
                    if (!row.isEmpty()) {
                        String[] values = row.split(" ");
                        mapping.ranges().add(new Range(
                                Long.parseLong(values[0]),
                                Long.parseLong(values[1]),
                                Long.parseLong(values[2])
                        ));
                    }
                }
                mappings.add(mapping);
            }
        };
        return new Almanac(seeds, mappings);
    }

    public Mapping mappingFrom(String source) throws NoSuchElementException {
        return mappings().stream().filter(m -> m.source().equals(source)).findFirst().orElseThrow();
    }

    public long map(String source, String destination, long value) {
        Mapping mapping = mappingFrom(source);
        value = mapping.map(value);
        if (mapping.destination().equals(destination)) {
            return value;
        } else {
            return map(mapping.destination(), destination, value);
        }
    }

    public long lowestLocation() {
        return seeds.stream()
                .map(s -> map("seed", "location", s))
                .min(Long::compareTo)
                .orElse(0L);
    }

}
