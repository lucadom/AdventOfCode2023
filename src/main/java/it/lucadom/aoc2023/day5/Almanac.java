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

    public Mapping mappingTo(String destination) throws NoSuchElementException {
        return mappings().stream().filter(m -> m.destination().equals(destination)).findFirst().orElseThrow();
    }

    public long fromSourceToDestination(String source, String destination, long value) {
        Mapping mapping = mappingFrom(source);
        value = mapping.mapToDestination(value);
        if (mapping.destination().equals(destination)) {
            return value;
        } else {
            return fromSourceToDestination(mapping.destination(), destination, value);
        }
    }

    public long fromDestinationToSource(String destination, String source, long value) {
        Mapping mapping = mappingTo(destination);
        value = mapping.mapToSource(value);
        if (mapping.source().equals(source)) {
            return value;
        } else {
            return fromDestinationToSource(mapping.source(), source, value);
        }
    }

    public long lowestLocation() {
        return seeds.stream()
                .map(s -> fromSourceToDestination("seed", "location", s))
                .min(Long::compareTo)
                .orElse(0L);
    }

    /**
     * This method gives the correct answer to Puzzle 5.2 (2520479),
     * but it takes way too much time (like 45+ min.)
     */
    public long lowestLocationFromSeedRange() {
        long min = Long.MAX_VALUE;
        for (Iterator<Long> it = seeds.iterator(); it.hasNext();) {
            long start = it.next();
            long length = it.next();
            System.out.println("Start " + start + ", length " + length);
            for (long l = start; l < start+length; l++) {
                min = Math.min(min, fromSourceToDestination("seed", "location", l));
            }
        }
        return min;
    }

    /**
     * Ok, this is fast enough for now... (like 5 sec.)
     */
    public long lowestLocationFromLocations() {
        long location = 0;
        boolean found = false;
        while (!found) {
            long seed = fromDestinationToSource("location", "seed", location);
            if (isValidSeed(seed)) {
                found = true;
            } else {
                location++;
            }
        }
        return location;
    }

    public boolean isValidSeed(long seed) {
        for (Iterator<Long> it = seeds.iterator(); it.hasNext();) {
            long start = it.next();
            long length = it.next();
            if (seed >= start && seed < start+length) {
                return true;
            }
        }
        return false;
    }

}
