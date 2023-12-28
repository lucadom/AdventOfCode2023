package it.lucadom.aoc2023.day6;

import java.math.BigInteger;
import java.util.List;

public record Race(BigInteger time, BigInteger bestDistance) {
    public static Race fromInput(List<String> input) {
        BigInteger time = new BigInteger(input.get(0).split(":")[1].replaceAll("\\s", ""));
        BigInteger distance = new BigInteger(input.get(1).split(":")[1].replaceAll("\\s", ""));
        return new Race(time, distance);
    }

    public BigInteger wins() {
        BigInteger wins = BigInteger.valueOf(0);
        BigInteger distance = BigInteger.valueOf(0);
        BigInteger hold = BigInteger.valueOf(0);
        while (distance.compareTo(bestDistance) <= 0 && hold.compareTo(time) <= 0) {
            hold = hold.add(BigInteger.ONE);
            distance = hold.multiply(time.subtract(hold));
        }
        if (hold.compareTo(time) <= 0) {
            do {
                wins = wins.add(BigInteger.ONE);
                hold = hold.add(BigInteger.ONE);
                distance = hold.multiply(time.subtract( hold));
            } while (distance.compareTo(bestDistance) > 0 && hold.compareTo(time) <= 0);
        }
        return wins;
    }

}
