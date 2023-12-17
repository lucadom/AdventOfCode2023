package it.lucadom.aoc2023.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Races(List<Race> race) {

    public static Races fromInput(List<String> input) {
        int[] times = Arrays.stream(input.get(0).split(":")[1].trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] distances =  Arrays.stream(input.get(1).split(":")[1].trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Race> races = new ArrayList<>();
        for (int i=0; i<times.length; i++) {
            races.add(new Race(times[i], distances[i]));
        }
        return new Races(races);
    }

    public long beatenTogether() {
        return race.stream().mapToLong(Race::wins).reduce(1, (a, b) -> a*b);
    }
}
