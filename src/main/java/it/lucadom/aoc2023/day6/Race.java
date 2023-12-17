package it.lucadom.aoc2023.day6;

public record Race(int time, int bestDistance) {
    public int wins() {
        int wins = 0;
        int distance = 0;
        int hold=0;
        while (distance <= bestDistance && hold <= time) {
            hold++;
            distance = hold * (time - hold);
        };
        if (hold <= time) {
            do {
                wins++;
                hold++;
                distance = hold * (time - hold);
            } while (distance > bestDistance && hold <= time);
        }
        return wins;
    }

}
