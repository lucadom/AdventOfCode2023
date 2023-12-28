package it.lucadom.aoc2023.day6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Races(List<Race> race) {

    public static Races fromInput(List<String> input) {
        List<BigInteger> times = Arrays.stream(input.get(0).split(":")[1].trim().split("\\s+"))
                .map(BigInteger::new)
                .toList();
        List<BigInteger> distances = Arrays.stream(input.get(1).split(":")[1].trim().split("\\s+"))
                .map(BigInteger::new)
                .toList();
        List<Race> races = new ArrayList<>();
        for (int i=0; i<times.size(); i++) {
            races.add(new Race(times.get(i), distances.get(i)));
        }
        return new Races(races);
    }

    public BigInteger beatenTogether() {
        return race.stream().map(Race::wins).reduce(BigInteger.valueOf(1), BigInteger::multiply);
    }
}
